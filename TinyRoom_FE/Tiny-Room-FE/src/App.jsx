import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import MainPage from "./pages/MainPage/MainPage.jsx";
import UserMainPage from "./pages/UserMainPage/UserMainPage.jsx";
import MainContent from "./pages/UserMainPage/MainContent.jsx";
import PostDetailContent from "./pages/UserMainPage/PostDetailContent.jsx";

function App() {
  return (
    <>
      <Router>
        <Routes>
          <Route path="/:id" element={<UserMainPage />}>
            <Route index element={<MainContent />} />
            <Route path="post/:postId" element={<PostDetailContent />} />
          </Route>
          <Route path="/" element={<MainPage />} />
        </Routes>
      </Router>
    </>
  );
}

export default App;
