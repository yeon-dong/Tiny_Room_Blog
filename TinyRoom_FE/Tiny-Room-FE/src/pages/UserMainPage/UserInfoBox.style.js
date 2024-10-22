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
`;

export const ProfileBox = styled.div`
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
  background-color: pink;
`;

export const DescriptionBox = styled.div`
  width: 100%;
  flex: 0 0 112px;
  border-radius: 10px;
  background-color: yellowgreen;
`;
