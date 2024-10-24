import styled from "styled-components";

export const Container = styled.div`
  width: 100%;
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
