package com.tinyroom.spring.member.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tinyroom.spring.member.domain.Member;
import com.tinyroom.spring.member.dto.MemberDto;
import com.tinyroom.spring.member.service.MemberService;
import com.tinyroom.spring.member.service.MemberServiceImpl;
import com.tinyroom.spring.security.TokenProvider;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController	// RESTful 웹 서비스의 컨트롤러임을 나타내는 어노테이션
public class MemberController {
    
	// MemberService의 메서드를 사용하기 위해 MemberService 자동으로 주입
	@Autowired
	private MemberServiceImpl service;
	
	@Autowired
	private TokenProvider provider;
	
	@Autowired
	private AuthenticationManagerBuilder abuilder;
	
	// 회원가입 기능(form 형태로 데이터를 받아온다는 가정에서 @RequestParam으로 인자 받아옴)
	@PostMapping("/register")
	public ResponseEntity<?> memberRegister(
			@RequestParam("email") String email,
			@RequestParam("pw") String pw,
			@RequestParam("name") String name,
			@RequestParam("nickname") String nickname,
			@RequestParam("phone_number") String phone_number,
			@RequestParam("description") String description,
			@RequestParam("profile_img") MultipartFile profile_img
			) {
		// 회원가입에 필요한 정보를 담을 Map
		Map<String, String> member = new HashMap<>();
		
		// 우선 회원가입에 필요한 정보가 email, pw, name, nickname, phone_number라고 생각해서 우선 이렇게 해놓음
		member.put("email", email);
		member.put("pw", pw);
		member.put("name", name);
		member.put("nickname", nickname);
		member.put("phone_number", phone_number);
		member.put("description", description);
		
		// Map에 데이터 입력 후 다음 단계 진행된다는 것 확인하기 위한 로그
		log.info("************************* register controller *******************************");
		
		// MemberService의 회원가입 메서드 실행(member Map 을 인자로 넘김)
		String uploadResult = "";
		try {
			uploadResult = service.registerMember(member, profile_img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(uploadResult);
	}
	
	@PostMapping("/login")
	public Map<String, String> login(@RequestBody HashMap<String, String> map) {
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
			
		
		//isAuthenticated(): 인증결과 반환(true/false)
//		flag = auth.isAuthenticated();
		
		Map result = new HashMap<>();
		if (flag) {
			String id = map.get("username");
			//인증 성공시 토큰 생성
			String token = provider.getToken(service.getMember(id));
			//토큰을 요청자에게 전달
			map.put("token", token);
			map.put("id", id);
			String type = provider.getRoles(token);
			map.put("type", type);
		}
		map.put("flag", flag + "");
		return map;
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
		
		map.put("member_id", member.getMember_id());
		map.put("email", member.getEmail());
		map.put("pw", member.getPw());
		map.put("name", member.getName());
		map.put("nickname", member.getNickname());
		map.put("phone_number", member.getPhone_number());
		map.put("profile_img", member.getProfile_img());
		map.put("description", member.getDescription());
		map.put("is_active", member.getIs_active());
		
		return map;
	}
	
	// 회원정보 수정 기능(form 형태로 데이터를 받아온다는 가정에서 @RequestParam으로 인자 받아옴)
		@PutMapping("/member/modify")
		public ResponseEntity<?> modifyMemberInfo(
				@RequestParam("email") String email,
				@RequestParam("pw") String pw,
				@RequestParam("name") String name,
				@RequestParam("nickname") String nickname,
				@RequestParam("phone_number") String phone_number,
				@RequestParam("description") String description,
				@RequestParam("profile_img") MultipartFile profile_img
				) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String username = auth.getName(); // username 추출
			
			MemberDto member = service.getMember(username);
			
			// 회원가입에 필요한 정보를 담을 Map
			
			// 우선 회원가입에 필요한 정보가 email, pw, name, nickname, phone_number라고 생각해서 우선 이렇게 해놓음
			member.setEmail(email);
			member.setPw(pw);
			member.setName(name);
			member.setNickname(nickname);
			member.setPhone_number(phone_number);
			member.setDescription(description);
			
			// MemberService의 회원가입 메서드 실행(member Map 을 인자로 넘김)
			String modifyResult = "";
			try {
				modifyResult = service.updateMember(member, profile_img);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return ResponseEntity.status(HttpStatus.OK).body(modifyResult);
		}
}
