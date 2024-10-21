package com.tinyroom.spring.security.util;

//사용자 정의 JWT 예외 클래스
public class CustomJWTException extends RuntimeException {
	// 생성자: 예외 메시지를 매개변수로 받아 부모 클래스의 생성자에 전달
	public CustomJWTException(String msg) {
	      super(msg); // RuntimeException의 생성자 호출
	  }
}
