import React from "react";
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
} from "./RecentContentSection.style";

export const RecentContentSection = () => {
  const posts = [
    {
      profileImage: "/images/user1.JPG",
      coverImage: "/images/cover1.png",
      author: "림동연",
      time: "20시간 전",
      title: "세상에서 제일 좋아하는 포스터 입니다.",
      text: "제가 진짜로 좋아하는 포스터 입니다 이 포스터를 통해서 많은 걸 배웠는데 일단 제가 진짜로 좋아하는 포스터 입니다 이 포스터를 통해서 많은 걸 배웠는데 일단 제가 진짜로 좋아하는 포스터 입니다 이 포스터를 통해서 많은 걸 배웠는데 일단 제가 진짜로 좋아하는 포스터 입니다 이 포스터를 통해서 많은 걸 배웠는데 일단...",
      likes: 72,
      comments: 72,
    },
    // 다른 게시글 추가 가능
    {
      profileImage: "/images/user1.JPG",
      coverImage: "/images/cover1.png",
      author: "림동연",
      time: "20시간 전",
      title: "세상에서 제일 좋아하는 포스터 입니다.",
      text: "제가 진짜로 좋아하는 포스터 입니다. 이 포스터를 통해서 많은 걸 배웠는데...",
      likes: 72,
      comments: 72,
    },
  ];

  return (
    <>
      <LatestTitle>최신글</LatestTitle>
      <PostListContainer>
        {posts.map((post, index) => (
          <PostItem key={index}>
            <PostCoverImage src={post.coverImage} alt={post.title} />
            <PostContent>
              <PostHeader>
                <ProfileImage src={post.profileImage} alt={post.author} />
                <AuthorInfo>
                  <AuthorName>{post.author}</AuthorName>
                  <PostTime>{post.time}</PostTime>
                </AuthorInfo>
              </PostHeader>
              <PostTitle>{post.title}</PostTitle>
              <PostText>{post.text}</PostText>
              <PostFooter>
                <PostFooterItem>
                  <Icon>좋아요</Icon> {post.likes}
                </PostFooterItem>
                <PostFooterItem>
                  <Icon>댓글</Icon> {post.comments}
                </PostFooterItem>
              </PostFooter>
            </PostContent>
          </PostItem>
        ))}
      </PostListContainer>
    </>
  );
};

export default RecentContentSection;
