import styled from "styled-components";

export const Container = styled.div`
  width: 100%;
  height: 100%;
  overflow-y: auto;
`;

export const Header = styled.div`
  width: 100%;
  border-radius: 10px 10px 0 0;
  background-color: var(--primary-color);
  height: 50px;
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

export const TitleBox = styled.div`
  background-color: var(--gray3);
  border-radius: 0 0 10px 10px;
  padding: 10px 30px;
  margin-bottom: 20px;
`;

export const DropdownWrapper = styled.div`
  height: 50px;
  display: flex;
  align-items: center;
  gap: 20px;
`;

export const TitleInput = styled.input`
  width: 100%;
  height: 40px;
  border: none;
  outline: none;
  background-color: var(--gray2);
  border-radius: 10px;
  padding: 0 20px;
  line-height: 40px;
`;

export const EditorWrapper = styled.div`
  width: 100%;
  height: 600px;
  padding-bottom: 42px;
  margin-bottom: 20px;
`;

export const ButtonBox = styled.div`
  width: 100%;
  display: flex;
  justify-content: space-between;
  margin-bottom: 20px;
`;
