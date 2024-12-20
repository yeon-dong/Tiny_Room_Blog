import { Link } from "react-router-dom";
import styled from "styled-components";

export const Container = styled.div`
  background-color: white;
  width: 340px;
  border-radius: 10px;
  flex-grow: 1;
  height: 100%;
  overflow-y: auto;
  padding: 20px 30px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  gap: 60px;
  overflow-y: scroll;
  &::-webkit-scrollbar {
    width: 0; /* 세로 스크롤 바의 너비를 0으로 설정 */
    background: transparent; /* 배경을 투명하게 설정 */
  }
`;

export const ProfileBox = styled.div`
  flex-shrink: 0;
  display: flex;
  flex-direction: column;
  overflow: hidden;
  gap: 20px;
`;

export const ProfileImageBox = styled.div`
  width: 100%;
  flex: 0 0 230px;
  border-radius: 10px;
  overflow: hidden;

  img {
    width: 100%;
    height: 100%;
    object-fit: cover;
  }
`;

export const UsernameBox = styled.div`
  width: 100%;
  flex: 0 0 18px;
  font-size: 18px;
  line-height: 18px;
  font-weight: bold;
  display: flex;
  justify-content: space-between;
`;

export const EditButton = styled(Link)`
  font-size: 14px;
  font-weight: bold;
  color: #ff80a0;
  height: 18px;
  line-height: 18px;
  text-decoration: underline;
`;

export const NeighborButton = styled.button`
  font-size: 14px;
  font-weight: bold;
  color: #ff80a0;
  height: 18px;
  line-height: 18px;
  text-decoration: underline;
`;

export const DescriptionBox = styled.div`
  width: 100%;
  flex: 0 0 112px;
  border-radius: 10px;
  background-color: var(--gray3);
  font-size: 16px;
  padding: 10px;
  color: #585858;
`;
