import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import MainPage from "./pages/MainPage/MainPage.jsx";
import UserMainPage from "./pages/UserMainPage/UserMainPage.jsx";
import MainContent from "./pages/UserMainPage/MainContent/MainContent.jsx";
import LoginPage from "./pages/LoginPage/LoginPage.jsx";
import SignUpPage from "./pages/SignUpPage/SignUpPage.jsx";
import SignUpPage2 from "./pages/SignUpPage2/SignUpPage2.jsx";
import NewPostContent from "./pages/UserMainPage/NewPostContent/NewPostContent.jsx";
import SignUpPage3 from "./pages/SignUpPage3/SignUpPage3.jsx";
import NeighbourContent from "./pages/UserMainPage/NeighbourContent/NeighbourContent.jsx";
import { createTheme, ThemeProvider } from "@mui/material";
import MyPageContent from "./pages/UserMainPage/MyPageContent/MyPageContent.jsx";
import PostDetailContent from "./pages/UserMainPage/PostDetailContent/PostDetailContent.jsx";

const theme = createTheme({
  palette: {
    primary: {
      main: "#ffceda",
    },
  },
});

function App() {
  return (
    <>
      <ThemeProvider theme={theme}>
        <Router>
          <Routes>
            <Route path="/:id" element={<UserMainPage />}>
              <Route index element={<MainContent />} />
              <Route path="post/:postId" element={<PostDetailContent />} />
              <Route path="post/new" element={<NewPostContent />} />
              <Route path="neighbour" element={<NeighbourContent />} />
              <Route path="mypage" element={<MyPageContent />} />
            </Route>
            <Route path="/login" element={<LoginPage />} />
            <Route path="/signup" element={<SignUpPage />} />
            <Route path="/signup2" element={<SignUpPage2 />} />
            <Route path="/signup3" element={<SignUpPage3 />} />
            <Route path="/" element={<MainPage />} />
          </Routes>
        </Router>
      </ThemeProvider>
    </>
  );
}

export default App;
