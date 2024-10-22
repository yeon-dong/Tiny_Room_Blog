import React, { useState } from "react";
import {
  BottomText,
  Container,
  FindIDText,
  FormContainer,
  LoginBox,
  LoginBtn,
  LoginInput_ID,
  LoginInput_Password,
  LoginTextContainer,
  SignUpText,
} from "./LoginPage.style";

function LoginPage() {
  const [idPlaceholder, setIdPlaceholder] = useState("이메일을 입력하세요.");
  const [pwPlaceholder, setPwPlaceholder] = useState("비밀번호를 입력하세요.");
  return (
    <>
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
            />
            <LoginInput_Password
              type="password"
              id="login-pw"
              placeholder={pwPlaceholder}
              onFocus={() => setPwPlaceholder("")}
              onBlur={() => setPwPlaceholder("비밀번호를 입력하세요.")}
            />
          </FormContainer>
          <LoginBtn>로그인</LoginBtn>
          <BottomText>
            <FindIDText>아이디 비밀번호 찾기</FindIDText>
            <SignUpText>회원가입</SignUpText>
          </BottomText>
        </LoginBox>
      </Container>
    </>
  );
}

export default LoginPage;
