import React, { useCallback, useEffect, useState } from "react";
import {
  Wrapper,
  Container,
  UserBlogBox,
  UserBlogContainer,
  UserBlogHeaderContainer,
  UserBlogHeaderLink,
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
import { Outlet, useLocation, useNavigate } from "react-router-dom";

function UserMainPage() {
  const location = useLocation();
  const userId = location.pathname.split("/")[1];
  const navigate = useNavigate();

  const at = localStorage.getItem("at");

  const [blogData, setBlogData] = useState(null);

  const getBlogData = useCallback(async () => {
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

  const handleBlogTitleClick = useCallback(() => {
    navigate(`/${userId}`);
  }, []);

  const handleLogoutClick = useCallback(() => {
    if (at !== null) {
      // TODO: Logout
    } else {
      navigate("/login");
    }
  }, []);

  return (
    <>
      <Wrapper>
        <ContainerBox>
          <Container>
            <UserInfoContainer>
              <BlogNameBox onClick={handleBlogTitleClick}>
                <BlogNameText>{blogData?.blog.title}</BlogNameText>
                <UserBlogNameLine src="/images/very_cute_kitty.gif" />
              </BlogNameBox>
              <UserInfoBox
                userId={userId}
                profileImg={blogData?.user.profileImg}
                nickname={blogData?.user.nickname}
                description={blogData?.user.description}
              />
            </UserInfoContainer>
            <UserBlogContainer>
              <UserBlogHeaderContainer>
                <MenuBox>
                  <UserBlogHeaderLink to="/">메인페이지</UserBlogHeaderLink>
                  <UserBlogHeaderTextBetweenLine src="/images/Line 2.svg" />
                  <UserBlogHeaderLink to={`/${userId}/neighbour`}>
                    이웃목록
                  </UserBlogHeaderLink>
                </MenuBox>
                <LogoutButton onClick={handleLogoutClick}>
                  {at === null ? "로그인" : "로그아웃"}
                </LogoutButton>
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
