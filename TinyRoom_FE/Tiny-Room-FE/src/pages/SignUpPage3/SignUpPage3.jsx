import React, { useState } from "react";
import {
  BlogProfileInfoBigInput,
  BlogProfileInfoInput,
  BlogThemaSelect,
  BlogThemaSelectText,
  BlogThemaSelectWrap,
  BlogThemaText,
  Container,
  SignUpBox,
  SignUpInfoText,
  SignUpInfoWrap,
  SignUpInfoWrapThemaText,
  SignUpInnerBox,
  SignUpStep,
  SignUpText,
  SingUpFinshBtn,
} from "./SignUpPage3.style";

function SignUpPage3() {
  const [blogNamePlaceholder, setBlogNamePlaceholder] = useState(
    "한글, 영문, 숫자 혼용 가능(한글 기준 8자 이내)"
  );
  const [infoTextholder, setinfoTextholder] = useState(
    "블로그 프로필 영역의 프로필 이미지 아래에 반영됩니다.(한글 기준 200자 이내)"
  );
  return (
    <Container>
      <SignUpBox>
        <SignUpInnerBox>
          <SignUpText>Join Us</SignUpText>
          <SignUpInfoWrap>
            <SignUpInfoText>블로그명</SignUpInfoText>
            <BlogProfileInfoInput
              type="text"
              id="signup-blogname"
              placeholder={blogNamePlaceholder}
              onFocus={() => setBlogNamePlaceholder("")}
              onBlur={() =>
                setBlogNamePlaceholder(
                  "한글, 영문, 숫자 혼용 가능(한글 기준 8자 이내)"
                )
              }
            />
          </SignUpInfoWrap>
          <SignUpInfoWrap>
            <SignUpInfoText>소개글</SignUpInfoText>
            <BlogProfileInfoBigInput
              type="text"
              id="signup-bloginfo"
              placeholder={infoTextholder}
              onFocus={() => setinfoTextholder("")}
              onBlur={() =>
                setinfoTextholder(
                  "블로그 프로필 영역의 프로필 이미지 아래에 반영됩니다.(한글 기준 200자 이내)"
                )
              }
            />
          </SignUpInfoWrap>
          <SignUpInfoWrap>
            <SignUpInfoText>테마</SignUpInfoText>
            <BlogThemaSelectWrap>
              <BlogThemaSelect type="radio" id="option1" name="options" />
              <BlogThemaSelectText>핑크</BlogThemaSelectText>
              <BlogThemaSelect type="radio" id="option1" name="options" />
              <BlogThemaSelectText>하늘</BlogThemaSelectText>
              <BlogThemaSelect type="radio" id="option1" name="options" />
              <BlogThemaSelectText>갈색</BlogThemaSelectText>
              <BlogThemaSelect type="radio" id="option1" name="options" />
              <BlogThemaSelectText>초록</BlogThemaSelectText>
            </BlogThemaSelectWrap>
          </SignUpInfoWrap>
          <SignUpInfoWrapThemaText>
            <BlogThemaText>
              테마 색상을 선택하시면 선택하신 색상에 맞춰
              <br />
              기본 블로그가 나타납니다.
              <br />
              프로필에 위치한 Edit 버튼을 클릭하시면 블로그의 색상,
              <br />
              마이룸의 테마 등을 직접 설정하실 수 있습니다.
            </BlogThemaText>
          </SignUpInfoWrapThemaText>

          <SingUpFinshBtn>회원가입</SingUpFinshBtn>
        </SignUpInnerBox>
        <SignUpStep src="/images/signup3step.svg" />
      </SignUpBox>
    </Container>
  );
}

export default SignUpPage3;
