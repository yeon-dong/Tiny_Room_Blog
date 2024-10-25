import { useCallback, useState } from "react";
import {
  ButtonContainer,
  Username,
  Container,
  Editor,
  Textarea,
  WriteButton,
} from "./NewCommentBox.style";
import useStore from "../../../stores/store";
import axios from "axios";
import { useLocation } from "react-router-dom";

const NewCommentBox = ({ getComments }) => {
  const location = useLocation();
  const postId = location.pathname.split("/")[3];
  const { userInfo } = useStore();

  const [comment, setComment] = useState("");

  const handleCommentChange = useCallback((e) => {
    setComment(e.target.value);
  }, []);

  const handleWrite = useCallback(async () => {
    const response = await axios.post(
      `http://localhost:8080/comments/writeComment?post_id=${postId}&parent_id=-1`,
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
    getComments();
  }, [comment]);

  return (
    <Container>
      <Editor>
        <Username>{userInfo?.nickname}</Username>
        <Textarea
          placeholder="블로그가 더 훈훈해지는 댓글 부탁드립니다."
          value={comment}
          onChange={handleCommentChange}
        />
      </Editor>
      <ButtonContainer>
        <WriteButton onClick={handleWrite}>작성</WriteButton>
      </ButtonContainer>
    </Container>
  );
};

export default NewCommentBox;
