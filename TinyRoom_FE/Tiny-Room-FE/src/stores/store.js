import { create } from "zustand";

const useStore = create((set) => ({
  userId: null, // 초기값 설정
  setUserId: (id) => set({ userId: id }), // userId를 설정하는 함수
}));

export default useStore;
