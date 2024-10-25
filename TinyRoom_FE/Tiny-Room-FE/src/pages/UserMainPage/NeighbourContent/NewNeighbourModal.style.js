import styled from "styled-components";

export const Wrapper = styled.div`
  position: fixed;
  left: 0;
  right: 0;
  top: 0;
  bottom: 0;
  background-color: rgba(0, 0, 0, 0.5);
`;

export const Container = styled.div`
  position: absolute;
  left: calc(50% - 300px);
  top: calc(50% - 250px);
  width: 600px;
  height: 500px;
  border-radius: 10px;
  background-color: white;
  overflow: hidden;
  padding: 14px 38px;
`;

export const Header = styled.div`
  width: 100%;
  height: 46px;
  border-bottom: 1px solid var(--gray2);
  font-size: 18px;
  font-weight: bold;
  display: flex;
  justify-content: center;
  align-items: center;
`;

export const Table = styled.div`
  width: 100%;
  max-height: 380px;
  overflow-y: auto;
`;

export const Row = styled.div`
  width: 100%;
  height: ${(p) => (p.is_header === 1 ? "40px" : "50px")};
  ${(p) => (p.is_header === 1 ? "background-color: var(--gray2);" : "")}
  display: flex;
  ${(p) =>
    p.is_header === 1
      ? `
  border-top: 1px solid var(--gray1);
  border-bottom: 1px solid var(--gray1);
  `
      : `
  border-bottom: 1px solid var(--gray1);
  `}
  padding: 0 20px;
`;

export const Col = styled.div`
  display: flex;
  align-items: center;
  height: 100%;
  font-size: 14px;
`;

export const NameCol = styled(Col)`
  flex: 0 0 40%;
`;

export const MessageCol = styled(Col)`
  flex: 0 0 40%;
`;

export const ButtonsCol = styled(Col)`
  flex: 0 0 20%;
`;

export const ButtonBox = styled.div`
  width: 100%;
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: space-between;
`;
