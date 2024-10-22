package com.tinyroom.spring.member.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tinyroom.spring.member.domain.Member;
import com.tinyroom.spring.member.domain.MemberRole;
import com.tinyroom.spring.member.dto.MemberDto;
import com.tinyroom.spring.member.dto.MemberLoginRequestDto;
import com.tinyroom.spring.member.service.MemberService;
import com.tinyroom.spring.security.util.JWTUtil;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController	// RESTful 웹 서비스의 컨트롤러임을 나타내는 어노테이션
@RequestMapping("/members")	// "/members"로 시작하는 경로에 대한 요청을 처리하는 클래스(누구나 접근 가능한 경로)
public class MemberController {
    
	// MemberService의 메서드를 사용하기 위해 MemberService 자동으로 주입
	@Autowired
	private MemberService memberService;
	
	// 회원가입 기능(form 형태로 데이터를 받아온다는 가정에서 @RequestParam으로 인자 받아옴)
	@PostMapping("/register")
	public void login(
			@RequestParam("email") String email,
			@RequestParam("pw") String pw,
			@RequestParam("name") String name,
			@RequestParam("nickname") String nickname,
			@RequestParam("phone_number") String phone_number
			) {
		// 회원가입에 필요한 정보를 담을 Map
		Map<String, String> member = new HashMap<>();
		
		// 우선 회원가입에 필요한 정보가 email, pw, name, nickname, phone_number라고 생각해서 우선 이렇게 해놓음
		member.put("email", email);
		member.put("pw", pw);
		member.put("name", name);
		member.put("nickname", nickname);
		member.put("phone_number", phone_number);
		
		// Map에 데이터 입력 후 다음 단계 진행된다는 것 확인하기 위한 로그
		log.info("************************* register controller *******************************");
		
		// MemberService의 회원가입 메서드 실행(member Map 을 인자로 넘김)
		memberService.register(member);
	}
}
