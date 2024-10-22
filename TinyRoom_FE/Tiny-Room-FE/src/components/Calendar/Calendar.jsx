import {
  CalendarDate,
  CalendarHeader,
  CalendarTitle,
  Container,
} from "./Calendar.style";

const Calendar = () => {
  return (
    <Container>
      <CalendarHeader>
        <CalendarTitle>Today is ...</CalendarTitle>
        <CalendarDate>09/27</CalendarDate>
      </CalendarHeader>
    </Container>
  );
};

export default Calendar;
