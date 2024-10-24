import React from "react";
import {
  ContentContainer,
  Card,
  CardImage,
  CardBody,
  CardTitle,
  CardAuthor,
  HotTitle,
} from "./ContentSection.style"; // styled-components 불러오기
import { useNavigate } from "react-router-dom";

function ContentSection({ recommendPost }) {
  const navigate = useNavigate();
  const recommendPostArray = Object.values(recommendPost);

  const handleBlogPostClick = (userId, postId) => {
    navigate(`/${userId}/post/${postId}`);
  };

  return (
    <>
      <HotTitle>HOT 게시물</HotTitle>
      <ContentContainer>
        {recommendPostArray.map((content, index) => (
          <Card
            key={index}
            onClick={() => {
              handleBlogPostClick(content.member_id, content.post_id);
            }}
          >
            <CardImage
              src={`http://localhost:8080${content.thumbnail}`}
              alt={content.title}
            />
            <CardBody>
              <CardTitle>{content.title}</CardTitle>
              <CardAuthor>{content.nickname}</CardAuthor>
              {/* 일단id 넣기 */}
            </CardBody>
          </Card>
        ))}
      </ContentContainer>
    </>
  );
}

export default ContentSection;
