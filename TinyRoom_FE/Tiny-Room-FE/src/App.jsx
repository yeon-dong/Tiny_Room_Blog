import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import MainPage from "./pages/MainPage/MainPage.jsx";
import UserMainPage from "./pages/UserMainPage/UserMainPage.jsx";
import MainContent from "./pages/UserMainPage/MainContent.jsx";
import PostDetailContent from "./pages/UserMainPage/PostDetailContent.jsx";
import LoginPage from "./pages/LoginPage/LoginPage.jsx";
import SignUpPage from "./pages/SignUpPage/SignUpPage.jsx";
import SignUpPage2 from "./pages/SignUpPage2/SignUpPage2.jsx";

function App() {
  return (
    <>
      <Router>
        <Routes>
          <Route path="/:id" element={<UserMainPage />}>
            <Route index element={<MainContent />} />
            <Route path="post/:postId" element={<PostDetailContent />} />
          </Route>
          <Route path="/login" element={<LoginPage />} />
          <Route path="/signup" element={<SignUpPage />} />
          <Route path="/signup2" element={<SignUpPage2 />} />
          <Route path="/" element={<MainPage />} />
        </Routes>
      </Router>
    </>
  );
}

export default App;
