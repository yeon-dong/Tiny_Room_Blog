package com.tinyroom.spring.member.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.tinyroom.spring.blog.dto.BlogDto;
import com.tinyroom.spring.member.dao.MemberDao;
import com.tinyroom.spring.member.domain.Member;
import com.tinyroom.spring.member.dto.MemberDto;
import com.tinyroom.spring.post.domain.Post;
import com.tinyroom.spring.room.dto.RoomDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

public interface MemberService {
	
	public Map registerMember(Map<String, String> map) throws IOException;
	public boolean updateMember(MemberDto dto, BlogDto blog, RoomDto room) throws IOException;
	public MemberDto getMember(String email);
	public String uploadImage(MultipartFile img);
	public MemberDto getProfile(int id);
      
	default MemberDto entityMemberDto(Member member) {
		MemberDto memberDto = MemberDto.builder()
           .member_id(member.getMember_id())
           .email(member.getEmail())
           .pw(member.getPw())
           .name(member.getName())
           .nickname(member.getNickname())
           .phone_number(member.getPhone_number())
           .profile_img(member.getProfile_img())
           .description(member.getDescription())
           .is_active(member.getIs_active())
           .type(member.getType())
           .build();
     return memberDto;
	}
  
	default Member dtoToEntity(MemberDto memberDto) {
		Member member = Member.builder()
          .member_id(memberDto.getMember_id())
          .email(memberDto.getEmail())
          .pw(memberDto.getPw())
          .name(memberDto.getName())
          .nickname(memberDto.getNickname())
          .phone_number(memberDto.getPhone_number())
          .profile_img(memberDto.getProfile_img())
          .description(memberDto.getDescription())
          .is_active(memberDto.getIs_active())
          .type(memberDto.getType())
          .build();
      return member;
	}
   
}
