import styled from "styled-components";

export const Container = styled.div`
  position: relative;
  width: 225px;
  height: 30px;
`;

export const Input = styled.div`
  position: relative;
  width: 100%;
  height: 100%;
  border-bottom: 1px solid var(--gray6);
  cursor: pointer;
  font-size: 15px;
  line-height: 30px;
`;

export const IconWrapper = styled.div`
  position: absolute;
  top: 0;
  right: 0;
  width: 30px;
  height: 30px;
  display: flex;
  justify-content: center;
  align-items: center;

  img {
    width: 16px;
    height: 16px;
  }
`;

export const ItemBox = styled.div`
  position: absolute;
  top: 35px;
  left: 0;
  width: 100%;
  background-color: white;
  box-shadow: 0 2px 4px var(--gray6);
  border-radius: 10px;
  padding: 20px 0;
  z-index: 10;
`;

export const MenuItem = styled.div`
  width: 100%;
  height: 30px;
  font-size: 15px;
  line-height: 30px;
  user-select: none;
  cursor: pointer;
  padding: 0 20px;

  &:hover {
    background-color: var(--gray3);
  }
`;
