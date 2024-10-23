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
  background-color: skyblue;
  border-radius: 10px;
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

export const DescriptionBox = styled.div`
  width: 100%;
  flex: 0 0 112px;
  border-radius: 10px;
  background-color: var(--gray3);
  font-size: 16px;
  padding: 10px;
  color: #585858;
`;
