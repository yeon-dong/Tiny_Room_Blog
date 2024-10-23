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
} from "./MyPageContent.style";
import OptionItem from "./OptionItem";

const MyPageContent = () => {
  return (
    <Container>
      <Header>
        <BackButton>
          <img src="/images/arrow_back.svg" alt="BackButton" />
        </BackButton>
        블로그 정보
      </Header>
      <Content>
        <OptionItem label="블로그 테마">
          <ProfileImageOptionContainer>
            <ProfileImageWrapper>
              <img src="/images/Group 46.svg" alt="ProfileImage" />
            </ProfileImageWrapper>
            <ButtonBox>
              <SimpleButton>등록</SimpleButton>
              <SimpleButton>삭제</SimpleButton>
            </ButtonBox>
          </ProfileImageOptionContainer>
        </OptionItem>
        <OptionItem label="이름">
          <Input />
        </OptionItem>
        <OptionItem label="닉네임">
          <Input />
        </OptionItem>
        <OptionItem label="소개글">
          <Textarea />
        </OptionItem>
        <OptionItem label="블로그 테마">
          <ThemeOptionContainer>
            <RadioInput>
              <RadioText>핑크</RadioText>
            </RadioInput>
            <RadioInput>
              <RadioText>하늘</RadioText>
            </RadioInput>
            <RadioInput>
              <RadioText>커스텀</RadioText>
            </RadioInput>
          </ThemeOptionContainer>
        </OptionItem>
        <OptionItem>
          <ProfileImageOptionContainer>
            <ProfileImageWrapper>
              <img src="/images/Group 46.svg" alt="BackgroundImage" />
            </ProfileImageWrapper>
            <ButtonBox>
              <SimpleButton>등록</SimpleButton>
              <SimpleButton>삭제</SimpleButton>
            </ButtonBox>
          </ProfileImageOptionContainer>
        </OptionItem>
        <OptionItem label="마이룸 테마">
          <RoomThemeOptionContainer>
            <RadioInput>
              <RoomThemeImgWrapper>
                <img src="/images/room_theme_1.svg" alt="RoomTheme1" />
              </RoomThemeImgWrapper>
            </RadioInput>
            <RadioInput>
              <RoomThemeImgWrapper>
                <img src="/images/room_theme_2.svg" alt="RoomTheme2" />
              </RoomThemeImgWrapper>
            </RadioInput>
            <RadioInput>
              <RoomThemeImgWrapper>
                <img src="/images/room_theme_3.svg" alt="RoomTheme3" />
              </RoomThemeImgWrapper>
            </RadioInput>
            <RadioInput>
              <RoomThemeImgWrapper>
                <img src="/images/room_theme_4.svg" alt="RoomTheme4" />
              </RoomThemeImgWrapper>
            </RadioInput>
            <RadioInput>
              <RoomThemeImgWrapper>
                <img src="/images/room_theme_5.svg" alt="RoomTheme5" />
              </RoomThemeImgWrapper>
            </RadioInput>
          </RoomThemeOptionContainer>
        </OptionItem>
      </Content>
    </Container>
  );
};

export default MyPageContent;
