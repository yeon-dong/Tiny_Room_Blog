import styled from "styled-components";

export const Container = styled.div`
  width: 100%;
  min-height: 31px;
  padding: 5px 0;
  border-bottom: 1px solid var(--gray2);
  display: flex;
  align-items: flex-start;
`;

export const IconWrapper = styled.div`
  flex: 0 0 50px;
  height: 30px;
  display: flex;
  justify-content: center;
  align-items: center;

  img {
    width: 16px;
    height: 16px;
  }
`;

export const CommentWrapper = styled.div`
  flex: 1 0;
  word-break: break-all;
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
