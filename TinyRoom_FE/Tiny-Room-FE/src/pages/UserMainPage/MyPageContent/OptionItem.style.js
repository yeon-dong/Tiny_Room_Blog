import styled from "styled-components";

export const Container = styled.div`
  width: 100%;
  display: flex;
  align-items: flex-start;
  border-bottom: 1px solid var(--gray2);
  padding: 10px 0;
`;

export const Label = styled.div`
  flex: 0 0 150px;
  font-size: 18px;
  font-weight: bold;
  height: 40px;
  line-height: 40px;
`;

export const Content = styled.div`
  flex-grow: 1;
`;
