import Calendar from "../../components/Calendar/Calendar";
import {
  Container,
  DescriptionBox,
  EditButton,
  ProfileBox,
  ProfileImageBox,
  UsernameBox,
} from "./UserInfoBox.style";

const UserInfoBox = ({ userId, profileImg, nickname, description }) => {
  const at = localStorage.getItem("at");

  return (
    <Container>
      <ProfileBox>
        <ProfileImageBox>
          <img src={`http://localhost:8080${profileImg}`} alt="ProfileImage" />
        </ProfileImageBox>
        <UsernameBox>
          {nickname}
          {at !== null && (
            <EditButton to={`/${userId}/mypage`}>Edit</EditButton>
          )}
        </UsernameBox>
        <DescriptionBox>{description}</DescriptionBox>
      </ProfileBox>
      <Calendar />
    </Container>
  );
};

export default UserInfoBox;
