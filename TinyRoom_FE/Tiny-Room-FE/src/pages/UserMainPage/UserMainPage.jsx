import React, { useCallback, useEffect, useState } from "react";
import {
  Wrapper,
  Container,
  UserBlogBox,
  UserBlogContainer,
  UserBlogHeaderContainer,
  UserBlogHeaderText,
  UserBlogHeaderTextBetweenLine,
  UserBlogNameLine,
  BlogNameText,
  UserInfoContainer,
  BlogNameBox,
  ContainerBox,
  MenuBox,
  LogoutButton,
} from "./UserMainPage.style";
import UserInfoBox from "./UserInfoBox";
import { Outlet, useLocation } from "react-router-dom";

function UserMainPage() {
  const loc = useLocation();

  const [blogData, setBlogData] = useState(null);

  const getBlogData = useCallback(async () => {
    const userId = loc.pathname.substring(1);

    // const response = await axios.get(`/blog/${userId}`);

    // TODO: 더미데이터
    setBlogData({
      user: {
        profileImg: "https://naver.com",
        nickname: "Nickname",
        description: "This is my blog, Thank you",
      },
      blog: {
        title: "Blog Title",
        blogTheme: 0,
      },
      room: {
        theme: 0,
        furniture1: 0,
        furniture2: 0,
        furniture3: 0,
        furniture4: 0,
      },
    });
  }, []);

  useEffect(() => {
    getBlogData();
  }, []);

  return (
    <>
      <Wrapper>
        <ContainerBox>
          <Container>
            <UserInfoContainer>
              <BlogNameBox>
                <BlogNameText>{blogData?.blog.title}</BlogNameText>
                <UserBlogNameLine src="/images/very_cute_kitty.gif" />
              </BlogNameBox>
              <UserInfoBox
                profileImg={blogData?.user.profileImg}
                nickname={blogData?.user.nickname}
                description={blogData?.user.description}
              />
            </UserInfoContainer>
            <UserBlogContainer>
              <UserBlogHeaderContainer>
                <MenuBox>
                  <UserBlogHeaderText>메인페이지</UserBlogHeaderText>
                  <UserBlogHeaderTextBetweenLine src="/images/Line 2.svg" />
                  <UserBlogHeaderText>이웃목록</UserBlogHeaderText>
                </MenuBox>
                <LogoutButton>로그아웃</LogoutButton>
              </UserBlogHeaderContainer>
              <UserBlogBox>
                <Outlet context={blogData} />
              </UserBlogBox>
            </UserBlogContainer>
          </Container>
        </ContainerBox>
      </Wrapper>
    </>
  );
}

export default UserMainPage;
