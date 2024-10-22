import { Container } from "./CommentBox.style";
import CommentItem from "./CommentItem";

const CommentBox = () => {
  return (
    <Container>
      <CommentItem />
      <CommentItem />
      <CommentItem />
    </Container>
  );
};

export default CommentBox;
