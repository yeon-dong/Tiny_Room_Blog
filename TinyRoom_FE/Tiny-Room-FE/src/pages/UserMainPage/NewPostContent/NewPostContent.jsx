import { useLocation, useNavigate, useParams } from "react-router-dom";
import Dropdown from "../../../components/Dropdown/Dropdown";
import MainButton from "../../../components/MainButton/MainButton";
import MyEditor from "../../../components/MyEditor/MyEditor";
import { DatePicker } from "@mui/x-date-pickers/DatePicker";
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
import { useCallback, useEffect, useMemo, useRef, useState } from "react";
import axios from "axios";
import dayjs from "dayjs";
import { LocalizationProvider } from "@mui/x-date-pickers/LocalizationProvider";
import { AdapterDayjs } from "@mui/x-date-pickers/AdapterDayjs";

const categoryToIdx = {
  주방가전제품: 0,
  "홈 인테리어": 1,
  실내가구: 2,
  전자제품: 3,
};

const NewPostContent = () => {
  const location = useLocation();
  const isUpdate = location.pathname.split("/").length === 5;
  const postId = isUpdate ? location.pathname.split("/")[4] : -1;
  const navigate = useNavigate();
  const { id } = useParams();

  const at = localStorage.getItem("token");

  const editorRef = useRef(null);

  const [categoryIdx, setCategoryIdx] = useState(-1);
  const [title, setTitle] = useState("");
  const [content, setContent] = useState("");
  const [date, setDate] = useState(dayjs());

  const getPostData = useCallback(async () => {
    try {
      const response = await axios.get(
        `http://127.0.0.1:8080/posts/postDetail?post_id=${postId}`
      );

      const { category, content, title, date } = response.data.post;
      setCategoryIdx(categoryToIdx[category.category_name]);
      setTitle(title);
      setContent(content);
      setDate(dayjs(date));
    } catch (e) {
      console.log(e);
      alert("에러가 발생했습니다.");
    }
  }, []);

  useEffect(() => {
    if (isUpdate) getPostData();
  }, []);

  const handleCategoryChange = useCallback((i) => {
    setCategoryIdx(i);
  }, []);

  const handleDateChange = useCallback((newDate) => {
    setDate(newDate);
  }, []);

  const handleTitleChange = useCallback((e) => {
    setTitle(e.target.value);
  }, []);

  const handleContentChange = useCallback((value) => {
    setContent(value);
  }, []);

  const getThumbnail = useCallback(() => {
    const editor = editorRef?.current.getEditor();
    const editorContent = editor.getContents().ops;

    const foundItem = editorContent.find(
      (item) => typeof item.insert === "object" && "image" in item?.insert
    );

    if (!foundItem) return "";

    const url = foundItem.insert.image;

    return url.substring(url.indexOf("/image/"));
  }, []);

  const handleUpdateClick = useCallback(async () => {
    const thumbnail = getThumbnail();
    const textContent = editorRef?.current.getEditor().getText();

    if (!isUpdate) {
      try {
        const response = await axios.post(
          `http://localhost:8080/posts/writePost`,
          {
            category_id: categoryIdx + 1,
            date: date.format("YYYY-MM-DD"),
            title: title,
            content: content,
            text_content: textContent,
            thumbnail: thumbnail,
          },
          {
            headers: { auth_token: at },
          }
        );
        navigate(`/${id}`);
      } catch (e) {
        alert("글 작성 실패");
      }
    } else {
      try {
        const response = await axios.put(
          `http://localhost:8080/posts/postUpdate?post_id=${postId}`,
          {
            category_id: categoryIdx + 1,
            date: date.format("YYYY-MM-DD"),
            title: title,
            content: content,
            text_content: textContent,
            thumbnail: thumbnail,
          },
          {
            headers: { auth_token: at },
          }
        );

        navigate(`/${id}`);
      } catch (e) {
        alert("글 수정 실패");
      }
    }
  }, [categoryIdx, date, title, content]);

  const handleBackClick = useCallback(() => {
    navigate(-1);
  }, []);

  return (
    <Container>
      <Header>
        <BackButton onClick={handleBackClick}>
          <img src="/images/arrow_back.svg" alt="BackButton" />
        </BackButton>
        홈 인테리어
      </Header>
      <TitleBox>
        <DropdownWrapper>
          <Dropdown
            value={categoryIdx}
            values={["주방가전제품", "홈 인테리어", "실내가전", "전자제품"]}
            onChange={handleCategoryChange}
          />
          <LocalizationProvider dateAdapter={AdapterDayjs}>
            <DatePicker
              label="날짜"
              slotProps={{
                textField: { size: "small" },
              }}
              value={date}
              onChange={handleDateChange}
            />
          </LocalizationProvider>
        </DropdownWrapper>
        <TitleInput
          placeholder="제목을 입력해주세요."
          value={title}
          onChange={handleTitleChange}
        />
      </TitleBox>
      <EditorWrapper>
        <MyEditor
          value={content}
          ref={editorRef}
          onChange={handleContentChange}
        />
      </EditorWrapper>
      <ButtonBox>
        <MainButton>목록</MainButton>
        <MainButton strong onClick={handleUpdateClick}>
          작성 완료
        </MainButton>
      </ButtonBox>
    </Container>
  );
};

export default NewPostContent;
