import React, { useEffect } from "react";
import useStore from "../../stores/store.js"; // Zustand 스토어 import

function MainPage() {
  const { userInfo } = useStore();
  useEffect(() => {
    // console.log("현재 userInfo:", userInfo); // userInfo를 콘솔에 출력
    // console.log("현재 token:", localStorage.getItem("token")); // userInfo를 콘솔에 출력
  }, []); // userInfo가 변경될 때마다 실행
  return <div>MainPage</div>;
}

export default MainPage;
