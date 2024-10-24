import { useCallback, useEffect, useMemo, useState } from "react";
import CommentBox from "./CommentBox";
import NewCommentBox from "./NewCommentBox";
import MainButton from "../../../components/MainButton/MainButton";
import RoundedButton from "../../../components/RoundedButton/RoundedButton";
import { useLocation, useNavigate } from "react-router-dom";
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
import Viewer from "../../../components/MyEditor/Viewer";
import MyPagination from "../../../components/Pagination/MyPagination";

const PostDetailContent = () => {
  const location = useLocation();
  const userId = location.pathname.split("/")[1];
  const postId = location.pathname.split("/")[3];

  const navigate = useNavigate();

  const [postData, setPostData] = useState(null);
  const [hasHeart, setHeart] = useState(false);
  const { comment, heartCount, post } = useMemo(() => {
    if (postData === null) return {};
    else {
      return postData;
    }
  }, [postData]);
  const [comments, setComments] = useState({
    totalCount: 0,
    data: [],
  });
  const [commentsPage, setCommentsPage] = useState(1);

  const getPostData = useCallback(async () => {
    const response = await axios.get(
      `http://127.0.0.1:8080/posts/postDetail?post_id=${postId}`
    );

    setPostData(response.data);
  }, []);

  const getComments = useCallback(async (page) => {
    // const response = await axios.get(`http://localhost:8080/comments/view?post_id=${postId}&page=${page}`);

    // setComments(response.data);

    setComments({
      totalCount: 7,
      data: [
        {
          comment_id: 2,
          content: "asdf",
          post_id: 2,
          user_id: 2,
          username: "park",
          parent_id: -1,
          date: "2014.10.21 17:07",
          children: [
            {
              comment_id: 2,
              content:
                "asdfasdfasdfasdfaksjdfhakjshdfkjahsdkjf@@@@@@@@@@@@@@@@@@@@@@@@@@@@@asdfasdfasdfasdfaksjdfhakjshdfkjahsdkjf@@@@@@@@@@@@@@@@@@@@@@@@@@@@@",
              post_id: 2,
              user_id: 2,
              username: "park",
              parent_id: 2,
              date: "2014.10.21 17:07",
            },
            {
              comment_id: 2,
              content:
                "asdfasdfasdfasdfaksjdfhakjshdfkjahsdkjf@@@@@@@@@@@@@@@@@@@@@@@@@@@@@asdfasdfasdfasdfaksjdfhakjshdfkjahsdkjf@@@@@@@@@@@@@@@@@@@@@@@@@@@@@",
              post_id: 2,
              user_id: 2,
              username: "park",
              parent_id: 2,
              date: "2014.10.21 17:07",
            },
          ],
        },
        {
          comment_id: 3,
          content: "asdf",
          post_id: 2,
          user_id: 2,
          username: "kim",
          parent_id: -1,
          date: "2014.10.21 17:07",
          children: [
            {
              comment_id: 2,
              content:
                "asdfasdfasdfasdfaksjdfhakjshdfkjahsdkjf@@@@@@@@@@@@@@@@@@@@@@@@@@@@@asdfasdfasdfasdfaksjdfhakjshdfkjahsdkjf@@@@@@@@@@@@@@@@@@@@@@@@@@@@@",
              post_id: 2,
              user_id: 2,
              username: "park",
              parent_id: 2,
              date: "2014.10.21 17:07",
            },
          ],
        },
      ],
    });
  }, []);

  const checkHeart = useCallback(async () => {
    const response = await axios.get(
      `http://localhost:8080/hearts/view?post_id=${postId}`,
      {
        headers: { auth_token: localStorage.getItem("token") },
      }
    );

    console.log(response.data);

    setHeart(response.data === 1);
  }, []);

  const addHeart = useCallback(async () => {
    const response = await axios.get(
      `http://localhost:8080/hearts/add?post_id=${postId}`,
      {
        headers: { auth_token: localStorage.getItem("token") },
      }
    );

    if (response.data.result === "success") {
      getPostData();
      checkHeart();
    }
  }, []);

  const deleteHeart = useCallback(async () => {
    const response = await axios.delete(
      `http://localhost:8080/hearts/delete?post_id=${postId}`,
      {
        headers: { auth_token: localStorage.getItem("token") },
      }
    );

    if (response.data.result === "success") {
      getPostData();
      checkHeart();
    }
  }, []);

  useEffect(() => {
    getPostData();

    if (localStorage.getItem("token") !== null) {
      checkHeart();
    }
  }, []);

  useEffect(() => {
    getComments(commentsPage);
  }, [commentsPage]);

  const handleHeartClick = useCallback(() => {
    if (hasHeart) {
      deleteHeart();
    } else {
      addHeart();
    }
  }, [hasHeart]);

  const handleCommentsPageChange = useCallback((val) => {
    setCommentsPage(val);
  }, []);

  const handleUpdateClick = useCallback(() => {
    navigate(`/${userId}/post/update/${postId}`);
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
          <RoundedButton
            icon={hasHeart ? "heart.svg" : `heart_empty.svg`}
            onClick={handleHeartClick}
          >
            좋아요 {heartCount}
          </RoundedButton>
          <RoundedButton disabled icon="chat.svg">
            댓글 {comment?.length}
          </RoundedButton>
        </PostInfoBox>
        <PostControlBox>
          <MainButton onClick={handleUpdateClick}>수정</MainButton>
          <MainButton>삭제</MainButton>
        </PostControlBox>
      </PostFooter>
      <CommentBox comments={comments} />
      <PaginationBox>
        <MyPagination
          count={Math.ceil(comments.totalCount / 10)}
          page={commentsPage}
          onChange={handleCommentsPageChange}
        />
      </PaginationBox>
      <NewCommentBox />
    </Container>
  );
};

export default PostDetailContent;
