import { styled } from "styled-components";

export const Wrapper = styled.div`
  position: absolute;
  top: 0;
  bottom: 0;
  right: 0;
  left: 0;
  background-image: url("/images/pink_background.svg"); // 이미지 경로
  background-size: cover; // 이미지가 컨테이너를 덮도록 설정
  background-position: center; // 이미지의 중심을 기준으로 위치 조정
  background-repeat: no-repeat; // 이미지 반복 방지
`;

export const ContainerBox = styled.div`
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  display: flex;
  flex-direction: column;
  justify-content: center;
  padding: 20px;
`;

export const Container = styled.div`
  display: flex;
  width: 1200px;
  flex-basis: 100%;
  flex-shrink: 0;
  max-height: 840px;
  height: 100%;
  margin: 0 auto;
  gap: 20px;
`;

export const UserInfoContainer = styled.div`
  flex-basis: 340px;
  flex-shrink: 0;
  display: flex;
  flex-direction: column;
  gap: 6px;
`;

export const BlogNameBox = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  position: relative;
  flex: 0 0 48px;
`;

export const BlogNameText = styled.div`
  font-size: 32px;
  font-weight: bold;
`;

export const UserBlogNameLine = styled.img`
  position: absolute;
  bottom: 0;
  left: 0;
`;

export const UserBlogContainer = styled.div`
  flex-basis: 840px;
  flex-shrink: 0;
  display: flex;
  flex-direction: column;
  gap: 6px;
`;

export const UserBlogHeaderContainer = styled.div`
  width: 100%;
  flex: 0 0 48px;
  display: flex;
  justify-content: space-between;
  align-items: flex-end;
  padding: 0 40px;
`;

export const MenuBox = styled.div`
  display: flex;
  gap: 30px;
`;

export const LogoutButton = styled.button`
  font-size: 18px;
`;

export const UserBlogHeaderText = styled.div`
  font-size: 18px;
  font-weight: normal;
`;

export const UserBlogHeaderTextBetweenLine = styled.img`
  margin-bottom: 5px;
`;

export const UserBlogBox = styled.div`
  background-color: white;
  width: 840px;
  border-radius: 10px;
  display: flex;
  flex-direction: column;
  align-items: center;
  height: 100%;
  overflow-y: auto;
`;

export const UserTinyRoom = styled.img`
  margin-top: 12px;
  width: 760px;
  height: 387px;
`;
