import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import MainPage from "./pages/MainPage/MainPage.jsx";
import UserMainPage from "./pages/UserMainPage/UserMainPage.jsx";

function App() {
  return (
    <>
      <Router>
        <Routes>
          <Route path="/" element={<MainPage />} />
          <Route path="/:id" element={<UserMainPage />} />
        </Routes>
      </Router>
    </>
  );
}

export default App;
