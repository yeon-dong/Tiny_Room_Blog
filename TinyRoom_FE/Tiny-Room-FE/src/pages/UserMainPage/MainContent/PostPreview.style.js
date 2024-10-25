import styled from "styled-components";

export const Container = styled.div`
  display: flex;
  flex: 0 0 380px;
  height: 106px;
  gap: 14px;
  cursor: pointer;
  border-radius: 10px;
  padding: 10px;

  &:hover {
    background-color: #eeeeee;
  }
`;

export const ThumbnailWrapper = styled.div`
  flex: 0 0 86px;
  height: 86px;
  overflow: hidden;
  border-radius: 10px;
`;

export const Thumbnail = styled.img`
  width: 100%;
  height: 100%;
  object-fit: cover;
`;

export const Info = styled.div`
  flex-grow: 1;
  width: 260px;
  height: 100%;
`;

export const Title = styled.div`
  width: 100%;
  font-size: 18px;
  font-weight: bold;
  text-overflow: ellipsis;
  overflow: hidden;
  padding: 10px 0;
`;

export const Content = styled.p`
  width: 100%;
  font-size: 13px;
  line-height: 1.2;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
  text-overflow: ellipsis;
  overflow: hidden;
  display: -webkit-box;
  word-break: break-all;
`;
