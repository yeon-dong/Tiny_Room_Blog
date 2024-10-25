import { styled } from "styled-components";

export const ModalContainer = styled.div`
  cursor: normal;
  position: fixed;
  z-index: 2;
  top: ${(props) => props.$y - 192 + "px"};
  left: ${(props) => props.$x - 30 + "px"};
  // 이미지로 쓰는게 좋음
  display: flex;
  flex-direction: column;
  align-items: center;
  height: 198px;
  width: 296px;
  background-image: url("/images/calendar_modal.svg");
  background-size: contain; /* 이미지 비율을 유지하면서 크기에 맞게 조정 */
  background-repeat: no-repeat; /* 이미지가 반복되지 않도록 설정 */
`;

export const DayText = styled.div`
  margin-top: 11px;
  font-size: 13px;
  font-weight: bold;
  margin-bottom: 11px;
`;

// 회색 선 Divider
export const Divider = styled.div`
  width: 236px;
  height: 1px;
  background-color: #e9e9e9; /* 선의 색상 지정 */
  margin-bottom: 11px;
`;

export const PostContainer = styled.div`
  max-height: 120px;
  width: 255px;
  overflow-y: auto;
`;

export const PostInnerContainer = styled.div`
  cursor: pointer;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
`;

export const TitleText = styled.div`
  font-size: 15px;
  font-weight: bold;
  margin-bottom: 6px;
`;

export const ContentText = styled.div`
  font-size: 13px;
  font-weight: normal;
  margin-bottom: 16px;
`;
