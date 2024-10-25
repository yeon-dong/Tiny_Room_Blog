import { Container } from "./MainButton.style";

const MainButton = ({ strong, onClick, children, disabled }) => {
  return (
    <Container strong={strong ? 1 : 0} disabled={disabled} onClick={onClick}>
      {children}
    </Container>
  );
};

export default MainButton;
