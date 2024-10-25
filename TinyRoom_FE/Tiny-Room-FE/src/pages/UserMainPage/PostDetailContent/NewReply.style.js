import styled from "styled-components";

export const Container = styled.div`
  width: 100%;
  min-height: 31px;
  padding: 5px 0;
  border-bottom: 1px solid var(--gray2);
  background-color: var(--gray3);
  display: flex;
  align-items: flex-start;
`;

export const IconWrapper = styled.div`
  flex: 0 0 50px;
  height: 30px;
  display: flex;
  justify-content: center;
  align-items: center;

  img {
    width: 16px;
    height: 16px;
  }
`;

export const EditorWrapper = styled.div`
  flex: 0 0 590px;
  background-color: white;
  border: 1px solid var(--gray2);
`;

export const Editor = styled.div`
  padding: 10px 20px;
  height: 80px;
  border-bottom: 1px solid var(--gray2);
`;

export const Username = styled.div`
  width: 100%;
  font-size: 15px;
  color: var(--sub-color);
  height: 20px;
  line-height: 20px;
`;

export const Textarea = styled.textarea`
  resize: none;
  width: 100%;
  height: 40px;
  border: none;
  outline: none;
`;

export const ButtonContainer = styled.div`
  height: 26px;
  display: flex;
  justify-content: flex-end;
`;

export const WriteButton = styled.button`
  height: 100%;
  border-left: 1px solid var(--gray2);
  padding: 0 10px;
  font-size: 14px;
`;
