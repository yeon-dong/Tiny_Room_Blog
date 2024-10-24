import { styled } from "styled-components";

// 최신 게시글 타이틀
export const LatestTitle = styled.h2`
  color: #1d1d1d;
  font-size: 18px;
  font-weight: bold;
  margin-left: 370px;
  margin-top: 20px;
  margin-bottom: 5px;
`;

// 게시글 리스트 컨테이너
export const PostListContainer = styled.div`
  gap: 20px;
  margin-left: 370px;
  margin-right: 370px;
`;

// 게시글 컨테이너
export const PostItem = styled.div`
  display: flex;
  align-items: flex-start;
  border-bottom: 1px solid #e0e0e0;
  padding: 20px 0;
`;

// 표지 사진 (정사각형)
export const PostCoverImage = styled.img`
  width: 100px; /* 정사각형 */
  height: 100px;
  object-fit: cover;
  border-radius: 8px; /* 살짝 둥근 모서리 */
`;

// 게시글 내용
export const PostContent = styled.div`
  display: flex;
  flex-direction: column;
  margin-left: 30px;
`;

// 프로필 이미지
export const ProfileImage = styled.img`
  width: 32px;
  height: 32px;
  border-radius: 50%;
  margin-right: 10px;
`;

// 작성자 정보 (프로필 이미지와 작성자 이름 및 시간)
export const PostHeader = styled.div`
  display: flex;
  align-items: center;
  margin-bottom: 10px;
`;

// 작성자 이름 및 시간 컨테이너
export const AuthorInfo = styled.div`
  display: flex;
  flex-direction: column;
`;

// 작성자 이름
export const AuthorName = styled.span`
  font-size: 14px;
  color: #4f4c4c;
  margin-bottom: 3px;
`;

// 작성 시간
export const PostTime = styled.span`
  color: #a1a1a1;
  font-size: 10px;
`;

// 게시글 제목
export const PostTitle = styled.h3`
  font-size: 1.2em;
  font-weight: 600;
  margin-bottom: 10px;
`;

// 게시글 본문
export const PostText = styled.p`
  font-size: 14px;
  color: #a1a1a1;
  margin-bottom: 10px;
`;

// 좋아요, 댓글 정보
export const PostFooter = styled.div`
  display: flex;
  gap: 15px;
  font-size: 14px;
  color: #4f4c4c;
  margin-right: 370px;
`;

export const PostFooterItem = styled.span`
  display: flex;
  align-items: center;
`;

export const Icon = styled.span`
  margin-right: 5px;
`;
