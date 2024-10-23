import { styled } from "styled-components";

export const Container = styled.div`
  position: absolute;
  top: 0;
  bottom: 0;
  right: 0;
  left: 0;
  background-image: url("/images/login_background.svg"); // 이미지 경로
  background-size: cover; // 이미지가 컨테이너를 덮도록 설정
  background-position: center; // 이미지의 중심을 기준으로 위치 조정
  background-repeat: no-repeat; // 이미지 반복 방지
  display: flex;
  align-items: center;
  justify-content: center;
`;

export const SignUpBox = styled.div`
  height: 845px;
  width: 794px;
  background-color: white;
  border-radius: 15px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  position: relative;
`;

export const SignUpInnerBox = styled.div`
  height: 633px;
  display: flex;
  flex-direction: column;
  align-items: center;
`;

export const SignUpText = styled.div`
  font-size: 70px;
  font-weight: bold;
  margin-bottom: 36px;
`;

export const BlogProfileText = styled.div`
  font-size: 20px;
  font-weight: bold;
  margin-bottom: 20px;
`;

export const BlogProfileIMG = styled.img`
  width: 280px;
  height: 230px;
  margin-bottom: 20px;
`;

export const BlogProfileUploadContainer = styled.div`
  width: 157px;
  display: flex;
  justify-content: space-between;
  margin-bottom: 20px;
`;

export const BlogProfileUploadBtn = styled.img`
  width: 68px;
  height: 20px;
  cursor: pointer;
`;

export const BlogProfileInfoContainer = styled.div`
  width: 470px;
`;

export const BlogProfileInfoWrap = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 20px;
`;

export const BlogProfileInfoText = styled.div`
  font-size: 20px;
  font-weight: bold;
`;

export const BlogProfileInfoInput = styled.input`
  font-size: 15px;
  font-weight: normal;
  color: var(--primary-color2);
  border: 1px solid;
  border-color: var(--primary-color2);
  border-radius: 5px;
  width: 375px;
  height: 40px;
  padding-left: 10px;
`;

export const NextBtn = styled.button`
  background-color: ${(props) =>
    props.$isNextBtnEnabled ? "var(--primary-color)" : "var(--primary-color3)"};
  font-size: 18px;
  font-weight: bold;
  color: white;
  width: 530px;
  height: 60px;
  border-radius: 10px;
  cursor: ${(props) => (props.$isNextBtnEnabled ? "pointer" : "not-allowed")};
`;

export const SignUpStep = styled.img`
  width: 56px;
  height: 12px;
  position: absolute;
  bottom: 20px;
`;
