import { useLocation, useOutletContext } from "react-router-dom";
import {
  BoardBox,
  BoardContent,
  BoardFooter,
  BoardHeader,
  CategoryItem,
  CategoryList,
  Container,
  WriteButton,
} from "./MainContent.style";
import MyRoom from "./MyRoom";
import { useCallback, useEffect, useState } from "react";
import useStore from "../../../stores/store";

const MainContent = () => {
  const location = useLocation();
  const userId = location.pathname.split("/")[1];

  const at = localStorage.getItem("at");
  const { userId: loginUserId } = useStore();

  const blogData = useOutletContext();

  const [selectedCategoryIdx, setSelectedCategoryIdx] = useState(0);

  const handleFurnitureClick = useCallback((categoryIdx) => {
    setSelectedCategoryIdx(categoryIdx);
  }, []);

  console.log(selectedCategoryIdx);
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
        <BoardHeader>
          <CategoryList>
            <CategoryItem selected={selectedCategoryIdx === 0 ? 1 : 0}>
              전체 게시글
            </CategoryItem>
            <CategoryItem selected={selectedCategoryIdx === 1 ? 1 : 0}>
              주방가전제품
            </CategoryItem>
            <CategoryItem selected={selectedCategoryIdx === 2 ? 1 : 0}>
              홈인테리어
            </CategoryItem>
            <CategoryItem selected={selectedCategoryIdx === 3 ? 1 : 0}>
              실내가구
            </CategoryItem>
            <CategoryItem selected={selectedCategoryIdx === 4 ? 1 : 0}>
              전자제품
            </CategoryItem>
          </CategoryList>
          {at !== null && String(loginUserId) === userId && (
            <WriteButton to={`/${userId}/post/new`}>글쓰기</WriteButton>
          )}
        </BoardHeader>
        <BoardContent></BoardContent>
        <BoardFooter></BoardFooter>
      </BoardBox>
    </Container>
  );
};

export default MainContent;
