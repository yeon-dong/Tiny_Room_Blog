import {
  BoardBox,
  BoardContent,
  BoardFooter,
  BoardHeader,
  Container,
  UserTinyRoom,
} from "./MainContent.style";

const MainContent = () => {
  return (
    <Container>
      <UserTinyRoom src="/images/Group 38.png" />
      <BoardBox>
        <BoardHeader>최신 게시글</BoardHeader>
        <BoardContent></BoardContent>
        <BoardFooter></BoardFooter>
      </BoardBox>
    </Container>
  );
};

export default MainContent;
