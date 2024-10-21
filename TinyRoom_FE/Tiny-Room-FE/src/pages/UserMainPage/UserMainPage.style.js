import { styled } from "styled-components";

export const Container = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  position: absolute;
  top: 0;
  bottom: 0;
  right: 0;
  left: 0;
  overflow: hidden;
  background-image: url("/images/pink_background.svg"); // 이미지 경로
  background-size: cover; // 이미지가 컨테이너를 덮도록 설정
  background-position: center; // 이미지의 중심을 기준으로 위치 조정
  background-repeat: no-repeat; // 이미지 반복 방지
`;

export const MainContainer = styled.div`
  margin-top: 12px;
  display: flex;
  width: 1200px;
  justify-content: space-between;
`;

export const UserInfoContainer = styled.div``;

export const UserNameContainer = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
`;

export const UserBlogNameText = styled.div`
  font-size: 32px;
  font-weight: bold;
`;

export const UserBlogNameLine = styled.img`
  position: relative;
  top: -25px;
`;

export const UserInfoBox = styled.div`
  margin-top: -15px;
  background-color: white;
  width: 340px;
  height: 600px; //지금 너무 벗어나고 있음
  border-radius: 10px;
`;

export const UserBlogContainer = styled.div``;

export const UserBlogHeaderContainer = styled.div`
  margin-top: 29px;
  margin-left: 40px;
  display: flex;
  gap: 30px;
`;

export const UserBlogHeaderText = styled.div`
  font-size: 18px;
  font-weight: normal;
`;

export const UserBlogHeaderTextBetweenLine = styled.img``;

export const UserBlogBox = styled.div`
  margin-top: 6px;
  background-color: white;
  width: 840px;
  height: 600px; //지금 너무 벗어나고 있음
  border-radius: 10px;
  display: flex;
  flex-direction: column;
  align-items: center;
`;

export const UserTinyRoom = styled.img`
  margin-top: 12px;
  width: 760px;
  height: 387px;
`;
