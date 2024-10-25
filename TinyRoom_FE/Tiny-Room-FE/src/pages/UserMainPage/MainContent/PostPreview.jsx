import { useCallback } from "react";
import {
  Container,
  Content,
  Info,
  Thumbnail,
  ThumbnailWrapper,
  Title,
} from "./PostPreview.style";
import { useLocation, useNavigate } from "react-router-dom";

const PostPreview = ({ post }) => {
  const location = useLocation();
  const userId = location.pathname.split("/")[1];
  const navigate = useNavigate();

  const { postId, thumbnail, title, textContent } = post;

  const handleClick = useCallback(() => {
    navigate(`/${userId}/post/${postId}`);
  }, []);

  return (
    <Container onClick={handleClick}>
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
