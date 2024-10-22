import { useCallback, useState } from "react";
import {
  Container,
  KitchenImg,
  KitchenImg2,
  RoomImg,
  Shadow,
} from "./MyRoom.style";

const MyRoom = () => {
  const roomData = {
    room: 3,
    kitchen: 0,
    living: 0,
    interior: 0,
    work: 0,
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
        src="/images/kitchen_test.png"
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
      <KitchenImg2
        src="/images/kitchen_test.png"
        alt="Kitchen"
        onMouseEnter={(e) => {
          handleMouseEnter(2);
        }}
        onMouseLeave={() => {
          setHoveredPart(0);
        }}
        isHovered={hoveredPart === 2}
      />
    </Container>
  );
};

export default MyRoom;
