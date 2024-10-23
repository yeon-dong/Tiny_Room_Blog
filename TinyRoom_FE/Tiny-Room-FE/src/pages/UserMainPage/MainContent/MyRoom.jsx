import { useCallback, useState } from "react";
import {
  BubbleImg,
  Container,
  ElectronicsImg,
  InteriorImg,
  KitchenImg,
  LivingImg,
  RoomImg,
  Shadow,
} from "./MyRoom.style";

const furniturePositions = [
  undefined,
  [25, 100],
  [230, 5],
  [380, 15],
  [590, 100],
];
const furnitureNames = ["", "kitchen", "interior", "living", "electronic"];

const MyRoom = () => {
  const roomData = {
    room: 3,
    kitchen: 2,
    interior: 2,
    living: 0,
    electronics: 0,
  };

  const [hoveredPart, setHoveredPart] = useState(0);

  const handleMouseEnter = useCallback((id) => {
    setHoveredPart(id);
  }, []);

  return (
    <Container>
      <RoomImg src={`/images/room${roomData.room}.png`} alt="Room" />
      {hoveredPart > 0 && <Shadow />}
      <KitchenImg
        src={`/images/kitchen${roomData.kitchen}.png`}
        alt="Kitchen"
        onMouseEnter={(e) => {
          handleMouseEnter(1);
          console.log(e);
        }}
        onMouseLeave={() => {
          setHoveredPart(0);
        }}
        isHovered={hoveredPart === 1}
      />
      <InteriorImg
        src={`/images/interior${roomData.interior}.png`}
        alt="Interior"
        onMouseEnter={(e) => {
          handleMouseEnter(2);
        }}
        onMouseLeave={() => {
          setHoveredPart(0);
        }}
        isHovered={hoveredPart === 2}
      />
      <LivingImg
        src={`/images/living${roomData.living}.png`}
        alt="Living"
        onMouseEnter={(e) => {
          handleMouseEnter(3);
        }}
        onMouseLeave={() => {
          setHoveredPart(0);
        }}
        isHovered={hoveredPart === 3}
      />
      <ElectronicsImg
        src={`/images/electronics${roomData.electronics}.png`}
        alt="Electronics"
        onMouseEnter={(e) => {
          handleMouseEnter(4);
        }}
        onMouseLeave={() => {
          setHoveredPart(0);
        }}
        isHovered={hoveredPart === 4}
      />

      {hoveredPart > 0 && (
        <BubbleImg
          left={furniturePositions[hoveredPart][0]}
          top={furniturePositions[hoveredPart][1]}
          src={`/images/${furnitureNames[hoveredPart]}_bubble.png`}
          alt="Bubble"
        />
      )}
    </Container>
  );
};

export default MyRoom;
