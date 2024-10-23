import React, { useEffect } from "react";
import useStore from "../../stores/store.js"; // Zustand 스토어 import

function MainPage() {
  const { userId, signUpEmail } = useStore();
  useEffect(() => {
    console.log("현재 userId:", userId); // userId를 콘솔에 출력
    console.log("현재 signUpEmail:", signUpEmail); // userId를 콘솔에 출력
  }, []); // userId가 변경될 때마다 실행
  return <div>MainPage</div>;
}

export default MainPage;
