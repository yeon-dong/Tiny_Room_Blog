import styled from "styled-components";

export const Container = styled.label`
  display: flex;
  align-items: flex-start;
  cursor: pointer;
  gap: 10px;
  font-size: 15px;
`;

export const Input = styled.input`
  position: relative;
  width: 19px;
  height: 19px;
  -webkit-appearance: none; // 웹킷 브라우저에서 기본 스타일 제거
  -moz-appearance: none; // 모질라 브라우저에서 기본 스타일 제거
  appearance: none; // 기본 브라우저에서 기본 스타일 제거
  border-radius: 50%;
  background-color: var(--gray2);
  outline: none;

  &:checked::after {
    content: "";
    display: block;
    position: absolute;
    width: 9px;
    height: 9px;
    left: calc(50% - 4.5px);
    top: calc(50% - 4.5px);
    border-radius: 50%;
    background-color: black;
  }
`;
