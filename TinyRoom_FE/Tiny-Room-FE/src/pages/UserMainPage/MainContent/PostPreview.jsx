import {
  Container,
  Content,
  Info,
  Thumbnail,
  ThumbnailWrapper,
  Title,
} from "./PostPreview.style";

const PostPreview = ({ post }) => {
  const { thumbnail, title, text_content } = post;
  return (
    <Container>
      {thumbnail && (
        <ThumbnailWrapper>
          <Thumbnail src="/images/room0.png" alt="PostThumbnail" />
        </ThumbnailWrapper>
      )}

      <Info>
        <Title>sdkfjnadskfnaskdjfbkjsdjbfkjsbksadfasdfasdfasdfasdfasdfjf</Title>
        <Content>
          dlfjasdfkjabiuefiwybfiywbfiywebfiywbfiywbefiywbefyiwefbib
          sjadnfkjsandfkjnsdfjknskjnfksjasdfsadfasdfsadfkhjsdbfjhsf
        </Content>
      </Info>
    </Container>
  );
};

export default PostPreview;
