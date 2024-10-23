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
  margin-bottom: 89px;
`;

export const SignUpInfoContainer = styled.div`
  width: 530px;
  height: 180px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  margin-bottom: 174px;
  position: relative;
`;

export const SignUpInputWrap = styled.div`
  width: 100%;
  position: relative;
`;
export const SignUpInputIMG = styled.img`
  position: absolute;
  top: 15px;
  left: 20px;
  width: 30px;
  height: 30px;
`;

export const SignUpInfo_Email = styled.input`
  border-top-left-radius: 5px;
  border-top-right-radius: 5px;
  border: 1px solid;
  border-color: ${(props) =>
    props.$isEmailValid ? "var(--primary-color2)" : "#EF4444"};
  border-bottom: ${(props) =>
    props.$isEmailValid || !props.$isPasswordValid ? "none" : "solid 1px"};
  font-size: 20px;
  font-weight: normal;
  color: ${(props) =>
    props.$isEmailValid ? "var(--primary-color2)" : "#EF4444"};
  padding: 18px 10px 18px 60px;
  width: 100%;
  &::placeholder {
    color: ${(props) =>
      props.$isEmailValid ? "var(--primary-color2)" : "#EF4444"};
    opacity: 1; /* opacity를 1로 설정하여 색상이 보이도록 함 */
  }
`;

export const SignUpInfo_Password = styled.input`
  border: 1px solid;
  border-bottom: ${(props) =>
    props.$isPasswordValid || !props.$isPhoneValid ? "none" : "solid 1px"};
  border-color: ${(props) =>
    props.$isPasswordValid ? "var(--primary-color2)" : "#EF4444"};
  font-size: 20px;
  font-weight: normal;
  color: ${(props) =>
    props.$isPasswordValid ? "var(--primary-color2)" : "#EF4444"};
  padding: 18px 10px 18px 60px;
  width: 100%;
  &::placeholder {
    color: ${(props) =>
      props.$isPasswordValid ? "var(--primary-color2)" : "#EF4444"};
    opacity: 1; /* opacity를 1로 설정하여 색상이 보이도록 함 */
  }
`;

export const SignUpInfo_Phone = styled.input`
  border-bottom-left-radius: 5px;
  border-bottom-right-radius: 5px;
  border: 1px solid;
  border-color: ${(props) =>
    props.$isPhoneValid ? "var(--primary-color2)" : "#EF4444"};
  font-size: 20px;
  font-weight: normal;
  color: ${(props) =>
    props.$isPhoneValid ? "var(--primary-color2)" : "#EF4444"};
  padding: 18px 10px 18px 60px;
  width: 100%;
  &::placeholder {
    color: ${(props) =>
      props.$isPhoneValid ? "var(--primary-color2)" : "#EF4444"};
    opacity: 1; /* opacity를 1로 설정하여 색상이 보이도록 함 */
  }
`;

export const BottomContainer = styled.div`
  width: 530px;
  display: flex;
  align-items: center;
  margin-bottom: 13px;
`;

export const CheckBtn = styled.img`
  margin-left: 20px;
  width: 30px;
  height: 30px;
  cursor: pointer;
`;

export const CheckText = styled.div`
  font-size: 20px;
  font-weight: bold;
  margin-left: 10px;
`;

export const NextBtn = styled.button`
  background-color: ${(props) =>
    props.$isClickable ? "var(--primary-color)" : "var(--primary-color3)"};
  font-size: 18px;
  font-weight: bold;
  color: white;
  height: 60px;
  width: 530px;
  border-radius: 10px;
  cursor: ${(props) => (props.$isClickable ? "pointer" : "not-allowed")};
  transition: background-color 0.3s;
`;

export const SignUpStep = styled.img`
  width: 56px;
  height: 12px;
  position: absolute;
  bottom: 20px;
`;

export const LoginErrorMsg = styled.p`
  font-size: 15px;
  font-weight: normal;
  color: #ef4444;
  position: absolute;
  left: 20px;
  top: 190px;
`;
