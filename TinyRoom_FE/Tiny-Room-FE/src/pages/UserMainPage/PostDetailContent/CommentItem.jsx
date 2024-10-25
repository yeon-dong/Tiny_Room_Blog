import { useCallback, useState } from "react";
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
import NewReply from "./NewReply";
import ReplyItem from "./ReplyItem";

const CommentItem = ({ comment }) => {
  const [isReplyOpen, setReplyOpen] = useState(false);

  const { username, content, date, children, comment_id } = comment;

  const token = localStorage.getItem("token");

  const handleReplyClick = useCallback(() => {
    setReplyOpen(!isReplyOpen);
  }, [isReplyOpen]);

  const afterReplySubmit = useCallback(() => {
    setReplyOpen(false);
  }, []);

  return (
    <Wrapper>
      <Container>
        <Username>{username}</Username>
        <DivLine>:</DivLine>
        <Content>{content}</Content>
        <Date>{date}</Date>
        {token !== null && (
          <ReplyButton onClick={handleReplyClick}>답글</ReplyButton>
        )}
      </Container>
      {children.length > 0 && (
        <Children>
          {children.map((reply) => (
            <ReplyItem key={reply.comment_id} comment={reply} />
          ))}
          {isReplyOpen && (
            <NewReply
              parentId={comment_id}
              afterReplySubmit={afterReplySubmit}
            />
          )}
        </Children>
      )}
    </Wrapper>
  );
};

export default CommentItem;
