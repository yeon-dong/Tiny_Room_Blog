import { useCallback, useState } from "react";
import useStore from "../../../stores/store";
import {
  ButtonContainer,
  Container,
  Editor,
  EditorWrapper,
  IconWrapper,
  Textarea,
  Username,
  WriteButton,
} from "./NewReply.style";
import axios from "axios";
import { useLocation } from "react-router-dom";

const NewReply = ({ parentId, afterReplySubmit }) => {
  const location = useLocation();
  const postId = location.pathname.split("/")[3];

  const [comment, setComment] = useState("");

  const { userInfo } = useStore();

  const handleCommentChange = useCallback((e) => {
    setComment(e.target.value);
  }, []);

  const handleWrite = useCallback(async () => {
    const response = await axios.post(
      `http://localhost:8080/comments/writeComment?post_id=${postId}&parent_id=${parentId}`,
      {
        content: comment,
      },
      {
        headers: {
          auth_token: localStorage.getItem("token"),
        },
      }
    );

    // TODO getComments
    setComment("");
    afterReplySubmit();
  }, [comment, parentId]);

  return (
    <Container>
      <IconWrapper>
        <img src="/images/reply.svg" alt="Reply" />
      </IconWrapper>
      <EditorWrapper>
        <Editor>
          <Username>{userInfo.nickname}</Username>
          <Textarea
            placeholder="블로그가 더 훈훈해지는 댓글 부탁드립니다."
            value={comment}
            onChange={handleCommentChange}
          />
        </Editor>
        <ButtonContainer>
          <WriteButton onClick={handleWrite}>작성</WriteButton>
        </ButtonContainer>
      </EditorWrapper>
    </Container>
  );
};

export default NewReply;
