import { styled } from "styled-components";
import { Link } from "react-router-dom";

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

export const LoginBox = styled.div`
  height: 748px;
  width: 748px;
  background-color: #ffffff;
  border-radius: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
`;

export const LoginTextContainer = styled.div`
  height: 124px;
  width: 391px;
  background-image: url("/images/tinyroomtext.svg");
  margin-bottom: 84px;
`;

export const FormContainer = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-bottom: 49px;
`;

export const LoginInput_ID = styled.input`
  height: 66px;
  width: 442px;
  font-family: "Inter", sans-serif;
  font-size: 20px;
  border: 1px solid;
  font-weight: normal;
  border-radius: 40px;
  border-color: #d9d9d9;
  color: #a1a1a1;
  margin-bottom: 14px;
  padding-left: 50px;
  padding-right: 30px;
`;

export const LoginInput_Password = styled.input`
  height: 66px;
  width: 442px;
  font-size: 20px;
  font-weight: normal;
  border: 1px solid;
  border-radius: 40px;
  border-color: #d9d9d9;
  color: #a1a1a1;
  padding-left: 50px;
  padding-right: 30px;
`;

export const LoginBtn = styled.button`
  height: 66px;
  width: 442px;
  color: white;
  font-size: 18px;
  font-weight: bold;
  text-align: center;
  background-color: var(--primary-color);
  border-radius: 40px;
  margin-bottom: 19px;
`;

export const BottomText = styled.div`
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  width: 269px;
`;

export const FindIDText = styled(Link)`
  font-size: 18px;
  font-weight: normal;
  color: black;
  text-decoration: none;
  &:hover {
    font-weight: bold;
  }
`;

export const SignUpText = styled(Link)`
  font-size: 18px;
  font-weight: normal;
  color: black;
  text-decoration: none;
  &:hover {
    font-weight: bold;
  }
`;
