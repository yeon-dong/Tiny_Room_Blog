import { Container } from "./CommentBox.style";
import CommentItem from "./CommentItem";

const CommentBox = ({ comments, getComments }) => {
  console.log(comments.comments);
  return (
    <Container>
      {comments.comments.map((comment) => (
        <CommentItem
          key={comment.commentId}
          comment={comment}
          getComments={getComments}
        />
      ))}
    </Container>
  );
};

export default CommentBox;
