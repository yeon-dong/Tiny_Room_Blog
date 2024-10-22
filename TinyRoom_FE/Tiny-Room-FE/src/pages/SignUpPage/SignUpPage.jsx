import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import {
  BottomContainer,
  CheckBtn,
  CheckText,
  Container,
  NextBtn,
  SignUpBox,
  SignUpInfo_Email,
  SignUpInfo_Password,
  SignUpInfo_Phone,
  SignUpInfoContainer,
  SignUpInnerBox,
  SignUpInputIMG,
  SignUpInputWrap,
  SignUpStep,
  SignUpText,
} from "./SignUpPage.style";

function SignUpPage() {
  const navigate = useNavigate();
  const [idPlaceholder, setIdPlaceholder] = useState("이메일 주소");
  const [pwPlaceholder, setPwPlaceholder] = useState("비밀번호");
  const [phonePlaceholder, setPhonePlaceholder] = useState("휴대폰 전화번호");
  const [checkBtnSrc, setCheckBtnSrc] = useState("/images/Check Mark.svg");

  const handleCheckBtnClick = () => {
    // 체크 버튼 클릭시 src 변경
    setCheckBtnSrc((prevSrc) =>
      prevSrc === "/images/Check Mark.svg"
        ? "/images/Check Mark2.svg"
        : "/images/Check Mark.svg"
    );
  };

  const handleNextBtnClick = () => {
    if (checkBtnSrc === "/images/Check Mark2.svg") {
      navigate("/signup2"); // "/signup2"로 이동
    }
  };

  return (
    <>
      <Container>
        <SignUpBox>
          <SignUpInnerBox>
            <SignUpText>Join Us</SignUpText>
            <SignUpInfoContainer>
              <SignUpInputWrap>
                <SignUpInputIMG src="/images/Male User.svg" />
                <SignUpInfo_Email
                  type="text"
                  id="signup-id"
                  placeholder={idPlaceholder}
                  onFocus={() => setIdPlaceholder("")}
                  onBlur={() => setIdPlaceholder("이메일 주소")}
                />
              </SignUpInputWrap>
              <SignUpInputWrap>
                <SignUpInputIMG src="/images/Password.svg" />
                <SignUpInfo_Password
                  type="password"
                  id="signup-pw"
                  placeholder={pwPlaceholder}
                  onFocus={() => setPwPlaceholder("")}
                  onBlur={() => setPwPlaceholder("비밀번호")}
                />
              </SignUpInputWrap>
              <SignUpInputWrap>
                <SignUpInputIMG src="/images/iPhone 14.svg" />
                <SignUpInfo_Phone
                  type="text"
                  id="signup-phone"
                  placeholder={phonePlaceholder}
                  onFocus={() => setPhonePlaceholder("")}
                  onBlur={() => setPhonePlaceholder("휴대폰 전화번호")}
                />
              </SignUpInputWrap>
            </SignUpInfoContainer>
            <BottomContainer>
              <CheckBtn src={checkBtnSrc} onClick={handleCheckBtnClick} />
              <CheckText>인증 약관 전체 동의</CheckText>
            </BottomContainer>
            <NextBtn
              isClickable={checkBtnSrc === "/images/Check Mark2.svg"} // props 전달
              onClick={handleNextBtnClick}
            >
              다음
            </NextBtn>
          </SignUpInnerBox>

          <SignUpStep src="/images/signup1step.svg" />
        </SignUpBox>
      </Container>
    </>
  );
}

export default SignUpPage;
