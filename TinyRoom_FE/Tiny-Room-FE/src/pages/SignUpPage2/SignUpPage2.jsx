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
import { useNavigate } from "react-router-dom";
import useStore from "../../stores/store.js"; // Zustand 스토어 import

function SignUpPage2() {
  const navigate = useNavigate();
  const { setSignUpProfileImg, setSignUpName, setSignUpNickName } = useStore();

  const [namePlaceholder, setNamePlaceholder] = useState(
    "한글, 영문, 숫자 혼용 가능(한글 기준 8자 이내)"
  );
  const [nicknamePlaceholder, setNicknamePlaceholder] = useState(
    "한글, 영문, 숫자 혼용 가능(한글 기준 8자 이내)"
  );
  const [imageSrc, setImageSrc] = useState("/images/Group 46.svg"); // 기본 이미지 경로
  const [name, setName] = useState("");
  const [nickname, setNickName] = useState("");

  const handleFileChange = (event) => {
    const file = event.target.files[0];
    if (file) {
      const reader = new FileReader();
      reader.onloadend = () => {
        setImageSrc(reader.result); // 선택한 이미지의 데이터 URL로 상태 업데이트
      };
      reader.readAsDataURL(file); // 파일을 데이터 URL로 읽기
    }
  };

  const handleDeleteImage = () => {
    setImageSrc("/images/Group 46.svg"); // 기본 이미지로 설정
  };

  const isNextBtnEnabled =
    name.length > 0 &&
    name.length <= 8 &&
    nickname.length > 0 &&
    nickname.length <= 8;

  const handleNextBtnClick = () => {
    if (isNextBtnEnabled) {
      setSignUpProfileImg(imageSrc);
      setSignUpName(name);
      setSignUpNickName(nickname);
      navigate("/signup3");
    }
  };

  return (
    <Container>
      <SignUpBox>
        <SignUpInnerBox>
          <SignUpText>Join Us</SignUpText>
          <BlogProfileText>블로그 프로필</BlogProfileText>
          <BlogProfileIMG src={imageSrc} alt="Profile" />
          <BlogProfileUploadContainer>
            <input
              type="file"
              id="file-upload"
              accept="image/*" // 이미지 파일만 허용
              style={{ display: "none" }} // 기본 파일 입력 숨기기
              onChange={handleFileChange}
            />
            <BlogProfileUploadBtn
              src="/images/Frame 11.svg"
              onClick={() => document.getElementById("file-upload").click()} // 파일 입력 클릭
            />
            <BlogProfileUploadBtn
              src="/images/Frame 12.svg"
              onClick={handleDeleteImage} // 이미지 삭제 클릭
            />
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
                onChange={(e) => setName(e.target.value)} // 이름 상태 업데이트
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
                onChange={(e) => setNickName(e.target.value)} // 닉네임 상태 업데이트
              />
            </BlogProfileInfoWrap>
          </BlogProfileInfoContainer>
          <NextBtn
            $isNextBtnEnabled={isNextBtnEnabled}
            onClick={handleNextBtnClick}
          >
            다음
          </NextBtn>
        </SignUpInnerBox>
        <SignUpStep src="/images/signup2step.svg" />
      </SignUpBox>
    </Container>
  );
}

export default SignUpPage2;
