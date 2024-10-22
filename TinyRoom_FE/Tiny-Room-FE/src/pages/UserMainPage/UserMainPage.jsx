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
  UserTinyRoom,
  ContainerBox,
  MenuBox,
  LogoutButton,
  BoardBox,
  BoardHeader,
  BoardContent,
  BoardFooter,
} from "./UserMainPage.style";
import UserInfoBox from "./UserInfoBox";

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
                <UserTinyRoom src="/images/Group 38.png" />
                <BoardBox>
                  <BoardHeader>최신 게시글</BoardHeader>
                  <BoardContent></BoardContent>
                  <BoardFooter></BoardFooter>
                </BoardBox>
              </UserBlogBox>
            </UserBlogContainer>
          </Container>
        </ContainerBox>
      </Wrapper>
    </>
  );
}

export default UserMainPage;
