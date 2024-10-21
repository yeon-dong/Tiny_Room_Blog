import React from "react";
import {
  Container,
  MainContainer,
  UserBlogBox,
  UserBlogContainer,
  UserBlogHeaderContainer,
  UserBlogHeaderText,
  UserBlogHeaderTextBetweenLine,
  UserBlogNameLine,
  UserBlogNameText,
  UserInfoBox,
  UserInfoContainer,
  UserNameContainer,
  UserTinyRoom,
} from "./UserMainPage.style";

function UserMainPage() {
  return (
    <>
      <Container>
        <MainContainer>
          <UserInfoContainer>
            <UserNameContainer>
              <UserBlogNameText>User's Blog</UserBlogNameText>
              <UserBlogNameLine src="/images/very_cute_kitty.gif" />
            </UserNameContainer>
            <UserInfoBox></UserInfoBox>
          </UserInfoContainer>
          <UserBlogContainer>
            <UserBlogHeaderContainer>
              <UserBlogHeaderText>메인페이지</UserBlogHeaderText>
              <UserBlogHeaderTextBetweenLine src="/images/Line 2.svg" />
              <UserBlogHeaderText>이웃목록</UserBlogHeaderText>
            </UserBlogHeaderContainer>
            <UserBlogBox>
              <UserTinyRoom src="/images/Group 38.png" />
            </UserBlogBox>
          </UserBlogContainer>
        </MainContainer>
      </Container>
    </>
  );
}

export default UserMainPage;
