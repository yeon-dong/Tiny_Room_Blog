import { useOutletContext } from "react-router-dom";
import {
  BoardBox,
  BoardContent,
  BoardFooter,
  BoardHeader,
  Container,
} from "./MainContent.style";
import MyRoom from "./MyRoom";

const MainContent = () => {
  const blogData = useOutletContext();

  return (
    <Container>
      {Boolean(blogData) && <MyRoom roomData={blogData.room} />}
      <BoardBox>
        <BoardHeader>최신 게시글</BoardHeader>
        <BoardContent></BoardContent>
        <BoardFooter></BoardFooter>
      </BoardBox>
    </Container>
  );
};

export default MainContent;
