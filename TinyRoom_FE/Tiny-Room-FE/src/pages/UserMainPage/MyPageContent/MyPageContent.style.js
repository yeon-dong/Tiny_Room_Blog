import styled from "styled-components";

export const Container = styled.div`
  width: 100%;
  height: 100%;
  overflow-y: auto;
`;

export const Header = styled.div`
  width: 100%;
  border-radius: 10px 10px 0 0;
  background-color: var(--primary-color);
  height: 50px;
  display: flex;
  align-items: center;
  font-size: 18px;
  font-weight: bold;
  padding: 0 20px;
`;

export const BackButton = styled.button`
  width: 20px;
  height: 20px;
  margin-right: 10px;

  img {
    width: 100%;
    height: 100%;
  }
`;

export const Content = styled.div`
  border-radius: 0 0 10px 10px;
  border: 1px solid var(--gray2);
  border-top: none;
  padding: 20px 30px;
`;

export const ProfileImageOptionContainer = styled.div`
  width: 280px;
`;

export const ProfileImageWrapper = styled.div`
  width: 100%;
  height: 230px;
  border-radius: 10px;
  overflow: hidden;
  margin-bottom: 20px;

  img {
    width: 100%;
    height: 100%;
    object-fit: cover;
  }
`;

export const ButtonBox = styled.div`
  margin: 0 auto;
  display: flex;
  justify-content: space-around;
`;

export const SimpleButton = styled.button`
  height: 20px;
  padding: 0 20px;
  font-size: 15px;
  line-height: 20px;
  border-radius: 10px;
  border: 1px solid var(--gray2);
`;

export const Input = styled.input`
  width: 375px;
  height: 40px;
  line-height: 40px;
  font-size: 16px;
  border: 1px solid var(--gray1);
  border-radius: 10px;
  outline: none;
  padding: 0 10px;
`;

export const Textarea = styled.textarea`
  width: 375px;
  height: 128px;
  resize: none;
  font-size: 16px;
  border: 1px solid var(--gray1);
  border-radius: 10px;
  outline: none;
  padding: 10px;
`;

export const ThemeOptionContainer = styled.div`
  display: flex;
  gap: 20px;
  height: 40px;
  align-items: center;
`;

export const RadioText = styled.div`
  font-size: 15px;
  height: 19px;
  line-height: 19px;
`;

export const RoomThemeOptionContainer = styled.div`
  display: flex;
  flex-wrap: wrap;
  gap: 20px;
`;

export const RoomThemeImgWrapper = styled.div``;
