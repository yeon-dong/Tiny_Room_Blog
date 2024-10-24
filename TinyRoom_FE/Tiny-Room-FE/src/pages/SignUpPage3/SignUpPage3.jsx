import React, { useState } from "react";
import axios from "axios";
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
  ThemaShowImg,
} from "./SignUpPage3.style";
import { useNavigate } from "react-router-dom";
import useStore from "../../stores/store.js"; // Zustand 스토어 import

function SignUpPage3() {
  const navigate = useNavigate();
  const {
    signUpEmail,
    signUpPassword,
    signUpPhone,
    signUpProfileImg,
    signUpName,
    signUpNickName,
  } = useStore();
  const [blogNamePlaceholder, setBlogNamePlaceholder] = useState(
    "한글, 영문, 숫자 혼용 가능(한글 기준 8자 이내)"
  );
  const [infoTextholder, setinfoTextholder] = useState(
    "블로그 프로필 영역의 프로필 이미지 아래에 반영됩니다.(한글 기준 200자 이내)"
  );
  const [blogName, setBlogName] = useState("");
  const [infoText, setInfoText] = useState("");
  const [thema, setThema] = useState(null);

  const handleThemaChange = (event) => {
    setThema(event.target.value); // 선택된 테마의 value를 상태로 저장
  };

  const isThemaChecked = thema != null;

  const isNextBtnEnabled =
    blogName.length > 0 && blogName.length <= 8 && isThemaChecked;

  const handleNextBtnClick = async () => {
    if (isNextBtnEnabled) {
      const formData = new FormData();
      formData.append("email", signUpEmail);
      formData.append("pw", signUpPassword);
      formData.append("name", signUpName);
      formData.append("nickname", signUpNickName);
      formData.append("phone_number", signUpPhone);
      formData.append("description", infoText);
      formData.append("blog_title", blogName);
      formData.append("blog_theme", thema);
      formData.append("profile_img", signUpProfileImg);

      try {
        const response = await axios.post(
          "http://localhost:8080/register",
          formData,
          {
            // headers: {
            //   "Content-Type": "multipart/form-data",
            // },
          }
        );
        alert("회원가입에 성공했습니다!");
        // navigate("/login");
      } catch (error) {
        console.error("회원가입 실패:", error);
        alert("회원가입에 실패했습니다. 다시 시도해 주세요.");
      }
    }
  };

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
              onChange={(e) => setBlogName(e.target.value)} // 블로그명 상태 업데이트
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
              onChange={(e) => setInfoText(e.target.value)} // 소개글 상태 업데이트
            />
          </SignUpInfoWrap>
          <SignUpInfoWrap>
            <SignUpInfoText>테마</SignUpInfoText>
            <BlogThemaSelectWrap>
              <BlogThemaSelect
                type="radio"
                id="pink"
                name="options"
                value="0"
                onChange={handleThemaChange} // 테마 변경 핸들러
              />
              <BlogThemaSelectText>핑크</BlogThemaSelectText>
              <BlogThemaSelect
                type="radio"
                id="blue"
                name="options"
                value="1"
                onChange={handleThemaChange} // 테마 변경 핸들러
              />
              <BlogThemaSelectText>하늘</BlogThemaSelectText>
            </BlogThemaSelectWrap>
          </SignUpInfoWrap>
          <SignUpInfoWrapThemaText $isThemaChecked={isThemaChecked}>
            {thema ? (
              <ThemaShowImg
                src={
                  thema === "0"
                    ? "/images/login_background.svg"
                    : "/images/하늘색배경.svg"
                } // 선택된 테마에 따라 이미지 표시
                alt={`${thema === "0" ? "핑크" : "하늘"} 테마`}
              /> // 선택된 테마에 따라 이미지 표시
            ) : (
              <BlogThemaText>
                테마 색상을 선택하시면 선택하신 색상에 맞춰
                <br />
                기본 블로그가 나타납니다.
                <br />
                프로필에 위치한 Edit 버튼을 클릭하시면 블로그의 색상,
                <br />
                마이룸의 테마 등을 직접 설정하실 수 있습니다.
              </BlogThemaText>
            )}
          </SignUpInfoWrapThemaText>

          <SingUpFinshBtn
            $isNextBtnEnabled={isNextBtnEnabled}
            onClick={handleNextBtnClick}
          >
            회원가입
          </SingUpFinshBtn>
        </SignUpInnerBox>
        <SignUpStep src="/images/signup3step.svg" />
      </SignUpBox>
    </Container>
  );
}

export default SignUpPage3;
