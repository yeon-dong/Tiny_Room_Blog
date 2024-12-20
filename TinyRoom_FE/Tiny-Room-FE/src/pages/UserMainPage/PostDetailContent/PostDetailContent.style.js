import styled from "styled-components";

export const Container = styled.div`
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
  height: 100%;
  gap: 10px;
  &::-webkit-scrollbar {
    width: 0; /* 세로 스크롤 바의 너비를 0으로 설정 */
    background: transparent; /* 배경을 투명하게 설정 */
  }
`;

export const Header = styled.div`
  width: 100%;
  flex: 0 0 50px;
  border-radius: 10px;
  background-color: var(--primary-color);
  display: flex;
  align-items: center;
  font-size: 18px;
  font-weight: bold;
  padding: 0 20px;
`;

export const BackButton = styled.button`
  width: 20px;
  height: 20px;
  margin-right: 10px;

  img {
    width: 100%;
    height: 100%;
  }
`;

export const PostHeader = styled.div`
  width: 100%;
  flex: 0 0 84px;
  border: 1px solid var(--gray2);
  background-color: var(--gray3);
  display: flex;
  padding: 0 30px;
  align-items: center;
`;

export const PostDateBox = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  padding: 0 16px;
`;

export const PostHeaderDivLine = styled.div`
  width: 1px;
  height: 60px;
  background-color: var(--gray1);
`;

export const PostDate = styled.div`
  font-size: 32px;
  font-weight: bold;
`;

export const PostWeekday = styled.div`
  font-size: 16px;
`;

export const PostTitle = styled.div`
  font-size: 18px;
  flex-grow: 1;
  padding: 0 16px;
`;

export const PostContent = styled.div`
  width: 100%;
  border: 1px solid var(--gray1);
  padding: 20px;
`;

export const PostUpdatedAt = styled.div`
  width: 100%;
  font-size: 15px;
  color: var(--gray1);
  user-select: none;
  margin-bottom: 20px;
`;

export const PostFooter = styled.div`
  width: 100%;
  flex: 0 0 26px;
  display: flex;
  justify-content: space-between;
`;

export const PostInfoBox = styled.div`
  display: flex;
  gap: 16px;
  height: 100%;
  align-items: center;
`;

export const PostControlBox = styled.div`
  display: flex;
  gap: 16px;
  height: 100%;
  align-items: center;
`;

export const PaginationBox = styled.div`
  width: 100%;
  flex: 0 0 22px;
  display: flex;
  justify-content: center;
`;
