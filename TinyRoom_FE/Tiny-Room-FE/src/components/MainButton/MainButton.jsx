import { Container } from "./MainButton.style";

const MainButton = ({ strong, onClick, children }) => {
  return (
    <Container strong={strong ? 1 : 0} onClick={onClick}>
      {children}
    </Container>
  );
};

export default MainButton;
