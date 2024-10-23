import Calendar from "../../components/Calendar/Calendar";
import {
  Container,
  DescriptionBox,
  EditButton,
  ProfileBox,
  ProfileImageBox,
  UsernameBox,
} from "./UserInfoBox.style";

const UserInfoBox = ({ profileImg, nickname, description }) => {
  return (
    <Container>
      <ProfileBox>
        <ProfileImageBox>{profileImg}</ProfileImageBox>
        <UsernameBox>
          {nickname}
          <EditButton>Edit</EditButton>
        </UsernameBox>
        <DescriptionBox>{description}</DescriptionBox>
      </ProfileBox>
      <Calendar />
    </Container>
  );
};

export default UserInfoBox;
