import { useLocation, useNavigate, useOutletContext } from "react-router-dom";
import RadioInput from "../../../components/RadioInput/RadioInput";
import {
  BackButton,
  Container,
  Content,
  Header,
  ProfileImageOptionContainer,
  ProfileImageWrapper,
  ButtonBox,
  SimpleButton,
  Input,
  Textarea,
  RadioText,
  ThemeOptionContainer,
  RoomThemeOptionContainer,
  RoomThemeImgWrapper,
  InteriorImgWrapper,
  LivingImgWrapper,
  AgreeBox,
  IconWrapper,
  SubmitButtonWrapper,
} from "./MyPageContent.style";
import OptionItem from "./OptionItem";
import axios from "axios";
import { useCallback, useState } from "react";
import { InteriorImg } from "../MainContent/MyRoom.style";
import MainButton from "../../../components/MainButton/MainButton";
import useStore from "../../../stores/store";

const MyPageContent = () => {
  const location = useLocation();
  const userId = location.pathname.split("/")[1];
  const navigate = useNavigate();

  const { blogData, getBlogData } = useOutletContext();
  const { blog, room, user } = blogData;

  const { userInfo, setUserInfo } = useStore();

  const [profileImg, setProfileImg] = useState(user.profileImg);
  const [nickname, setNickname] = useState(user.nickname);
  const [description, setDescription] = useState(user.description);
  const [blogTheme, setBlogTheme] = useState(blog.blogTheme);
  const [roomTheme, setRoomTheme] = useState(room.roomTheme);
  const [kitchen, setKitchen] = useState(room.furniture1);
  const [interior, setInterior] = useState(room.furniture2);
  const [living, setLiving] = useState(room.furniture3);
  const [electronics, setElectronics] = useState(room.furniture4);
  const [character, setCharacter] = useState(room.character);
  const [isAgree, setAgree] = useState(false);

  const handleFileChange = async (event) => {
    const file = event.target.files[0];
    const formData = new FormData();
    formData.append("img", file);

    const response = await axios.post(
      `http://localhost:8080/image/upload`,
      formData
    );
    const url = response.data;

    setProfileImg(url);
  };

  const handleNicknameChange = useCallback((e) => {
    setNickname(e.target.value);
  }, []);

  const handleDescriptionChange = useCallback((e) => {
    setDescription(e.target.value);
  }, []);

  const handleAgree = useCallback(() => {
    setAgree(!isAgree);
  }, [isAgree]);

  const handleSubmitClick = useCallback(async () => {
    const formData = new FormData();
    formData.append("nickname", nickname);
    formData.append("description", description);
    formData.append("blogTheme", blogTheme);
    formData.append("roomTheme", roomTheme);
    formData.append("furniture1", kitchen);
    formData.append("furniture2", interior);
    formData.append("furniture3", living);
    formData.append("furniture4", electronics);
    formData.append("characterId", character);
    formData.append("profileImg", profileImg);

    const response = await axios.put(
      `http://localhost:8080/member/modify`,
      formData,
      {
        headers: {
          auth_token: localStorage.getItem("token"),
        },
      }
    );

    const info = { ...userInfo, nickname, description, profileImg };
    setUserInfo(info);

    getBlogData();
    // navigate("/" + userId);
  }, [
    userInfo,
    nickname,
    description,
    blogTheme,
    roomTheme,
    kitchen,
    interior,
    living,
    electronics,
    character,
    profileImg,
  ]);

  return (
    <Container>
      <Header>
        <BackButton>
          <img src="/images/arrow_back.svg" alt="BackButton" />
        </BackButton>
        블로그 정보
      </Header>
      <Content>
        <OptionItem label="프로필 이미지">
          <ProfileImageOptionContainer>
            <ProfileImageWrapper>
              <img
                src={`http://localhost:8080${profileImg}`}
                alt="ProfileImage"
              />
            </ProfileImageWrapper>
            <input
              type="file"
              id="file-upload"
              accept="image/*" // 이미지 파일만 허용
              style={{ display: "none" }} // 기본 파일 입력 숨기기
              onChange={handleFileChange}
            />
            <ButtonBox>
              <SimpleButton
                onClick={() => document.getElementById("file-upload").click()} // 파일 입력 클릭
              >
                등록
              </SimpleButton>
              <SimpleButton
              // onClick={handleDeleteImage} // 이미지 삭제 클릭
              >
                삭제
              </SimpleButton>
            </ButtonBox>
          </ProfileImageOptionContainer>
        </OptionItem>
        {/* <OptionItem label="이름">
          <Input disabled value={name} onChange={handleNameChange} />
        </OptionItem> */}
        <OptionItem label="닉네임">
          <Input value={nickname} onChange={handleNicknameChange} />
        </OptionItem>
        <OptionItem label="소개글">
          <Textarea value={description} onChange={handleDescriptionChange} />
        </OptionItem>
        <OptionItem label="블로그 테마">
          <ThemeOptionContainer>
            <RadioInput
              checked={blogTheme === 0}
              onChange={(e) => setBlogTheme(0)}
            >
              <RadioText>핑크</RadioText>
            </RadioInput>
            <RadioInput
              checked={blogTheme === 1}
              onChange={(e) => setBlogTheme(1)}
            >
              <RadioText>하늘</RadioText>
            </RadioInput>
          </ThemeOptionContainer>
        </OptionItem>
        <OptionItem label="마이룸 테마">
          <RoomThemeOptionContainer>
            {Array.from({ length: 5 }, (v, i) => i).map((id) => (
              <RadioInput
                key={id}
                checked={roomTheme === id}
                onChange={(e) => setRoomTheme(id)}
              >
                <RoomThemeImgWrapper>
                  <img
                    src={`/images/room_theme_${id + 1}.svg`}
                    alt={`RoomTheme${id + 1}`}
                  />
                </RoomThemeImgWrapper>
              </RadioInput>
            ))}
          </RoomThemeOptionContainer>
        </OptionItem>
        <OptionItem label="주방가전제품">
          <RoomThemeOptionContainer>
            {Array.from({ length: 5 }, (v, i) => i).map((id) => (
              <RadioInput
                key={id}
                checked={kitchen === id}
                onChange={(e) => setKitchen(id)}
              >
                <RoomThemeImgWrapper>
                  <img
                    src={`/images/kitchen${id}sm.png`}
                    alt={`Kitchen${id}`}
                  />
                </RoomThemeImgWrapper>
              </RadioInput>
            ))}
          </RoomThemeOptionContainer>
        </OptionItem>
        <OptionItem label="홈 인테리어">
          <RoomThemeOptionContainer>
            {Array.from({ length: 5 }, (v, i) => i).map((id) => (
              <RadioInput
                key={id}
                checked={interior === id}
                onChange={(e) => setInterior(id)}
              >
                <InteriorImgWrapper>
                  <img
                    src={`/images/interior${id}sm.png`}
                    alt={`Interior${id}`}
                  />
                </InteriorImgWrapper>
              </RadioInput>
            ))}
          </RoomThemeOptionContainer>
        </OptionItem>
        <OptionItem label="실내가구">
          <RoomThemeOptionContainer>
            {Array.from({ length: 5 }, (v, i) => i).map((id) => (
              <RadioInput
                key={id}
                checked={living === id}
                onChange={(e) => setLiving(id)}
              >
                <LivingImgWrapper>
                  <img src={`/images/living${id}sm.png`} alt={`Living${id}`} />
                </LivingImgWrapper>
              </RadioInput>
            ))}
          </RoomThemeOptionContainer>
        </OptionItem>
        <OptionItem label="전자제품">
          <RoomThemeOptionContainer>
            {Array.from({ length: 5 }, (v, i) => i).map((id) => (
              <RadioInput
                key={id}
                checked={electronics === id}
                onChange={(e) => setElectronics(id)}
              >
                <InteriorImgWrapper>
                  <img
                    src={`/images/electronics${id}sm.png`}
                    alt={`Electronics${id}`}
                  />
                </InteriorImgWrapper>
              </RadioInput>
            ))}
          </RoomThemeOptionContainer>
        </OptionItem>
        <OptionItem label="캐릭터">
          <RoomThemeOptionContainer>
            {Array.from({ length: 4 }, (v, i) => i).map((id) => (
              <RadioInput
                key={id}
                checked={character === id}
                onChange={(e) => setCharacter(id)}
              >
                <InteriorImgWrapper>
                  <img
                    src={`/images/character${id}.gif`}
                    alt={`Character${id}`}
                  />
                </InteriorImgWrapper>
              </RadioInput>
            ))}
          </RoomThemeOptionContainer>
        </OptionItem>
        <AgreeBox onClick={handleAgree}>
          <IconWrapper>
            <img
              src={`/images/Check Mark${isAgree ? "2" : ""}.svg`}
              alt="Check"
            />
          </IconWrapper>
          변경된 내용을 모두 확인 완료하였습니다.
        </AgreeBox>
        <SubmitButtonWrapper>
          <MainButton strong disabled={!isAgree} onClick={handleSubmitClick}>
            변경 완료
          </MainButton>
        </SubmitButtonWrapper>
      </Content>
    </Container>
  );
};

export default MyPageContent;
