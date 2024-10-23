import { Container } from "./MainButton.style";

const MainButton = ({ strong, children }) => {
  return <Container strong={strong}>{children}</Container>;
};

export default MainButton;
