import { Container, Input } from "./RadioInput.style";

const RadioInput = ({ children }) => {
  return (
    <Container>
      <Input type="radio" />
      {children}
    </Container>
  );
};

export default RadioInput;
