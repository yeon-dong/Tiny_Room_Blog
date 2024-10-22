import styled from "styled-components";

export const Container = styled.button`
  height: 20px;
  background-color: var(--gray1);
  padding: 0 8px;
  border-radius: 10px;
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

export const IconWrapper = styled.div`
  width: 16px;
  height: 16px;
  img {
    width: 100%;
    height: 100%;
    object-fit: cover;
  }
`;
