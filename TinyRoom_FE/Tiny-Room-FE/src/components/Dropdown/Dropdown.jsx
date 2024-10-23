import { useCallback, useState } from "react";
import {
  Container,
  IconWrapper,
  Input,
  ItemBox,
  MenuItem,
} from "./Dropdown.style";

const Dropdown = () => {
  const [isOpen, setOpen] = useState(false);

  const handleInputClick = useCallback(() => {
    setOpen(!isOpen);
  }, [isOpen]);

  return (
    <Container>
      <Input onClick={handleInputClick}>
        카테고리를 선택해 주세요.
        <IconWrapper>
          <img src="/images/arrow_down.svg" alt="ArrowDown" />
        </IconWrapper>
      </Input>
      {isOpen && (
        <ItemBox>
          <MenuItem>주방 가전제품</MenuItem>
          <MenuItem>홈 인테리어</MenuItem>
          <MenuItem>실내가구</MenuItem>
          <MenuItem>전자제품</MenuItem>
        </ItemBox>
      )}
    </Container>
  );
};

export default Dropdown;
