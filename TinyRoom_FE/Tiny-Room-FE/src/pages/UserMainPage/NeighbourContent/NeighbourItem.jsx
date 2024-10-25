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

  const member = neighbour.fromMember;

  const handleClick = useCallback(() => {
    navigate(`/${member.member_id}`);
  }, []);

  return (
    <Container>
      <Title onClick={handleClick}>
        <BlogName>
          <span>No. {idx + 1}</span> 블로그 이름
        </BlogName>
      </Title>
      <Content onClick={handleClick}>
        <ProfileImage>
          <img
            src={`http://localhost:8080${member.profile_img}`}
            alt="ProfileImg"
          />
        </ProfileImage>
        <Description>{member.description}</Description>
      </Content>
    </Container>
  );
};

export default NeighbourItem;
