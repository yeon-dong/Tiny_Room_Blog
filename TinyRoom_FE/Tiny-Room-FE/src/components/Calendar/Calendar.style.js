import styled from "styled-components";

export const Container = styled.div`
  width: 279px;
  flex: 0 0 253px;
  height: 253px;
  background-image: url("/images/calendar_bg.svg");
  padding-top: 32px;
`;

export const Header = styled.div`
  width: 100%;
  height: 37px;
  display: flex;
  justify-content: center;
  align-items: center;
`;

export const MoveButton = styled.button`
  width: 18px;
  height: 18px;
  display: flex;
  justify-content: center;
  align-items: center;

  img {
    width: 11px;
    height: 11px;
  }
`;

export const DateWrapper = styled.div`
  width: 160px;
  height: 18px;
  display: flex;
  justify-content: space-around;
`;

export const DateText = styled.span`
  height: 18px;
  line-height: 18px;
  font-size: 18px;
  font-weight: bold;
  color: white;
`;

export const BodyWrapper = styled.div`
  width: 100%;
  height: 184px;
  padding: 0 17px 14px 17px;
`;

export const Body = styled.div`
  width: 100%;
  height: 100%;
  border-radius: 10px;
  background-color: white;
`;

export const Week = styled.div`
  width: 100%;
  height: 34px;
  display: flex;
  border-bottom: 1px var(--primary-color) dashed;

  &:last-child {
    border-bottom: none;
  }
`;

export const Day = styled.div`
  position: relative;
  flex: 1 0;
  height: 100%;
  font-weight: bold;
  font-size: 18px;
  display: flex;
  justify-content: center;
  align-items: flex-start;
  padding-top: 6px;
  user-select: none;

  border-radius: 20px;

  ${(p) =>
    p.is_blank === 1
      ? ""
      : `
  cursor: pointer;
  &:hover {
    background-color: #ffceda80;
  }
  `}

  &::after {
    content: "";
    display: ${(p) => (p.has_post === 1 ? "block" : "none")};
    position: absolute;
    bottom: 3px;
    left: calc(50% - 2.5px);
    width: 5px;
    height: 5px;
    border-radius: 2.5px;
    background-color: #a1a1a1;
  }
`;
