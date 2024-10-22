import React, { useState } from "react";
import {
  BlogProfileIMG,
  BlogProfileInfoContainer,
  BlogProfileInfoInput,
  BlogProfileInfoText,
  BlogProfileInfoWrap,
  BlogProfileText,
  BlogProfileUploadBtn,
  BlogProfileUploadContainer,
  Container,
  NextBtn,
  SignUpBox,
  SignUpInnerBox,
  SignUpStep,
  SignUpText,
} from "./SignUpPage2.style";

function SignUpPage2() {
  const [namePlaceholder, setNamePlaceholder] = useState(
    "한글, 영문, 숫자 혼용 가능(한글 기준 8자 이내)"
  );
  const [nicknamePlaceholder, setNicknamePlaceholder] = useState(
    "한글, 영문, 숫자 혼용 가능(한글 기준 8자 이내)"
  );

  return (
    <Container>
      <SignUpBox>
        <SignUpInnerBox>
          <SignUpText>Join Us</SignUpText>
          <BlogProfileText>블로그 프로필</BlogProfileText>
          <BlogProfileIMG src="/images/Group 46.svg" />
          <BlogProfileUploadContainer>
            <BlogProfileUploadBtn src="/images/Frame 11.svg" />
            <BlogProfileUploadBtn src="/images/Frame 12.svg" />
          </BlogProfileUploadContainer>
          <BlogProfileInfoContainer>
            <BlogProfileInfoWrap>
              <BlogProfileInfoText>이름</BlogProfileInfoText>
              <BlogProfileInfoInput
                type="text"
                id="signup-name"
                placeholder={namePlaceholder}
                onFocus={() => setNamePlaceholder("")}
                onBlur={() =>
                  setNamePlaceholder(
                    "한글, 영문, 숫자 혼용 가능(한글 기준 8자 이내)"
                  )
                }
              />
            </BlogProfileInfoWrap>
            <BlogProfileInfoWrap>
              <BlogProfileInfoText>닉네임</BlogProfileInfoText>
              <BlogProfileInfoInput
                type="text"
                id="signup-name"
                placeholder={nicknamePlaceholder}
                onFocus={() => setNicknamePlaceholder("")}
                onBlur={() =>
                  setNicknamePlaceholder(
                    "한글, 영문, 숫자 혼용 가능(한글 기준 8자 이내)"
                  )
                }
              />
            </BlogProfileInfoWrap>
          </BlogProfileInfoContainer>
          <NextBtn>다음</NextBtn>
        </SignUpInnerBox>

        <SignUpStep src="/images/signup2step.svg" />
      </SignUpBox>
    </Container>
  );
}

export default SignUpPage2;
