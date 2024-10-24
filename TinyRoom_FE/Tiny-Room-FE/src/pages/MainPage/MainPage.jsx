import React, { useEffect, useState } from "react";
import axios from "axios";
import {
  Container,
  LogoContainer,
  MainHeader,
  SearchButton,
  SearchContainer,
  SearchInput,
  SearchIcon,
  HeaderContainer,
  MenuList,
  MenuItem,
  LoginButton,
  Divider,
} from "./MainPage.style";
import ContentSection from "./ContentSection";
import RecentContentSection from "./RecentContentSection";
import { useNavigate } from "react-router-dom";

function MainPage() {
  const navigate = useNavigate();
  const [recommendPost, setRecommendPost] = useState({});

  // 추천 게시물 가져오기
  useEffect(() => {
    const fetchRecommendPost = async () => {
      try {
        const response = await axios.get(
          "http://localhost:8080/posts/recommend"
        );
        setRecommendPost(response.data); // 응답 데이터를 recommendPost에 저장
      } catch (error) {
        console.error("추천 게시물 가져오기 실패:", error);
      }
    };

    fetchRecommendPost();
  }, []); // 빈 배열을 의존성으로 주어 컴포넌트가 마운트될 때만 실행

  const handleSearchClick = () => {
    alert("검색 버튼이 눌렸습니다!"); // 여기에 실제 검색 동작을 추가할 수 있습니다.
  };
  const handleLoginPage = () => {
    navigate("/login");
  };
  return (
    <Container>
      <MainHeader>
        <LogoContainer></LogoContainer>
        <SearchContainer>
          <SearchButton onClick={handleSearchClick}>
            <SearchIcon src="/images/SearchIcon.svg" alt="Search Icon" />
          </SearchButton>
          {/* <SearchInput type="text" placeholder="검색어를 입력하세요..." /> */}
        </SearchContainer>
      </MainHeader>
      <HeaderContainer>
        <MenuList>
          <MenuItem>전체보기</MenuItem>
          <MenuItem>주방가전제품</MenuItem>
          <MenuItem>홈인테리어</MenuItem>
          <MenuItem>실내가구</MenuItem>
          <MenuItem>전자제품</MenuItem>
          <LoginButton onClick={handleLoginPage}>로그인</LoginButton>
        </MenuList>
      </HeaderContainer>
      <Divider />
      <ContentSection recommendPost={recommendPost} />
      <RecentContentSection />
    </Container>
  );
}

export default MainPage;
