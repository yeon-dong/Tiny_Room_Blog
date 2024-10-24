import { useCallback, useState } from "react";
import {
  Container,
  IconWrapper,
  Input,
  ItemBox,
  MenuItem,
} from "./Dropdown.style";

const Dropdown = ({ value, values, onChange }) => {
  const [isOpen, setOpen] = useState(false);

  const handleInputClick = useCallback(() => {
    setOpen(!isOpen);
  }, [isOpen]);

  const handleItemClick = useCallback((i) => {
    onChange(i);
  }, []);

  return (
    <Container>
      <Input onClick={handleInputClick}>
        {value === -1 ? "카테고리를 선택해 주세요." : values[value]}
        <IconWrapper>
          <img src="/images/arrow_down.svg" alt="ArrowDown" />
        </IconWrapper>
      </Input>
      {isOpen && (
        <ItemBox>
          {values.map((value, i) => (
            <MenuItem key={i} onClick={() => handleItemClick(i)}>
              {value}
            </MenuItem>
          ))}
        </ItemBox>
      )}
    </Container>
  );
};

export default Dropdown;
