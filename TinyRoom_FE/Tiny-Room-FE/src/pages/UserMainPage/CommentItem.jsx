import {
  Container,
  Content,
  Date,
  DivLine,
  ReplyButton,
  Username,
} from "./CommentItem.style";

const CommentItem = () => {
  return (
    <Container>
      <Username>작성자</Username>
      <DivLine>:</DivLine>
      <Content>
        아주 적절한 댓글을 작성했습니다. 아주 적절한 댓글을 작성했습니다. 아주
        적절한 댓글을 작성했습니다. 적절한 댓글을 작성했습니다. 적절한 댓글을
        작성했습니다.
      </Content>
      <Date>2014.10.21 17:07</Date>
      <ReplyButton>답글</ReplyButton>
    </Container>
  );
};

export default CommentItem;
