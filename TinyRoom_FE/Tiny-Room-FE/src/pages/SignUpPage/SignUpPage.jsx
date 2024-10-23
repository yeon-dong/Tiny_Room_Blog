import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import {
  BottomContainer,
  CheckBtn,
  CheckText,
  Container,
  LoginErrorMsg,
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
import useStore from "../../stores/store.js"; // Zustand 스토어 import

function SignUpPage() {
  const navigate = useNavigate();
  const { setSignUpEmail, setSignUpPassword, setSignUpPhone } = useStore();
  const [idPlaceholder, setIdPlaceholder] = useState("이메일 주소");
  const [pwPlaceholder, setPwPlaceholder] = useState("비밀번호");
  const [phonePlaceholder, setPhonePlaceholder] = useState("휴대폰 전화번호");
  const [checkBtnSrc, setCheckBtnSrc] = useState("/images/Check Mark.svg");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [phone, setPhone] = useState("");
  const [errorMsg, setErrorMsg] = useState([]);
  const [isEmailValid, setIsEmailValid] = useState(true); // 이메일 유효성 상태
  const [isPasswordValid, setIsPasswordValid] = useState(true); // 비밀번호 유효성 상태
  const [isPhoneValid, setIsPhoneValid] = useState(true); // 핸드폰 번호 유효성 상태

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
      if (validateInputs()) {
        setSignUpEmail(email);
        setSignUpPassword(password);
        setSignUpPhone(phone);
        //zustand에 저장
        setTimeout(() => {
          navigate("/signup2");
        }, 200);
      }
    }
  };

  const validateInputs = () => {
    let isValid = true;
    setIsEmailValid(true);
    setIsPasswordValid(true);
    setIsPhoneValid(true);
    setErrorMsg([]);

    // 이메일 유효성 검사
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(email)) {
      setErrorMsg((prev) => [...prev, "유효한 이메일 주소를 입력하세요."]);
      setIsEmailValid(false);
      isValid = false;
    }

    // 비밀번호 유효성 검사
    const passwordRegex = /^(?=.*[~!*^&])[A-Za-z\d~!*^&]{8,}$/;
    if (!passwordRegex.test(password)) {
      setErrorMsg((prev) => [
        ...prev,
        "비밀번호는 8자 이상이며, 특수문자(~!*^)를 포함해야 합니다.",
      ]);
      setIsPasswordValid(false);
      isValid = false;
    }

    // 핸드폰 번호 유효성 검사
    if (phone.length !== 11) {
      setErrorMsg((prev) => [...prev, "핸드폰 번호는 11자리여야 합니다."]);
      setIsPhoneValid(false);
      isValid = false;
    }

    return isValid;
  };

  return (
    <>
      <Container>
        <SignUpBox>
          <SignUpInnerBox>
            <SignUpText>Join Us</SignUpText>
            <SignUpInfoContainer>
              <SignUpInputWrap>
                <SignUpInputIMG
                  src={
                    isEmailValid
                      ? "/images/Male User.svg"
                      : "/images/Male User2.svg"
                  }
                />
                <SignUpInfo_Email
                  type="text"
                  id="signup-id"
                  placeholder={idPlaceholder}
                  value={email}
                  onChange={(e) => setEmail(e.target.value)}
                  onFocus={() => setIdPlaceholder("")}
                  onBlur={() => setIdPlaceholder("이메일 주소")}
                  $isEmailValid={isEmailValid}
                  $isPasswordValid={isPasswordValid}
                />
              </SignUpInputWrap>
              <SignUpInputWrap>
                <SignUpInputIMG
                  src={
                    isPasswordValid
                      ? "/images/Password.svg"
                      : "/images/Password2.svg"
                  }
                />
                <SignUpInfo_Password
                  type="password"
                  id="signup-pw"
                  placeholder={pwPlaceholder}
                  value={password}
                  onChange={(e) => setPassword(e.target.value)}
                  onFocus={() => setPwPlaceholder("")}
                  onBlur={() => setPwPlaceholder("비밀번호")}
                  $isPasswordValid={isPasswordValid}
                  $isPhoneValid={isPhoneValid}
                />
              </SignUpInputWrap>
              <SignUpInputWrap>
                <SignUpInputIMG
                  src={
                    isPhoneValid
                      ? "/images/iPhone 14.svg"
                      : "/images/iPhone 142.svg"
                  }
                />
                <SignUpInfo_Phone
                  type="text"
                  id="signup-phone"
                  placeholder={phonePlaceholder}
                  value={phone}
                  onChange={(e) => setPhone(e.target.value)}
                  onFocus={() => setPhonePlaceholder("")}
                  onBlur={() => setPhonePlaceholder("휴대폰 전화번호")}
                  $isPhoneValid={isPhoneValid} //border props 넘겨주기
                />
              </SignUpInputWrap>
              {errorMsg.length > 0 && (
                <LoginErrorMsg>
                  {errorMsg.map((error, index) => (
                    <div key={index} style={{ marginTop: "4px" }}>
                      {error}
                    </div>
                  ))}
                </LoginErrorMsg>
              )}
            </SignUpInfoContainer>
            <BottomContainer>
              <CheckBtn src={checkBtnSrc} onClick={handleCheckBtnClick} />
              <CheckText>인증 약관 전체 동의</CheckText>
            </BottomContainer>
            <NextBtn
              $isClickable={checkBtnSrc === "/images/Check Mark2.svg"} // props 전달
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
