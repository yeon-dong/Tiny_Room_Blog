package com.tinyroom.spring.member.service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.tinyroom.spring.blog.dao.BlogDao;
import com.tinyroom.spring.blog.domain.Blog;
import com.tinyroom.spring.blog.dto.BlogDto;
import com.tinyroom.spring.blog.service.BlogService;
import com.tinyroom.spring.member.dao.MemberDao;
import com.tinyroom.spring.member.domain.Member;
import com.tinyroom.spring.member.dto.MemberDto;
import com.tinyroom.spring.room.dao.RoomDao;
import com.tinyroom.spring.room.domain.Room;
import com.tinyroom.spring.room.dto.RoomDto;
import com.tinyroom.spring.room.service.RoomService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class MemberServiceImpl implements MemberService{
	
	private final String FOLDER_PATH = "c:\\tinyroomImages\\";
   
   @Autowired
	private BlogService blogService;
	
	@Autowired
	private RoomService roomService;
	
   // MemberDao 사용하기 위해 MemberDao 자동으로 주입
   @Autowired
   private MemberDao dao;
   
   @Autowired
   private BlogDao blogDao;
   
   @Autowired
   private RoomDao roomDao;
   
   // 패스워드 암호화를 위한 PasswordEncoder 자동으로 주입
   @Autowired
   private PasswordEncoder passwordEncoder;
   
   @Override
   @Transactional(rollbackFor=Exception.class)
// 회원가입(Member, Blog 두 개의 테이블에 insert하므로 transaction 필요
   public Map registerMember(Map<String, String> map) throws IOException {
     
      Map result = new HashMap<>();
      
      // Member 엔티티 생성
      Member member = Member.builder()
            .email(map.get("email"))
            .pw(passwordEncoder.encode(map.get("pw")))
            .name(map.get("name"))
            .nickname(map.get("nickname"))
            .phone_number(map.get("phone_number"))
            .profile_img(map.get("profile_img"))
            .is_active(1)
            .type("ROLE_USER")
            .description(map.get("description"))
            .build();
      
      Blog blog = Blog.builder()
    		  .member(member)
    		  .blog_title(map.get("blog_title"))
    		  .blog_theme(Integer.parseInt(map.get("blog_theme")))
    		  .build();
      
      Room room = Room.builder()
    		  .blog(blog)
    		  .room_theme(0)
    		  .furniture1(0)
    		  .furniture2(0)
    		  .furniture3(0)
    		  .furniture4(0)
    		  .build();
      
      // 생성한 엔티티를 dao로 넘겨서 데이터 저장
      try {
    	  dao.save(member);
          blogDao.save(blog);
          roomDao.save(room);
          
          log.info("##########################################################file uploaded success!!!");
          
          result.put("result", true);
          result.put("imageUrl", map.get("profile_img"));
      } catch (Exception e){
    	  log.error("회원 가입에 실패했습니다 : " + e.getMessage());
    	  throw e;
      }
      
      return result;
   }
   
// 회원가입
   @Transactional(rollbackFor = Exception.class)
   public boolean updateMember(MemberDto dto, BlogDto blogDto, RoomDto roomDto) throws IOException {
      
   // Member 엔티티 생성
      Member member = dtoToEntity(dto);
      Blog blog = blogService.blogDtoToEntity(blogDto);
      Room room = roomService.roomDtoToEntity(roomDto);
      
      
      // 생성한 엔티티를 dao로 넘겨서 데이터 저장
      try {
    	  dao.save(member);
    	  blogDao.save(blog);
    	  roomDao.save(room);
    	  
    	  log.info("##########################################################file uploaded success!!!" );
    	  
    	  return true;
      } catch(Exception e) {
    	  log.info("#############################################################회원 정보 수정 실패");
    	  throw e;
      }
   }

   @Override
   public MemberDto getMember(String id) {
      // dao.findById(pk): pk기준으로 검색
      Member m = dao.findByEmail(id).orElse(null);// orElse(null): 검색결과 없으면 널 반환
      
      if (m == null) {
         return null;
      }
      return entityMemberDto(m);
   }

@Override
public String uploadImage(MultipartFile img) {
	String[] temp = img.getOriginalFilename().split(" .");
	String extension = temp[temp.length - 1];
	LocalDateTime current = LocalDateTime.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
	String imageName = current.format(formatter) + "." + extension;

	   
    log.info("upload file : " + imageName);
    
    String filePath;
    String os = System.getProperty("os.name").toLowerCase();
    if(os.contains("win")) {
    	filePath = FOLDER_PATH + imageName;
    } else {
    	filePath = System.getProperty("user.dir") + "/files/image/" + imageName;
    }
    
    
    
    try {
		img.transferTo(new File(filePath));
	} catch (IllegalStateException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	return "/image/" + imageName;
}

@Override
public MemberDto getProfile(int id) {
	// dao.findById(pk): pk기준으로 검색
    Member member = dao.findById(id).orElse(null);// orElse(null): 검색결과 없으면 널 반환
    
    if (member == null) {
       return null;
    }
    return entityMemberDto(member);
}

}
