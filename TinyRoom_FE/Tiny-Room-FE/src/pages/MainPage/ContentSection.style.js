import { styled } from "styled-components";

// HOT 게시글 타이틀 스타일
export const HotTitle = styled.h2`
  color: #ef4444; /* 빨간색 설정 */
  font-size: 18px;
  font-weight: 600;
  margin-left: 370px;
  margin-top: 20px;
  //margin-bottom: 20px;
`;

// 전체 콘텐츠 컨테이너
export const ContentContainer = styled.div`
  display: flex;
  justify-content: center;
  gap: 24px;
  padding: 20px;
  // margin-top: 20px;
`;

// 각 카드 컨테이너
export const Card = styled.div`
  cursor: pointer;
  width: 240px;
  border-radius: 10px;
  overflow: hidden;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  transition: transform 0.3s ease;

  &:hover {
    transform: translateY(-5px);
  }
`;

// 카드 안의 이미지
export const CardImage = styled.img`
  width: 100%;
  height: 172px;
  object-fit: cover;
`;

// 카드 본문 컨테이너
export const CardBody = styled.div`
  padding: 10px 30px 10px 30px;
  background-color: #fff;
`;

// 본문 제목
export const CardTitle = styled.h3`
  font-size: 15px;
  height: 36px;
  margin-bottom: 8px;
  color: #4f4c4c;
  line-height: 1.2;
`;

// 본문 작성자 정보
export const CardAuthor = styled.p`
  font-size: 13px;
  color: #a1a1a1;
`;
