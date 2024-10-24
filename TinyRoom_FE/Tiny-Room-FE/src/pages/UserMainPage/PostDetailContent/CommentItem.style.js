import styled from "styled-components";

export const Container = styled.div`
  width: 100%;
  padding: 5px 0;
  border-bottom: 1px solid var(--gray2);
`;

export const MarginRightSpan = styled.span`
  margin-right: 10px;
`;

export const Username = styled(MarginRightSpan)`
  font-size: 15px;
  color: var(--sub-color);
`;

export const DivLine = styled(MarginRightSpan)`
  font-size: 15px;
  color: var(--sub-color);
`;

export const Content = styled(MarginRightSpan)`
  font-size: 15px;
`;

export const Date = styled(MarginRightSpan)`
  font-size: 13px;
  color: var(--gray5);
`;

export const ReplyButton = styled.button`
  height: 20px;
  padding: 0 15px;
  border: 1px solid var(--gray2);
  border-radius: 10px;
`;
