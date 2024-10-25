import { Link } from "react-router-dom";
import styled from "styled-components";

export const Container = styled.div`
  width: 100%;
  display: flex;
  flex-direction: column;
  gap: 20px;
  align-items: center;
  height: 100%;
  overflow-y: scroll; /* 스크롤 가능하도록 설정 */
  /* 스크롤 바 숨기기 */
  &::-webkit-scrollbar {
    width: 0; /* 세로 스크롤 바의 너비를 0으로 설정 */
    background: transparent; /* 배경을 투명하게 설정 */
  }
`;

export const UserTinyRoom = styled.img`
  width: 800px;
  height: 400px;
  margin-bottom: 16px;
`;

export const BoardBox = styled.div`
  width: 100%;
  height: 280px;
  display: flex;
  flex-direction: column;
  gap: 10px;
`;

export const BoardHeader = styled.div`
  width: 100%;
  flex: 0 0 18px;
  display: flex;
  justify-content: space-between;
  align-items: center;
`;

export const CategoryList = styled.div`
  display: flex;
  gap: 20px;
  height: 100%;
`;

export const CategoryItem = styled.button`
  height: 100%;
  font-size: 18px;
  ${(p) => (p.selected === 1 ? "font-weight: bold; color: #FF8CAA;" : "")}
`;

export const WriteButton = styled(Link)`
  font-size: 16px;
  font-weight: bold;
  color: var(--primary-color);
`;

export const BoardContent = styled.div`
  display: flex;
  width: 100%;
  flex: 0 0 232px;
  margin: 0 auto;
  gap: 20px 40px;
  flex-wrap: wrap;
  justify-content: flex-start;
`;

export const BoardFooter = styled.div`
  display: flex;
  justify-content: center;
  flex: 0 0 22px;
`;
