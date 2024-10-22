import React from "react";
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
import { Outlet } from "react-router-dom";

function UserMainPage() {
  return (
    <>
      <Wrapper>
        <ContainerBox>
          <Container>
            <UserInfoContainer>
              <BlogNameBox>
                <BlogNameText>User's Blog</BlogNameText>
                <UserBlogNameLine src="/images/very_cute_kitty.gif" />
              </BlogNameBox>
              <UserInfoBox />
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
                <Outlet />
              </UserBlogBox>
            </UserBlogContainer>
          </Container>
        </ContainerBox>
      </Wrapper>
    </>
  );
}

export default UserMainPage;
