import { styled } from "styled-components";

export const Container = styled.div`
  display: flex;
  flex-direction: column;
  width: 100%;
  //max-width: 600px;
  margin: 0 auto;
  height: 100vh; /* 뷰포트의 100% 높이 */
  // overflow: hidden; /* 스크롤이 생기지 않도록 설정 */
  box-sizing: border-box;
`;

export const MainHeader = styled.div`
  height: 56px;
  width: 100%;
  background-color: #ffceda;
  display: flex;
`;

export const LogoContainer = styled.div`
  // 이미지로 쓰는게 좋음
  display: flex;
  height: 36px;
  width: 153px;
  background-image: url("/images/Mini_TinyRoom.svg");
  background-size: contain; /* 이미지 비율을 유지하면서 크기에 맞게 조정 */
  background-repeat: no-repeat; /* 이미지가 반복되지 않도록 설정 */
  margin-top: 13px;
  margin-left: 230px;
  margin-right: 25px;
`;

export const SearchContainer = styled.div`
  display: flex;
  width: 230px;
  height: 33px;
  padding: 10px;
  margin-top: 10px;
  background-color: #ffffff;
  border-radius: 50px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  align-items: center; /* 검색 아이콘과 입력창이 수직 가운데 정렬되도록 설정 */
`;

export const SearchButton = styled.button`
  background: none;
  border: none;
  padding: 0;
  margin-left: 10px;
  cursor: pointer;
  display: flex;
  align-items: center;

  &:focus {
    outline: none;
  }

  &:hover {
    opacity: 0.8; /* hover 시 아이콘의 불투명도 조정 */
  }

  svg {
    width: 20px;
    height: 20px;
  }
`;

export const SearchIcon = styled.img`
  width: 20px;
  height: 20px;
`;

export const SearchInput = styled.input`
  width: 100%;
  padding: 10px;
  border: none;
  border-radius: 50px;
  outline: none;
  font-size: 1em;
  background-color: #fff;

  &:focus {
    box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
  }
`;

// 메뉴리스트 헤더 컨테이너
export const HeaderContainer = styled.div`
  display: flex;
  align-items: center;
  justify-content: center; /* 가로 가운데 정렬 */
  padding: ${(props) => (props.$isLogin ? "20px 0 11px 0" : "20px 0 15px 0")};
  /* margin-left: 236px;
  margin-right: 236px; */
  // background-color: #a3d7d9;
`;

// 메뉴 리스트 컨테이너
export const MenuList = styled.div`
  display: flex;
  align-items: center;
  gap: 64px; /* 각 메뉴 항목 사이의 간격 */
`;

export const MenuItem = styled.span`
  font-size: 18px;
  font-weight: 600;
  cursor: pointer;
  color: ${(props) => (props.$isClicked ? "#ff6781" : "black")};
  &:hover {
    color: #ff6781; /* 호버 시 색상 변경 */
  }
`;

export const LoginButton = styled.button`
  background-color: #ff8caa;
  width: 72px;
  height: 26px;
  color: white;
  border: none;
  border-radius: 5px;
  font-size: 14px;
  font-weight: 600;
  cursor: pointer;
  margin-left: 256px;
  border: 1px solid #ff4a79;

  &:hover {
    background-color: #ff6781; /* 호버 시 배경색 변경 */
  }
`;

// 회색 선 Divider
export const Divider = styled.div`
  width: 1020px;
  height: 1px;
  background-color: #e9e9e9; /* 선의 색상 지정 */
  margin: 0 auto; /* 가운데 정렬 */
`;

// 로그인 후 마이페이지 버튼
export const UserImg = styled.img`
  margin-left: 298px;
  width: 30px;
  height: 30px;
  border-radius: 100%;
  cursor: pointer;
`;
