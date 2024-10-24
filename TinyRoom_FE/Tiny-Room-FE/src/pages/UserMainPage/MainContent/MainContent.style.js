import { Link } from "react-router-dom";
import styled from "styled-components";

export const Container = styled.div`
  width: 100%;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
  height: 100%;
  overflow-y: auto;
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
  justify-content: space-between;
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
  ${(p) => (p.selected === 1 ? "font-weight: bold;" : "")}
`;

export const WriteButton = styled(Link)`
  font-size: 16px;
  font-weight: bold;
  color: var(--primary-color);
`;

export const BoardContent = styled.div`
  display: flex;
  flex: 0 0 200px;
  background-color: yellow;
`;

export const BoardFooter = styled.div`
  flex: 0 0 22px;
  background-color: pink;
`;
