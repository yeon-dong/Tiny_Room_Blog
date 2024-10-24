import {
  BoardBox,
  BoardContent,
  BoardFooter,
  BoardHeader,
  Container,
} from "./MainContent.style";
import MyRoom from "./MyRoom";

const MainContent = () => {
  return (
    <Container>
      <MyRoom />
      <BoardBox>
        <BoardHeader>최신 게시글</BoardHeader>
        <BoardContent></BoardContent>
        <BoardFooter></BoardFooter>
      </BoardBox>
    </Container>
  );
};

export default MainContent;
