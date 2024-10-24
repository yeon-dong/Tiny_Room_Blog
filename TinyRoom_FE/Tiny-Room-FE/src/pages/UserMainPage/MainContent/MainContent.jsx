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
import PostPreview from "./PostPreview";
import axios from "axios";
import MyPagination from "../../../components/Pagination/MyPagination";

const MainContent = () => {
  const location = useLocation();
  const userId = location.pathname.split("/")[1];

  const at = localStorage.getItem("at");
  const { userId: loginUserId } = useStore();

  const blogData = useOutletContext();

  const [selectedCategoryIdx, setSelectedCategoryIdx] = useState(0);
  const [posts, setPosts] = useState({
    data: [],
    totalCount: 0,
  });

  console.log(posts);
  const [page, setPage] = useState(1);

  const handleFurnitureClick = useCallback((categoryIdx) => {
    setSelectedCategoryIdx(categoryIdx);
  }, []);

  const getPosts = useCallback(async () => {
    const response = await axios.get(
      `http://localhost:8080/user/${userId}?category=${selectedCategoryIdx}&page=${page}`
    );

    setPosts(response.data);
  }, [page]);

  useEffect(() => {
    getPosts();
  }, [page]);

  const handlePageChange = useCallback((e, page) => {
    setPage(page);
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
        <BoardHeader>
          <CategoryList>
            <CategoryItem
              selected={selectedCategoryIdx === 0 ? 1 : 0}
              onClick={() => handleFurnitureClick(0)}
            >
              전체 게시글
            </CategoryItem>
            <CategoryItem
              selected={selectedCategoryIdx === 1 ? 1 : 0}
              onClick={() => handleFurnitureClick(1)}
            >
              주방가전제품
            </CategoryItem>
            <CategoryItem
              selected={selectedCategoryIdx === 2 ? 1 : 0}
              onClick={() => handleFurnitureClick(2)}
            >
              홈인테리어
            </CategoryItem>
            <CategoryItem
              selected={selectedCategoryIdx === 3 ? 1 : 0}
              onClick={() => handleFurnitureClick(3)}
            >
              실내가구
            </CategoryItem>
            <CategoryItem
              selected={selectedCategoryIdx === 4 ? 1 : 0}
              onClick={() => handleFurnitureClick(4)}
            >
              전자제품
            </CategoryItem>
          </CategoryList>
          {at !== null && String(loginUserId) === userId && (
            <WriteButton to={`/${userId}/post/new`}>글쓰기</WriteButton>
          )}
        </BoardHeader>
        <BoardContent>
          {posts.data.map((post) => (
            <PostPreview key={post.post_id} post={post} />
          ))}
        </BoardContent>
        <BoardFooter>
          <MyPagination
            count={Math.ceil(posts.totalCount / 4)}
            page={page}
            onChange={handlePageChange}
          />
        </BoardFooter>
      </BoardBox>
    </Container>
  );
};

export default MainContent;
