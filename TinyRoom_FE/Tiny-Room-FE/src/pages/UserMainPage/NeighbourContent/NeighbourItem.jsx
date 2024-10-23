import {
  BlogName,
  Container,
  Content,
  Description,
  ProfileImage,
  Title,
} from "./NeighbourItem.style";

const NeighbourItem = () => {
  return (
    <Container>
      <Title>
        <BlogName>
          <span>No. 1</span> 블로그 이름
        </BlogName>
      </Title>
      <Content>
        <ProfileImage></ProfileImage>
        <Description>
          blog descriptionblog descriptionblog descriptionblog descriptionblog
          descriptionblog descriptionblog descriptionblog descriptionblog
          descriptionblog descriptionblog descriptionblog descriptionblog
          descriptionblog descriptionblog descriptionblog descriptionblog
          descriptionblog descriptionblog descriptionblog descriptionblog
          descriptionblog descriptionblog descriptionblog descriptionblog
          descriptionblog descriptionblog descriptionblog descriptionblog{" "}
        </Description>
      </Content>
    </Container>
  );
};

export default NeighbourItem;
