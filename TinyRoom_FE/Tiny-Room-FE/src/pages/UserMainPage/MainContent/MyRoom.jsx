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

const isHovered = (selectedCategoryIdx, hoveredPart, categoryIdx) => {
  return selectedCategoryIdx === categoryIdx || hoveredPart === categoryIdx
    ? 1
    : 0;
};

const MyRoom = ({ selectedCategoryIdx, onFurnitureClick, roomData }) => {
  const [hoveredPart, setHoveredPart] = useState(0);

  const handleMouseEnter = useCallback(
    (id) => {
      if (selectedCategoryIdx === 0) setHoveredPart(id);
    },
    [selectedCategoryIdx]
  );

  const handleShadowClick = useCallback(() => {
    onFurnitureClick(0);
  }, []);

  return (
    <Container>
      <RoomImg src={`/images/room${roomData.theme}.png`} alt="Room" />
      {(selectedCategoryIdx > 0 || hoveredPart > 0) && (
        <Shadow onClick={handleShadowClick} />
      )}
      <KitchenImg
        src={`/images/kitchen${roomData.furniture1}.png`}
        alt="Kitchen"
        onMouseEnter={(e) => {
          handleMouseEnter(1);
        }}
        onMouseLeave={() => {
          setHoveredPart(0);
        }}
        onClick={() => onFurnitureClick(1)}
        is_hovered={isHovered(selectedCategoryIdx, hoveredPart, 1)}
      />
      <InteriorImg
        src={`/images/interior${roomData.furniture2}.png`}
        alt="Interior"
        onMouseEnter={(e) => {
          handleMouseEnter(2);
        }}
        onMouseLeave={() => {
          setHoveredPart(0);
        }}
        onClick={() => onFurnitureClick(2)}
        is_hovered={isHovered(selectedCategoryIdx, hoveredPart, 2)}
      />
      <LivingImg
        src={`/images/living${roomData.furniture3}.png`}
        alt="Living"
        onMouseEnter={(e) => {
          handleMouseEnter(3);
        }}
        onMouseLeave={() => {
          setHoveredPart(0);
        }}
        onClick={() => onFurnitureClick(3)}
        is_hovered={isHovered(selectedCategoryIdx, hoveredPart, 3)}
      />
      <ElectronicsImg
        src={`/images/electronics${roomData.furniture4}.png`}
        alt="Electronics"
        onMouseEnter={(e) => {
          handleMouseEnter(4);
        }}
        onMouseLeave={() => {
          setHoveredPart(0);
        }}
        onClick={() => onFurnitureClick(4)}
        is_hovered={isHovered(selectedCategoryIdx, hoveredPart, 4)}
      />

      {selectedCategoryIdx > 0 ? (
        <BubbleImg
          left={furniturePositions[selectedCategoryIdx][0]}
          top={furniturePositions[selectedCategoryIdx][1]}
          src={`/images/${furnitureNames[selectedCategoryIdx]}_bubble.png`}
          alt="Bubble"
        />
      ) : (
        hoveredPart > 0 && (
          <BubbleImg
            left={furniturePositions[hoveredPart][0]}
            top={furniturePositions[hoveredPart][1]}
            src={`/images/${furnitureNames[hoveredPart]}_bubble.png`}
            alt="Bubble"
          />
        )
      )}
    </Container>
  );
};

export default MyRoom;
