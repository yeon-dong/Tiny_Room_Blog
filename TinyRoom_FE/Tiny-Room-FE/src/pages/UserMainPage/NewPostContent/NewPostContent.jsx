import Dropdown from "../../../components/Dropdown/Dropdown";
import MainButton from "../../../components/MainButton/MainButton";
import {
  BackButton,
  ButtonBox,
  Container,
  DropdownWrapper,
  EditorWrapper,
  Header,
  TitleBox,
  TitleInput,
} from "./NewPostContent.style";

const NewPostContent = () => {
  return (
    <Container>
      <Header>
        <BackButton>
          <img src="/images/arrow_back.svg" alt="BackButton" />
        </BackButton>
        홈 인테리어
      </Header>
      <TitleBox>
        <DropdownWrapper>
          <Dropdown />
        </DropdownWrapper>
        <TitleInput placeholder="제목을 입력해주세요." />
      </TitleBox>
      <EditorWrapper></EditorWrapper>
      <ButtonBox>
        <MainButton>목록</MainButton>
        <MainButton>작성 완료</MainButton>
      </ButtonBox>
    </Container>
  );
};

export default NewPostContent;
