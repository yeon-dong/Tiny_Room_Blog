import { create } from "zustand";

const useStore = create((set) => ({
  userInfo: null, // 초기값 설정
  setUserInfo: (info) => set({ userInfo: info }), // userId를 설정하는 함수

  //회원 가입 시 페이지끼리 props 안주기 위해 만든 상태관리
  signUpEmail: null, // 초기값 설정
  setSignUpEmail: (email) => set({ signUpEmail: email }), // 이메일 입력
  signUpPassword: null, // 초기값 설정
  setSignUpPassword: (password) => set({ signUpPassword: password }), // 비밀번호 입력
  signUpPhone: null, // 초기값 설정
  setSignUpPhone: (phone) => set({ signUpPhone: phone }), // 휴대전화번호 입력
  signUpProfileImg: null, // 초기값 설정
  setSignUpProfileImg: (profileImg) => set({ signUpProfileImg: profileImg }), // 프로필 사진 URL
  signUpName: null, // 초기값 설정
  setSignUpName: (Name) => set({ signUpName: Name }), // 이름
  signUpNickName: null, // 초기값 설정
  setSignUpNickName: (NickName) => set({ signUpNickName: NickName }), // 닉네임
}));

export default useStore;
