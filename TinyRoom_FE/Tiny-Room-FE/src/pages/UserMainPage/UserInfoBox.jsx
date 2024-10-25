import Calendar from "../../components/Calendar/Calendar";
import {
  Container,
  DescriptionBox,
  EditButton,
  NeighborButton,
  ProfileBox,
  ProfileImageBox,
  UsernameBox,
} from "./UserInfoBox.style";
import useStore from "../../stores/store";
import { useParams } from "react-router-dom";
import { useState } from "react";
import NeighborModal from "../../components/NeighborModal/NeighborModal";

const UserInfoBox = ({
  userId,
  profileImg,
  nickname,
  description,
  blogData,
}) => {
  const { id, postId } = useParams();
  const { userInfo } = useStore();
  const [isModalOpen, setIsModalOpen] = useState(false);
  const isLogin = userInfo != null; // 로그인 되어있으면 true 반환
  const isMyRoom = isLogin ? userInfo.id == id : false; // 로그인 id와 path 같으면 true반환
  const handleModalOpen = () => {
    setIsModalOpen(true);
  };
  const handleModalClose = () => {
    setIsModalOpen(false);
  };

  return (
    <Container>
      <ProfileBox>
        <ProfileImageBox>
          <img src={`http://localhost:8080${profileImg}`} alt="ProfileImage" />
        </ProfileImageBox>
        <UsernameBox>
          {nickname}
          {isLogin ? (
            isMyRoom ? (
              <EditButton to={`/${userId}/mypage`}>Edit</EditButton>
            ) : (
              <NeighborButton onClick={() => handleModalOpen()}>
                이웃추가
              </NeighborButton>
            )
          ) : (
            <></>
          )}
        </UsernameBox>
        <DescriptionBox>{description}</DescriptionBox>
      </ProfileBox>
      <Calendar userId={userId} />
      {isModalOpen && (
        <NeighborModal
          handleModalClose={handleModalClose}
          nickname={nickname}
          blogData={blogData}
        />
      )}
    </Container>
  );
};

export default UserInfoBox;
