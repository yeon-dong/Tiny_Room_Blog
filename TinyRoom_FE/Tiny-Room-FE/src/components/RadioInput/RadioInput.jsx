import { Container, Input } from "./RadioInput.style";

const RadioInput = ({ checked, onChange, children }) => {
  return (
    <Container>
      <Input type="radio" checked={checked} onChange={onChange} />
      {children}
    </Container>
  );
};

export default RadioInput;
