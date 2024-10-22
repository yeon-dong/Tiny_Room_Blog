import { Container, IconWrapper } from "./RoundedButton.style";

const RoundedButton = ({ icon, disabled, children }) => {
  return (
    <Container disabled={disabled}>
      <IconWrapper>
        <img src={`/images/${icon}`} alt={icon} />
      </IconWrapper>
      {children}
    </Container>
  );
};

export default RoundedButton;
