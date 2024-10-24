import {
  Children,
  Container,
  Content,
  Date,
  DivLine,
  ReplyButton,
  Username,
  Wrapper,
} from "./CommentItem.style";
import ReplyItem from "./ReplyItem";

const CommentItem = ({ comment }) => {
  const { username, content, date, children } = comment;

  const token = localStorage.getItem("token");

  return (
    <Wrapper>
      <Container>
        <Username>{username}</Username>
        <DivLine>:</DivLine>
        <Content>{content}</Content>
        <Date>{date}</Date>
        {token !== null && <ReplyButton>답글</ReplyButton>}
      </Container>
      {children.length > 0 && (
        <Children>
          {children.map((reply) => (
            <ReplyItem key={reply.comment_id} comment={reply} />
          ))}
        </Children>
      )}
    </Wrapper>
  );
};

export default CommentItem;
