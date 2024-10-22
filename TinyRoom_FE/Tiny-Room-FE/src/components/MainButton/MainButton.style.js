import styled from "styled-components";

export const Container = styled.button`
  height: 20px;
  background-color: var(--gray1);
  padding: 0 8px;
  border-radius: 2px;
  border: 1px solid var(--gray4);
  display: flex;
  align-items: center;
  gap: 4px;
  ${(p) =>
    p.disabled
      ? `
  cursor: default;
  color: black;
  `
      : ""}
`;
