package com.tinyroom.spring.member.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tinyroom.spring.blog.dto.BlogDto;
import com.tinyroom.spring.blog.service.BlogService;
import com.tinyroom.spring.member.domain.Member;
import com.tinyroom.spring.member.dto.MemberDto;
import com.tinyroom.spring.member.service.MemberService;
import com.tinyroom.spring.room.dto.RoomDto;
import com.tinyroom.spring.room.service.RoomService;
import com.tinyroom.spring.security.TokenProvider;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@CrossOrigin(origins = "*")
@RestController	// RESTful 웹 서비스의 컨트롤러임을 나타내는 어노테이션
public class MemberController {
    
	// 프로필 이미지를 저장할 경로
   private final String FOLDER_PATH = "c:\\tinyroomImages\\";
	
	// MemberService의 메서드를 사용하기 위해 MemberService 자동으로 주입
	@Autowired
	private MemberService service;
	
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private TokenProvider provider;
	
	@Autowired
	private AuthenticationManagerBuilder abuilder;
	
	// 회원가입 기능(form 형태로 데이터를 받아온다는 가정에서 @RequestParam으로 인자 받아옴 -> 이미지는 json으로 넘길수가 없음)
	@PostMapping("/register")
	public ResponseEntity<?> memberRegister(
			@RequestParam("email") String email,
			@RequestParam("pw") String pw,
			@RequestParam("name") String name,
			@RequestParam("nickname") String nickname,
			@RequestParam("phone_number") String phone_number,
			@RequestParam("description") String description,
			@RequestParam("blog_title") String blog_title,
			@RequestParam("blog_theme") int blog_theme,
			@RequestParam(value="profile_img", required = false) MultipartFile profile_img,
			HttpServletResponse response
			) {
		
		log.info("##############################" + profile_img + "##################################");
		
		String imageName;
		String newName;
	   if(profile_img == null) {
		   imageName = "Group 46.svg";
	   } else {
		   String[] temp = profile_img.getOriginalFilename().split(" .");
		   String extension = temp[temp.length - 1];
		   LocalDateTime current = LocalDateTime.now();
		   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		   imageName = current.format(formatter) + "." + extension;
		   
	      log.info("upload file : " + imageName);
	      
	      String filePath;
		    String os = System.getProperty("os.name").toLowerCase();
		    if(os.contains("win")) {
		    	filePath = FOLDER_PATH + imageName;
		    } else {
		    	filePath = System.getProperty("user.dir") + "/files/image/" + imageName;
		  }
	      
		  try {
			profile_img.transferTo(new File(filePath));
			} catch (IllegalStateException e) {
			e.printStackTrace();
		  } catch (IOException e) {
			  e.printStackTrace();
		  }
	   }
		
		// 회원가입에 필요한 정보를 담을 Map
		Map<String, String> member = new HashMap<>();
		
		// 우선 회원가입에 필요한 정보들을 member라는 map에 담음
		member.put("email", email);
		member.put("pw", pw);
		member.put("name", name);
		member.put("nickname", nickname);
		member.put("phone_number", phone_number);
		member.put("description", description);
		member.put("blog_title", blog_title);
		member.put("blog_theme", blog_theme + "");
		member.put("profile_img", "/image/" + imageName);
		
		// Map에 데이터 입력 후 다음 단계 진행된다는 것 확인하기 위한 로그
		log.info("************************* register controller *******************************");
		
		// MemberService의 회원가입 메서드 실행(member Map 을 인자로 넘김)
		Map map;
		try {
			map = service.registerMember(member);
		} catch (Exception e) {
			map = new HashMap<>();
			map.put("result", false);
		}
		
		return ResponseEntity.status(HttpStatus.OK).header("Location", "/login").body(map);
	}
	
	@PostMapping("/login")
	public Map login(@RequestBody HashMap<String, String> map) {
		//인증에 사용할 객체. Username / Password 를 비교하여 인증하는 클래스
		UsernamePasswordAuthenticationToken authtoken = new UsernamePasswordAuthenticationToken(map.get("username"), map.get("password"));
		
		boolean flag;
		//authenticate() 인증 메서드. 인증한 결과를 Authentication에 담아 반환
			// 여기서 에러 발생
		try {
			Authentication auth = abuilder.getObject().authenticate(authtoken);
			flag = auth.isAuthenticated();
		} catch(Exception e) {
			flag = false;
		}
		
		Map result = new HashMap<>();
		
		String email = map.get("username");
		
		MemberDto member = service.getMember(email);
		
		if (flag) {
			result.put("id", member.getMember_id());
			result.put("email", member.getEmail());
			result.put("name", member.getName());
			result.put("nickname", member.getNickname());
			result.put("phone_number", member.getPhone_number());
			result.put("profileImg", member.getProfile_img());
			result.put("description", member.getDescription());
			//인증 성공시 토큰 생성
			String token = provider.getToken(member);
//			String token = provider.getToken(service.getMember(email));
			//토큰을 요청자에게 전달
			result.put("token", token);
			String type = provider.getRoles(token);
			result.put("type", type);
		}
		result.put("flag", flag);
		return result;
	}
	
	//내정보확인
	@GetMapping("/member/info")
	public Map getMemberInfo() {
		log.info("############################### /member/info ##############################");
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName(); // username 추출
		
		MemberDto member = service.getMember(email);
		
		log.info(member);
		
		Map map = new HashMap();
		
		map.put("id", member.getMember_id());
		map.put("email", member.getEmail());
		map.put("name", member.getName());
		map.put("nickname", member.getNickname());
		map.put("phone_number", member.getPhone_number());
		map.put("profile_img", member.getProfile_img());
		map.put("description", member.getDescription());
		map.put("type", member.getType());
		
		return map;
	}
	
	// 회원정보 수정 기능(form 형태로 데이터를 받아온다는 가정에서 @RequestParam으로 인자 받아옴)
	@PutMapping("/member/modify")
	public ResponseEntity<?> modifyMemberInfo(
				@RequestParam("name") String name,
				@RequestParam("nickname") String nickname,
				@RequestParam("description") String description,
				@RequestParam("blogTheme") int blog_theme,
				@RequestParam("roomTheme") int room_theme,
				@RequestParam("furniture1") int furniture1,
				@RequestParam("furniture2") int furniture2,
				@RequestParam("furniture3") int furniture3,
				@RequestParam("furniture4") int furniture4,
				@RequestParam(value="profile_img", required = false) MultipartFile profile_img
				) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String username = auth.getName(); // username 추출
			
			String imageName;
			   
		   if(profile_img == null) {
			   imageName = "Group 46.svg";
		   } else {
			   String[] temp = profile_img.getOriginalFilename().split(" .");
			   String extension = temp[temp.length - 1];
			   LocalDateTime current = LocalDateTime.now();
			   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
			   imageName = current.format(formatter) + "." + extension;
			   
		       log.info("upload file : " + imageName);
		      
		       String filePath;
			    String os = System.getProperty("os.name").toLowerCase();
			    if(os.contains("win")) {
			    	filePath = FOLDER_PATH + imageName;
			    } else {
			    	filePath = System.getProperty("user.dir") + "/files/image/" + imageName;
			  }
		      
		       try {
		    	   profile_img.transferTo(new File(filePath));
		       } catch (IllegalStateException e) {
		    	   e.printStackTrace();
		       } catch (IOException e) {
		    	   e.printStackTrace();
		       }
		   }
			   
			   log.info("upload file : " + imageName);
			
			// name, nickname, description은 Member 엔티티의 정보를 수정하는 것이므로 여기에 넣을 것
			MemberDto member = service.getMember(username);
			
			member.setName(name);
			member.setNickname(nickname);
			member.setDescription(description);
			member.setProfile_img("/image/" + imageName);
			
			
			// blog_theme는 Blog 엔티티의 정보
			BlogDto blog = blogService.getBlog(service.dtoToEntity(member));
			
			blog.setBlog_theme(blog_theme);
			
			// room_theme, furniture1, furniture2, furniture3, furniture4는 Blog 엔티티의 정보
			RoomDto room = roomService.getRoom(blogService.blogDtoToEntity(blog)); 
			
			room.setRoom_theme(room_theme);
			room.setFurniture1(furniture1);
			room.setFurniture2(furniture2);
			room.setFurniture3(furniture3);
			room.setFurniture4(furniture4);
			
			
			// MemberService의 회원가입 메서드 실행(member Map 을 인자로 넘김)
			boolean modifyResult = false;
			try {
				modifyResult = service.updateMember(member, blog, room);
			} catch (IOException e) {
				modifyResult = false;
			}
			
			return ResponseEntity.status(HttpStatus.OK).body(modifyResult);
		}

}
