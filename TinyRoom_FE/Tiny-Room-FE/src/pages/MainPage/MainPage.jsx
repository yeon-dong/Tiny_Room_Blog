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
  UserImg,
} from "./MainPage.style";
import ContentSection from "./ContentSection";
import RecentContentSection from "./RecentContentSection";
import { useNavigate } from "react-router-dom";
import useStore from "../../stores/store";

function MainPage() {
  const navigate = useNavigate();
  const { userInfo } = useStore();
  const [recommendPost, setRecommendPost] = useState({});
  const isLogin = localStorage.getItem("token") ? true : false;
  const [category, setCategory] = useState(0); // 초기 페이지 설정

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
    alert("😭 검색은 다음 버전에서 만나요! 😭"); // 여기에 실제 검색 동작을 추가할 수 있습니다.
  };
  const handleLoginPage = () => {
    navigate("/login");
  };
  const handleGoToMyRoom = (myId) => {
    navigate(`/${myId}`);
  };

  const handleCategory = (categorySelect) => {
    setCategory(categorySelect);
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
      <HeaderContainer $isLogin={isLogin}>
        <MenuList>
          <MenuItem
            onClick={() => handleCategory(0)}
            $isClicked={category == 0}
          >
            전체보기
          </MenuItem>
          <MenuItem
            onClick={() => handleCategory(1)}
            $isClicked={category == 1}
          >
            주방가전제품
          </MenuItem>
          <MenuItem
            onClick={() => handleCategory(2)}
            $isClicked={category == 2}
          >
            홈인테리어
          </MenuItem>
          <MenuItem
            onClick={() => handleCategory(3)}
            $isClicked={category == 3}
          >
            실내가구
          </MenuItem>
          <MenuItem
            onClick={() => handleCategory(4)}
            $isClicked={category == 4}
          >
            전자제품
          </MenuItem>
          {localStorage.getItem("token") ? (
            <UserImg
              src={`http://localhost:8080${userInfo.profileImg}`}
              onClick={() => handleGoToMyRoom(userInfo.id)}
            />
          ) : (
            <LoginButton onClick={handleLoginPage}>로그인</LoginButton>
          )}
        </MenuList>
      </HeaderContainer>
      <Divider />
      <ContentSection recommendPost={recommendPost} />
      <RecentContentSection category={category} />
    </Container>
  );
}

export default MainPage;
