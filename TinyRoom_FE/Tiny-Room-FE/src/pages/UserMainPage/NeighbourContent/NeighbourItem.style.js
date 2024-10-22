import { Link } from "react-router-dom";
import styled from "styled-components";

export const Container = styled.div`
  width: 100%;
`;

export const Title = styled.div`
  width: 100%;
  height: 38px;
  background-color: var(--primary-color);
  border-radius: 10px;
  padding: 0 20px;
  display: flex;
  align-items: center;
  margin-bottom: 20px;
`;

export const BlogName = styled(Link)`
  color: black;
  text-decoration: none;
  font-size: 18px;

  &:hover {
    text-decoration: underline;
  }

  span {
    font-weight: bold;
  }
`;

export const Content = styled.div`
  width: 700px;
  margin: 0 auto;
  display: flex;
  gap: 30px;
  margin-bottom: 20px;
`;

export const ProfileImage = styled.div`
  flex: 0 0 128px;
  height: 128px;
  background-color: skyblue;
  border-radius: 10px;
`;

export const Description = styled.div`
  flex-grow: 1;
  height: 128px;
  font-size: 15px;
`;
