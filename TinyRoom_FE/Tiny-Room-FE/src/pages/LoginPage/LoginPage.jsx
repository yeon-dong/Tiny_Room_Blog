import React, { useState } from "react";
import axios from "axios";
import {
  BottomText,
  Container,
  FindIDText,
  FormContainer,
  LoginBox,
  LoginBtn,
  LoginErrorMsg,
  LoginInput_ID,
  LoginInput_Password,
  LoginTextContainer,
  SignUpText,
} from "./LoginPage.style";
import { useNavigate } from "react-router-dom";
import useStore from "../../stores/store.js";

function LoginPage() {
  const navigate = useNavigate();
  const { setUserId } = useStore(); // setUserId 가져오기
  const [idPlaceholder, setIdPlaceholder] = useState("이메일을 입력하세요.");
  const [pwPlaceholder, setPwPlaceholder] = useState("비밀번호를 입력하세요.");
  const [username, setUsername] = useState(""); // 사용자 이름 상태
  const [password, setPassword] = useState(""); // 비밀번호 상태
  const [errorMessage, setErrorMessage] = useState(""); // 에러 메시지 상태

  const handleLogin = async () => {
    // 입력값 검사
    if (!username || !password) {
      setErrorMessage("이메일과 비밀번호를 입력하세요."); // 입력값이 없을 경우 에러 메시지 설정
      return;
    }

    try {
      const response = await axios.post("http://localhost:8080/login", {
        username: username,
        password: password,
      });
      if (response.data.flag) {
        console.log("로그인 성공:", response.data);
        setUserId(response.data.id); // ID를 전역 상태로 저장
        // 로그인 성공 후 처리 (예: 리다이렉트, 토큰 저장 등)
        setErrorMessage(""); // 성공 시 에러 메시지 초기화
        navigate("/");
      } else {
        setErrorMessage("아이디 또는 비밀번호가 일치하지 않습니다.");
      }
    } catch (error) {
      console.error("로그인 실패:", error);
      setErrorMessage("로그인 실패"); // 에러 메시지 설정
    }
  };

  return (
    <Container>
      <LoginBox>
        <LoginTextContainer></LoginTextContainer>
        <FormContainer>
          <LoginInput_ID
            type="text"
            id="login-id"
            placeholder={idPlaceholder}
            onFocus={() => setIdPlaceholder("")}
            onBlur={() => setIdPlaceholder("이메일을 입력하세요.")}
            value={username} // 사용자 이름 상태를 value로 설정
            onChange={(e) => setUsername(e.target.value)}
          />
          <LoginInput_Password
            type="password"
            id="login-pw"
            placeholder={pwPlaceholder}
            onFocus={() => setPwPlaceholder("")}
            onBlur={() => setPwPlaceholder("비밀번호를 입력하세요.")}
            value={password} // 비밀번호 상태를 value로 설정
            onChange={(e) => setPassword(e.target.value)}
          />
          {errorMessage && <LoginErrorMsg>{errorMessage}</LoginErrorMsg>}
        </FormContainer>
        <LoginBtn onClick={handleLogin}>로그인</LoginBtn>
        <BottomText>
          <FindIDText>아이디 비밀번호 찾기</FindIDText>
          <SignUpText to="/signup">회원가입</SignUpText>
        </BottomText>
      </LoginBox>
    </Container>
  );
}

export default LoginPage;
