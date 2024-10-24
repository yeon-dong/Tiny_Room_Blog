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

export const ContentSection = () => {
  const contents = [
    {
      imgSrc: "/images/post1.jpg",
      title: "초미녀의 정산일기 구경하러 오세요 ~",
      author: "지농이",
    },
    {
      imgSrc: "/images/post2.jpg",
      title: "림동연네 방 이불은 핑크 색",
      author: "림동연",
    },
    {
      imgSrc: "/images/post3.jpg",
      title: "은솔이네 여행기 in 사이판 즐거운 여행이 됐어요",
      author: "오은솔",
    },
  ];

  return (
    <>
      <HotTitle>HOT 게시물</HotTitle>
      <ContentContainer>
        {contents.map((content, index) => (
          <Card key={index}>
            <CardImage src={content.imgSrc} alt={content.title} />
            <CardBody>
              <CardTitle>{content.title}</CardTitle>
              <CardAuthor>{content.author}</CardAuthor>
            </CardBody>
          </Card>
        ))}
      </ContentContainer>
    </>
  );
};

export default ContentSection;
