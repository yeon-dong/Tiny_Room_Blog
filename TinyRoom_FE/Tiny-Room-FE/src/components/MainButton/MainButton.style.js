import styled from "styled-components";

export const Container = styled.button`
  height: 20px;
  background-color: ${(p) => (p.strong === 1 ? "#ff8caa" : "var(--gray1)")};
  padding: 0 8px;
  border-radius: 2px;
  border: 1px solid ${(p) => (p.strong === 1 ? "#FF4A79" : "var(--gray4)")};
  display: flex;
  align-items: center;
  font-size: 14px;
  ${(p) => (p.strong === 1 ? `font-weight: bold; color: white;` : "")}
  gap: 4px;

  &:disabled {
    background-color: var(--gray1);
    cursor: default;
    color: black;
    border: none;
  }
`;
