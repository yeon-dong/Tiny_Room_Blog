import {
  CommentWrapper,
  Container,
  Content,
  Date,
  DivLine,
  IconWrapper,
  Username,
} from "./ReplyItem.style";

const ReplyItem = ({ comment }) => {
  const { username, content, date } = comment;

  return (
    <Container>
      <IconWrapper>
        <img src="/images/reply.svg" alt="Reply" />
      </IconWrapper>
      <CommentWrapper>
        <Username>{username}</Username>
        <DivLine>:</DivLine>
        <Content>{content}</Content>
        <Date>{date}</Date>
      </CommentWrapper>
    </Container>
  );
};

export default ReplyItem;
