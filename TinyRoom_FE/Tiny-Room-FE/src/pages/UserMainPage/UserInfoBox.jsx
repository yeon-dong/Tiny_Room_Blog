import Calendar from "../../components/Calendar/Calendar";
import {
  Container,
  DescriptionBox,
  ProfileBox,
  ProfileImageBox,
  UsernameBox,
} from "./UserInfoBox.style";

const UserInfoBox = () => {
  return (
    <Container>
      <ProfileBox>
        <ProfileImageBox>Profile Image</ProfileImageBox>
        <UsernameBox></UsernameBox>
        <DescriptionBox></DescriptionBox>
      </ProfileBox>
      <Calendar />
    </Container>
  );
};

export default UserInfoBox;
