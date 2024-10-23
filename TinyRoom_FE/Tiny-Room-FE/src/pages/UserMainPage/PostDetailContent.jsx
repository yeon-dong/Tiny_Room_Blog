import { useCallback, useEffect, useMemo, useState } from "react";
import MainButton from "../../components/MainButton/MainButton";
import RoundedButton from "../../components/RoundedButton/RoundedButton";
import CommentBox from "./CommentBox";
import NewCommentBox from "./NewCommentBox";
import { useLocation } from "react-router-dom";
import axios from "axios";
import dayjs from "dayjs";
import {
  BackButton,
  Container,
  Header,
  PaginationBox,
  PostContent,
  PostControlBox,
  PostDate,
  PostDateBox,
  PostFooter,
  PostHeader,
  PostHeaderDivLine,
  PostInfoBox,
  PostTitle,
  PostUpdatedAt,
  PostWeekday,
} from "./PostDetailContent.style";
import Viewer from "../../components/MyEditor/Viewer";

const PostDetailContent = () => {
  const location = useLocation();

  const [postData, setPostData] = useState(null);
  const { comment, heartCount, post } = useMemo(() => {
    if (postData === null) return {};
    else {
      return postData;
    }
  }, [postData]);

  const getPostData = useCallback(async () => {
    const postId = location.pathname.split("/")[3];

    const response = await axios.get(
      `http://127.0.0.1:8080/posts/postDetail?post_id=${postId}`
    );

    setPostData(response.data);
  }, []);

  useEffect(() => {
    getPostData();

    // TODO if loged in,
    if (true) {
    }
  }, []);

  return (
    <Container>
      <Header>
        <BackButton>
          <img src="/images/arrow_back.svg" alt="BackButton" />
        </BackButton>
        {post?.category.category_name}
      </Header>
      <PostHeader>
        <PostDateBox>
          <PostDate>{post ? dayjs(post.date).format("M.D") : ""}</PostDate>
          <PostWeekday>
            {post ? dayjs(post.date).format("ddd") : ""}
          </PostWeekday>
        </PostDateBox>
        <PostHeaderDivLine />
        <PostTitle>{post?.title}</PostTitle>
      </PostHeader>
      <PostContent>
        <PostUpdatedAt>{post?.w_date} 최근 작성</PostUpdatedAt>
        <Viewer value={post?.content} />
      </PostContent>
      <PostFooter>
        <PostInfoBox>
          <RoundedButton icon="heart_empty.svg">
            좋아요 {heartCount}
          </RoundedButton>
          <RoundedButton disabled icon="chat.svg">
            댓글 {comment?.length}
          </RoundedButton>
        </PostInfoBox>
        <PostControlBox>
          <MainButton>수정</MainButton>
          <MainButton>삭제</MainButton>
        </PostControlBox>
      </PostFooter>
      <CommentBox />
      <PaginationBox></PaginationBox>
      <NewCommentBox />
    </Container>
  );
};

export default PostDetailContent;
