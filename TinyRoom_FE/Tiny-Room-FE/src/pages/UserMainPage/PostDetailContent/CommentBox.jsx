import { Container } from "./CommentBox.style";
import CommentItem from "./CommentItem";

const CommentBox = ({ comments }) => {
  return (
    <Container>
      {comments.data.map((comment) => (
        <CommentItem key={comment.comment_id} comment={comment} />
      ))}
    </Container>
  );
};

export default CommentBox;
