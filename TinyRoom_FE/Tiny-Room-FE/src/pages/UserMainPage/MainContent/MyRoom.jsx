import { useCallback, useState } from "react";
import {
  Container,
  ElectronicsImg,
  InteriorImg,
  KitchenImg,
  RoomImg,
  Shadow,
} from "./MyRoom.style";

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
      {hoveredPart > 0 && (
        <Shadow
        // onMouseEnter={(e) => {
        //   handleMouseEnter(0);
        // }}
        />
      )}
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
    </Container>
  );
};

export default MyRoom;
