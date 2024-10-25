import React from "react";
import {
  BackgroundContainer,
  BtnContainer,
  CancelBtn,
  Divider,
  ModalContainer,
  NeighborBlogApplicationMessage,
  NeighborBlogBottomText,
  NeighborBlogNameText,
  NeighborImg,
  NeighborMainText,
  NeighborNameApplicationText,
  NeighborNameText,
  NeighborNickname,
  SuccessBtn,
} from "./NeighborModal.style";

function NeighborModal({ handleModalClose, nickname, blogData }) {
  return (
    <BackgroundContainer>
      <ModalContainer>
        <NeighborMainText>이웃신청</NeighborMainText>
        <Divider />
        <NeighborImg src={`http://localhost:8080${blogData.user.profileImg}`} />
        <NeighborNameText>
          <NeighborNickname>{nickname}</NeighborNickname> 님
        </NeighborNameText>
        <NeighborBlogNameText>{blogData.blog.title}</NeighborBlogNameText>
        <NeighborNameApplicationText>
          <NeighborNickname>{nickname}</NeighborNickname> 님께 이웃을
          신청합니다.
        </NeighborNameApplicationText>
        <NeighborBlogApplicationMessage placeholder="이웃 신청 메세지를 입력해 주세요." />
        <NeighborBlogBottomText>
          상대방이 동의하시면 이웃이 맺어집니다.
          <br />
          <div style={{ marginBottom: "6px" }} /> 신청이 완료되면 이웃 목록에서
          해당 블로그 프로필을 확인하실 수 있습니다.
        </NeighborBlogBottomText>
        <BtnContainer>
          <CancelBtn onClick={() => handleModalClose()}>취소</CancelBtn>
          <SuccessBtn>작성 완료</SuccessBtn>
        </BtnContainer>
      </ModalContainer>
    </BackgroundContainer>
  );
}

export default NeighborModal;
