import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import MainPage from "./pages/MainPage/MainPage.jsx";
import UserMainPage from "./pages/UserMainPage/UserMainPage.jsx";
import LoginPage from "./pages/LoginPage/LoginPage.jsx";
import SignUpPage from "./pages/SignUpPage/SignUpPage.jsx";
import SignUpPage2 from "./pages/SignUpPage2/SignUpPage2.jsx";
import SignUpPage3 from "./pages/SignUpPage3/SignUpPage3.jsx";

function App() {
  return (
    <>
      <Router>
        <Routes>
          <Route path="/" element={<MainPage />} />
          <Route path="/login" element={<LoginPage />} />
          <Route path="/signup" element={<SignUpPage />} />
          <Route path="/signup2" element={<SignUpPage2 />} />
          <Route path="/signup3" element={<SignUpPage3 />} />
          <Route path="/:id" element={<UserMainPage />} />
        </Routes>
      </Router>
    </>
  );
}

export default App;
