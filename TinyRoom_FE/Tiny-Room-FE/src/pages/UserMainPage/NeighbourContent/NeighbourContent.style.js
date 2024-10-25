import styled from "styled-components";

export const Container = styled.div`
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  gap: 6px;
`;

export const NeighbourList = styled.div`
  width: 100%;
  flex: 0 0 710px;
  overflow-y: auto;
`;

export const PaginationWrapper = styled.div`
  position: relative;
  width: 100%;
  flex: 0 0 30px;
  display: flex;
  justify-content: center;
`;

export const ButtonWrapper = styled.div`
  position: absolute;
  top: 0;
  right: 0;
  height: 30px;
  display: flex;
  justify-content: center;
  align-items: center;
`;
