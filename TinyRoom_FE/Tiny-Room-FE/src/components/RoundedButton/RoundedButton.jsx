import { Container, IconWrapper } from "./RoundedButton.style";

const RoundedButton = ({ icon, disabled, onClick, children }) => {
  return (
    <Container disabled={disabled} onClick={onClick}>
      <IconWrapper>
        <img src={`/images/${icon}`} alt={icon} />
      </IconWrapper>
      {children}
    </Container>
  );
};

export default RoundedButton;
