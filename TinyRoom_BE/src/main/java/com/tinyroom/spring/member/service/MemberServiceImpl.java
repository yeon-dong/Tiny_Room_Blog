package com.tinyroom.spring.member.service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.tinyroom.spring.blog.dao.BlogDao;
import com.tinyroom.spring.blog.domain.Blog;
import com.tinyroom.spring.member.dao.MemberDao;
import com.tinyroom.spring.member.domain.Member;
import com.tinyroom.spring.member.dto.MemberDto;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class MemberServiceImpl implements MemberService{
   
   // 프로필 이미지를 저장할 경로
   private final String FOLDER_PATH = "c:\\profile_images\\";

	
   // MemberDao 사용하기 위해 MemberDao 자동으로 주입
   @Autowired
   private MemberDao dao;
   
   @Autowired
   private BlogDao blogDao;
   
   // 패스워드 암호화를 위한 PasswordEncoder 자동으로 주입
   @Autowired
   private PasswordEncoder passwordEncoder;
   
   @Override
   @Transactional(rollbackFor=Exception.class)
// 회원가입(Member, Blog 두 개의 테이블에 insert하므로 transaction 필요
   public boolean registerMember(Map<String, String> map, MultipartFile profile_img) throws IOException {
      
      log.info("upload file : " + profile_img.getOriginalFilename());
      
      String filePath = FOLDER_PATH + profile_img.getOriginalFilename();
      
      profile_img.transferTo(new File(filePath));
      
      
      // Member 엔티티 생성
      Member member = Member.builder()
            .email(map.get("email"))
            .pw(passwordEncoder.encode(map.get("pw")))
            .name(map.get("name"))
            .nickname(map.get("nickname"))
            .phone_number(map.get("phone_number"))
            .profile_img(filePath)
            .is_active(1)
            .type("ROLE_USER")
            .description(map.get("description"))
            .build();
      
      Blog blog = Blog.builder()
    		  .member(member)
    		  .blog_title(map.get("blog_title"))
    		  .blog_theme(Integer.parseInt(map.get("blog_theme")))
    		  .build();
      log.info("############################## 여기까진 문제 없음 ############################################");
      // 생성한 엔티티를 dao로 넘겨서 데이터 저장
      try {
    	  dao.save(member);
          blogDao.save(blog);
          
          if(filePath != null) {
              log.info("이미지 파일 저장에 성공했습니다.");
           }
          
          return true;
      } catch (Exception e){
    	  log.error("회원 가입에 실패했습니다 : " + e.getMessage());
    	  throw e;
      }
   }
   
// 회원가입
   public String updateMember(MemberDto dto, MultipartFile profile_img) throws IOException {
      
      log.info("upload file : " + profile_img.getOriginalFilename());
      
      String filePath = FOLDER_PATH + profile_img.getOriginalFilename();
      
      profile_img.transferTo(new File(filePath));
      
      
      // Member 엔티티 생성
      Member member = Member.builder()
            .email(dto.getEmail())
            .pw(passwordEncoder.encode(dto.getPw()))
            .name(dto.getName())
            .nickname(dto.getNickname())
            .phone_number(dto.getPhone_number())
            .profile_img(filePath)
            .is_active(dto.getIs_active())
            .type(dto.getType())
            .description(dto.getDescription())
            .build();
      
      // 생성한 엔티티를 dao로 넘겨서 데이터 저장
      dao.save(member);
      
      if(filePath != null) {
         return "file uploaded success!!!!" + filePath;
      }
      
      return null;
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

}
