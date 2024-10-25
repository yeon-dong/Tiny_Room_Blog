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
import { Outlet, useLocation, useNavigate, useParams } from "react-router-dom";
import axios from "axios";
import useStore from "../../stores/store";

function UserMainPage() {
  const location = useLocation();
  const userId = location.pathname.split("/")[1];
  const navigate = useNavigate();
  const { id } = useParams();

  const token = localStorage.getItem("token");

  const { userInfo, resetUserInfo } = useStore();

  const [blogData, setBlogData] = useState(null);

  const getBlogData = useCallback(async () => {
    const response = await axios.get(`http://localhost:8080/blog/${userId}`);

    setBlogData(response.data);
  }, [userId]);

  const props = {
    blogData,
    getBlogData,
  };

  useEffect(() => {
    getBlogData();
  }, [userId]);

  const handleBlogTitleClick = useCallback(() => {
    navigate(`/${userId}`);
  }, []);

  const handleLogoutClick = useCallback(() => {
    if (localStorage.getItem("token") !== null) {
      localStorage.removeItem("token");
      resetUserInfo();
      alert("로그아웃 되었습니다.");
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
                blogData={blogData}
              />
            </UserInfoContainer>
            <UserBlogContainer>
              <UserBlogHeaderContainer>
                <MenuBox>
                  <UserBlogHeaderLink to="/">메인페이지</UserBlogHeaderLink>
                  {userInfo && id == userInfo.id ? (
                    <>
                      <UserBlogHeaderTextBetweenLine src="/images/Line 2.svg" />
                      <UserBlogHeaderLink to={`/${userId}/neighbour`}>
                        이웃목록
                      </UserBlogHeaderLink>
                    </>
                  ) : (
                    <></>
                  )}
                </MenuBox>
                <LogoutButton onClick={handleLogoutClick}>
                  {token === null ? "로그인" : "로그아웃"}
                </LogoutButton>
              </UserBlogHeaderContainer>
              <UserBlogBox>
                <Outlet context={props} />
              </UserBlogBox>
            </UserBlogContainer>
          </Container>
        </ContainerBox>
      </Wrapper>
    </>
  );
}

export default UserMainPage;
