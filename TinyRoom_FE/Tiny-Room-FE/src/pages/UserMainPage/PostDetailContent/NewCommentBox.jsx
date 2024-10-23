import {
  ButtonContainer,
  Username,
  Container,
  Editor,
  Textarea,
  WriteButton,
} from "./NewCommentBox.style";

const NewCommentBox = () => {
  return (
    <Container>
      <Editor>
        <Username>작성자</Username>
        <Textarea placeholder="블로그가 더 훈훈해지는 댓글 부탁드립니다." />
      </Editor>
      <ButtonContainer>
        <WriteButton>작성</WriteButton>
      </ButtonContainer>
    </Container>
  );
};

export default NewCommentBox;
