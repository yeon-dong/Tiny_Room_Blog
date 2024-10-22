import { Container, Content, Label } from "./OptionItem.style";

const OptionItem = ({ label, children }) => {
  return (
    <Container>
      <Label>{label}</Label>
      <Content>{children}</Content>
    </Container>
  );
};

export default OptionItem;
