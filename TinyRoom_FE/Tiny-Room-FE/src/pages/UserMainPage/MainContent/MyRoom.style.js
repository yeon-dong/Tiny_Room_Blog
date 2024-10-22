import styled from "styled-components";

export const Container = styled.div`
  position: relative;
  width: 800px;
  flex: 0 0 400px;
  margin-bottom: 16px;
  overflow: hidden;
  border: 1px solid black;
  border-radius: 10px;
`;

export const RoomImg = styled.img`
  position: absolute;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  object-fit: cover;
`;

export const Shadow = styled.div`
  position: absolute;
  right: 0;
  left: 0;
  top: 0;
  bottom: 0;
  background-color: rgba(0, 0, 0, 0.5);
  z-index: 5;
`;

export const KitchenImg = styled.img`
  position: absolute;
  left: 0;
  top: 0;
  width: 210px;
  height: 400px;
  cursor: pointer;
  ${(p) => (p.isHovered ? "z-index: 10;" : "")}
`;

export const KitchenImg2 = styled.img`
  position: absolute;
  left: 190px;
  top: 0;
  width: 210px;
  height: 400px;
  cursor: pointer;
  ${(p) => (p.isHovered ? "z-index: 10;" : "")}
`;
