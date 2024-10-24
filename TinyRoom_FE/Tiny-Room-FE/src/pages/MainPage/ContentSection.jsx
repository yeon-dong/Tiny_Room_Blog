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

function ContentSection({ recommendPost }) {
  const recommendPostArray = Object.values(recommendPost);
  return (
    <>
      <HotTitle>HOT 게시물</HotTitle>
      <ContentContainer>
        {recommendPostArray.map((content, index) => (
          <Card key={index}>
            <CardImage
              src={`http://localhost:8080${content.thumbnail}`}
              alt={content.title}
            />
            <CardBody>
              <CardTitle>{content.title}</CardTitle>
              <CardAuthor>{content.post_id}</CardAuthor>
              {/* 일단id 넣기 */}
            </CardBody>
          </Card>
        ))}
      </ContentContainer>
    </>
  );
}

export default ContentSection;
