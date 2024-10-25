import styled from "styled-components";

export const Container = styled.div`
  position: relative;
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
  bottom: 0;
  right: 0;
  height: 30px;
  display: flex;
  justify-content: center;
  align-items: center;
`;

export const NoContent = styled.div`
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 40px;
  font-weight: bold;
  color: var(--gray4);
  user-select: none;
`;
