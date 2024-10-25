import { useEffect, useMemo, useRef, useState } from "react";
import {
  LatestTitle,
  PostListContainer,
  PostItem,
  ProfileImage,
  PostContent,
  PostHeader,
  AuthorInfo,
  AuthorName,
  PostTime,
  PostCoverImage,
  PostTitle,
  PostText,
  PostFooter,
  PostFooterItem,
  Icon,
  PagenationContainer,
} from "./RecentContentSection.style";
import axios from "axios";
import MyPagination from "../../components/Pagination/MyPagination";
import { useNavigate } from "react-router-dom";

function RecentContentSection({ category }) {
  const navigate = useNavigate();
  const [posts, setPosts] = useState([]);
  const [page, setPage] = useState(1); // 초기 페이지 설정
  const [totalPageCount, setTotalPageCount] = useState(0);

  const fetchPosts = async () => {
    try {
      const response = await axios.get(
        `http://localhost:8080/posts/main?category=${category}&page=${page - 1}`
      );
      setPosts(response.data.newPosts); // API 응답 데이터로 posts 상태 업데이트
      setTotalPageCount(response.data.totalCount);
    } catch (error) {
      console.error("Error fetching posts:", error);
    }
  };

  useEffect(() => {
    fetchPosts(); // 컴포넌트가 마운트될 때 게시글을 가져옴
  }, [page, category]); // 페이지가 변경될 때마다 게시글을 다시 가져옴

  const handleGoToPost = (userId, id) => {
    navigate(`/${userId}/post/${id}`);
  };

  // const posts = [
  //   {
  //     profileImage: "/images/user1.JPG",
  //     coverImage: "/images/cover1.png",
  //     author: "림동연",
  //     time: "20시간 전",
  //     title: "세상에서 제일 좋아하는 포스터 입니다.",
  //     text: "제가 진짜로 좋아하는 포스터 입니다 이 포스터를 통해서 많은 걸 배웠는데 일단 제가 진짜로 좋아하는 포스터 입니다 이 포스터를 통해서 많은 걸 배웠는데 일단 제가 진짜로 좋아하는 포스터 입니다 이 포스터를 통해서 많은 걸 배웠는데 일단 제가 진짜로 좋아하는 포스터 입니다 이 포스터를 통해서 많은 걸 배웠는데 일단...",
  //     likes: 72,
  //     comments: 72,
  //   },
  //   // 다른 게시글 추가 가능
  //   {
  //     profileImage: "/images/user1.JPG",
  //     coverImage: "/images/cover1.png",
  //     author: "림동연",
  //     time: "20시간 전",
  //     title: "세상에서 제일 좋아하는 포스터 입니다.",
  //     text: "제가 진짜로 좋아하는 포스터 입니다. 이 포스터를 통해서 많은 걸 배웠는데...",
  //     likes: 72,
  //     comments: 72,
  //   },
  // ];

  return (
    <>
      <LatestTitle>최신글</LatestTitle>
      <PostListContainer>
        {posts.map((post, index) => (
          <PostItem key={index}>
            <PostCoverImage
              src={`http://localhost:8080${post.thumbnail}`}
              alt={post.title}
              onClick={() => handleGoToPost(post.user.userId, post.postId)}
            />
            <PostContent
              onClick={() => handleGoToPost(post.user.userId, post.postId)}
            >
              <PostHeader>
                <ProfileImage
                  src={`http://localhost:8080${post.user.profileImg}`}
                  alt={post.user.nickname}
                />
                <AuthorInfo>
                  <AuthorName>{post.user.nickname}</AuthorName>
                  <PostTime>{post.time}</PostTime>
                </AuthorInfo>
              </PostHeader>
              <PostTitle>{post.title}</PostTitle>
              <PostText>{post.textContent}</PostText>
              <PostFooter>
                <PostFooterItem>
                  <Icon>좋아요</Icon> {post.heartCount}
                </PostFooterItem>
                <PostFooterItem>
                  <Icon>댓글</Icon> {post.commentCount}
                </PostFooterItem>
              </PostFooter>
            </PostContent>
          </PostItem>
        ))}
        <PagenationContainer>
          {posts.length != 0 && (
            <MyPagination
              count={Math.ceil(totalPageCount / 10)}
              page={page}
              onChange={(event, newPage) => setPage(newPage)}
            />
          )}
        </PagenationContainer>
      </PostListContainer>
    </>
  );
}

export default RecentContentSection;
