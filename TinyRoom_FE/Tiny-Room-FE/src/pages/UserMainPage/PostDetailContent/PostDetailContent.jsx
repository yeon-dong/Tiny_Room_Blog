import MainButton from "../../../components/MainButton/MainButton";
import RoundedButton from "../../../components/RoundedButton/RoundedButton";
import CommentBox from "./CommentBox";
import NewCommentBox from "./NewCommentBox";
import {
  BackButton,
  Container,
  Header,
  PaginationBox,
  PostContent,
  PostControlBox,
  PostDate,
  PostDateBox,
  PostFooter,
  PostHeader,
  PostHeaderDivLine,
  PostInfoBox,
  PostTitle,
  PostWeekday,
} from "./PostDetailContent.style";

const PostDetailContent = () => {
  return (
    <Container>
      <Header>
        <BackButton>
          <img src="/images/arrow_back.svg" alt="BackButton" />
        </BackButton>
        홈 인테리어
      </Header>
      <PostHeader>
        <PostDateBox>
          <PostDate>10.20</PostDate>
          <PostWeekday>Sat</PostWeekday>
        </PostDateBox>
        <PostHeaderDivLine />
        <PostTitle>포스트 제목</PostTitle>
      </PostHeader>
      <PostContent></PostContent>
      <PostFooter>
        <PostInfoBox>
          <RoundedButton icon="heart_empty.svg">좋아요 78</RoundedButton>
          <RoundedButton disabled icon="chat.svg">
            댓글 3
          </RoundedButton>
        </PostInfoBox>
        <PostControlBox>
          <MainButton>수정</MainButton>
          <MainButton>삭제</MainButton>
        </PostControlBox>
      </PostFooter>
      <CommentBox />
      <PaginationBox></PaginationBox>
      <NewCommentBox />
    </Container>
  );
};

export default PostDetailContent;
