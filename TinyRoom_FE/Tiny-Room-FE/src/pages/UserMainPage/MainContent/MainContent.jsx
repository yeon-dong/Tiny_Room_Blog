import { useOutletContext } from "react-router-dom";
import {
  BoardBox,
  BoardContent,
  BoardFooter,
  BoardHeader,
  Container,
} from "./MainContent.style";
import MyRoom from "./MyRoom";
import { useCallback, useState } from "react";

const MainContent = () => {
  const blogData = useOutletContext();

  const [selectedCategoryIdx, setSelectedCategoryIdx] = useState(0);

  const handleFurnitureClick = useCallback((categoryIdx) => {
    setSelectedCategoryIdx(categoryIdx);
  }, []);

  return (
    <Container>
      {Boolean(blogData) && (
        <MyRoom
          selectedCategoryIdx={selectedCategoryIdx}
          onFurnitureClick={handleFurnitureClick}
          roomData={blogData.room}
        />
      )}
      <BoardBox>
        <BoardHeader>최신 게시글</BoardHeader>
        <BoardContent></BoardContent>
        <BoardFooter></BoardFooter>
      </BoardBox>
    </Container>
  );
};

export default MainContent;
