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
  background-color: rgba(0, 0, 0, 0.7);
  z-index: 5;
`;

export const KitchenImg = styled.img`
  position: absolute;
  left: 0;
  top: 0;
  width: 240px;
  height: 400px;
  cursor: pointer;
  ${(p) => (p.is_hovered ? "z-index: 10;" : "")}
`;

export const InteriorImg = styled.img`
  position: absolute;
  left: 240px;
  top: 0;
  width: 160px;
  height: 400px;
  cursor: pointer;
  ${(p) => (p.is_hovered ? "z-index: 10;" : "")}
`;

export const LivingImg = styled.img`
  position: absolute;
  left: 400px;
  top: 0;
  width: 150px;
  height: 400px;
  cursor: pointer;
  ${(p) => (p.is_hovered ? "z-index: 10;" : "")}
`;

export const ElectronicsImg = styled.img`
  position: absolute;
  left: 580px;
  top: 0;
  width: 220px;
  height: 400px;
  cursor: pointer;
  ${(p) => (p.is_hovered ? "z-index: 10;" : "")}
`;

export const BubbleImg = styled.img`
  position: absolute;
  left: ${(p) => p.left}px;
  top: ${(p) => p.top}px;
  width: 183px;
  height: 84px;
  z-index: 11;
  pointer-events: none; /* hover를 무시하도록 설정 */
`;

export const CharacterImg = styled.img`
  position: absolute;
  left: 340px;
  bottom: 20px;
  width: 120px;
  height: 120px;
  object-fit: cover;
  z-index: 20;
`;
