import { styled } from "styled-components";

export const BackgroundContainer = styled.div`
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: rgba(0, 0, 0, 0.7); /* 배경을 검은색으로 설정 */
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 1;
`;

export const ModalContainer = styled.div`
  width: 570px; /* 모달 너비 */
  height: 683px; /* 모달 높이 */
  background-color: white; /* 모달 배경색 */
  border-radius: 15px; /* 모서리 둥글게 */
  z-index: 2;
  display: flex;
  flex-direction: column;
  align-items: center;
  padding-top: 26px;
`;

export const NeighborMainText = styled.div`
  font-size: 18px;
  font-weight: bold;
  margin-bottom: 12px;
`;

export const Divider = styled.div`
  width: 534px;
  height: 1px;
  background-color: #e9e9e9; /* 선의 색상 지정 */
  margin-bottom: 60px;
`;

export const NeighborImg = styled.img`
  width: 100px;
  height: 100px;
  border-radius: 100%;
  margin-bottom: 35px;
`;

export const NeighborNameText = styled.div`
  font-size: 15px;
  font-weight: normal;
  margin-bottom: 8px;
`;

export const NeighborBlogNameText = styled.div`
  font-size: 18px;
  font-weight: bold;
  margin-bottom: 40px;
`;

export const NeighborNameApplicationText = styled.div`
  font-size: 15px;
  font-weight: normal;
  margin-bottom: 6px;
`;

export const NeighborBlogApplicationMessage = styled.textarea`
  width: 380px;
  height: 120px;
  font-size: 14px;
  font-weight: normal;
  color: var(--primary-color2);
  padding: 14px 11px;
  border-radius: 5px;
  border: 1px solid #e9e9e9;
  margin-bottom: 13px;
`;

export const NeighborBlogBottomText = styled.div`
  font-size: 15px;
  font-weight: normal;
  text-align: center;
  margin-bottom: 53px;
`;

export const BtnContainer = styled.div`
  display: flex;
`;

export const SuccessBtn = styled.button`
  background-color: #ff8caa;
  width: 72px;
  height: 26px;
  color: white;
  border-radius: 5px;
  font-size: 14px;
  font-weight: 600;
  cursor: pointer;
  border: 1px solid #ff4a79;

  &:hover {
    background-color: #ff6781; /* 호버 시 배경색 변경 */
  }
`;

export const CancelBtn = styled.button`
  background-color: #dedede;
  width: 48px;
  height: 26px;
  border: none;
  border-radius: 5px;
  font-size: 14px;
  font-weight: 600;
  cursor: pointer;
  border: 1px solid #c5c5c5;
  margin-right: 20px;

  &:hover {
    background-color: #c5c5c5; /* 호버 시 배경색 변경 */
  }
`;

export const NeighborNickname = styled.span`
  color: #3b82f6;
`;
