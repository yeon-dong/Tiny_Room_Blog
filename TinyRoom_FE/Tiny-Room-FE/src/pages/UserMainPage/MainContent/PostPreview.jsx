import {
  Container,
  Content,
  Info,
  Thumbnail,
  ThumbnailWrapper,
  Title,
} from "./PostPreview.style";

const PostPreview = ({ post }) => {
  const { thumbnail, title, textContent } = post;
  return (
    <Container>
      {thumbnail && (
        <ThumbnailWrapper>
          <Thumbnail
            src={`http://localhost:8080${thumbnail}`}
            alt="PostThumbnail"
          />
        </ThumbnailWrapper>
      )}

      <Info>
        <Title>{title}</Title>
        <Content>{textContent}</Content>
      </Info>
    </Container>
  );
};

export default PostPreview;
