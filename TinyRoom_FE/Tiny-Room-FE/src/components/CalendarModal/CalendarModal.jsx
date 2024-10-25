import React from "react";
import {
  ContentText,
  DayText,
  Divider,
  ModalContainer,
  PostContainer,
  PostInnerContainer,
  TitleText,
} from "./CalendarModal.style";
import { useNavigate, useParams } from "react-router-dom";

function CalendarModal({
  position,
  year,
  month,
  day,
  postData,
  handleModalClose,
}) {
  const { id, postId } = useParams();
  const navigate = useNavigate();
  const handlePostNavigate = (userId, id) => {
    handleModalClose();
    navigate(`/${userId}/post/${id}`);
  };

  return (
    <ModalContainer $y={position.top} $x={position.left}>
      <DayText>
        {year}년 {month}월 {day}일
      </DayText>
      <Divider />
      <PostContainer>
        {postData.map((post, postIdx) => (
          <PostInnerContainer
            key={postIdx}
            onClick={() => handlePostNavigate(id, post.post_id)}
          >
            <TitleText>{post.title}</TitleText>
            <ContentText>{post.text_content}</ContentText>
          </PostInnerContainer>
        ))}
      </PostContainer>
    </ModalContainer>
  );
}

export default CalendarModal;
