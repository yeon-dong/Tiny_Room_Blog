import { useCallback } from "react";
import {
  BlogName,
  Container,
  Content,
  Description,
  ProfileImage,
  Title,
} from "./NeighbourItem.style";
import { useNavigate } from "react-router-dom";

const NeighbourItem = ({ neighbour, idx }) => {
  const navigate = useNavigate();

  const handleClick = useCallback(() => {
    navigate(`/${neighbour.user_id}`);
  }, []);

  return (
    <Container>
      <Title onClick={handleClick}>
        <BlogName>
          <span>No. {idx + 1}</span> {neighbour.blog_name}
        </BlogName>
      </Title>
      <Content onClick={handleClick}>
        <ProfileImage>
          <img
            src={`http://localhost:8080${neighbour.profile_img}`}
            alt="ProfileImg"
          />
        </ProfileImage>
        <Description>{neighbour.description}</Description>
      </Content>
    </Container>
  );
};

export default NeighbourItem;
