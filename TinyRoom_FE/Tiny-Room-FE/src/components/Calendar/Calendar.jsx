import { useCallback, useEffect, useMemo, useState } from "react";
import {
  Body,
  BodyWrapper,
  Container,
  DateText,
  DateWrapper,
  Day,
  Header,
  MoveButton,
  Week,
} from "./Calendar.style";
import dayjs from "dayjs";
import axios from "axios";

const months = [
  "JANUARY",
  "FEBRUARY",
  "MARCH",
  "APRIL",
  "MAY",
  "JUNE",
  "JULY",
  "AUGUST",
  "SEPTEMBER",
  "OCTOBER",
  "NOVEMBER",
  "DECEMBER",
];

const Calendar = ({ userId }) => {
  const [currentDate, setCurrentDate] = useState(
    dayjs(dayjs().year() + "-" + (dayjs().month() + 1))
  );
  const [postsByDay, setPostsByDay] = useState(
    Array.from({ length: dayjs().daysInMonth() }, () => [])
  );

  const calendarData = useMemo(() => {
    const result = [];

    const firstDayOfWeek = currentDate.day();
    const lastDayInMonth = currentDate.daysInMonth();

    const firstWeek = Array.from({ length: 7 }, () => null);
    let dayToInput = 1;
    for (let i = firstDayOfWeek; i < 7; i++) {
      firstWeek[i] = dayToInput++;
    }
    result.push(firstWeek);

    for (let i = dayToInput; i <= lastDayInMonth; ) {
      const week = Array.from({ length: 7 }, () => null);
      for (let j = 0; j < 7; j++) {
        week[j] = i++;
        if (i > lastDayInMonth) break;
      }
      result.push(week);
    }

    if (result.length === 6) {
      for (let i = 0; i < 6; i++) {
        if (result[5][i] === null) break;
        result[0][i] = result[5][i];
      }

      result.pop();
    }

    return result;
  }, [currentDate]);

  const getPostsByDate = useCallback(async (date) => {
    const response = await axios.get(
      `http://localhost:8080/posts/calendar?year=${date.year()}&month=${
        date.month() + 1
      }&user_id=${userId}`
    );

    const posts = response.data;

    const lastDay = date.daysInMonth();
    const newPostsByDay = Array.from({ length: lastDay }, () => []);

    posts.forEach((post) => {
      newPostsByDay[post.day - 1].push(post);
    });

    setPostsByDay(newPostsByDay);
  }, []);

  useEffect(() => {
    getPostsByDate(currentDate);
  }, [currentDate]);

  const handlePrevClick = useCallback(() => {
    setCurrentDate(currentDate.add(-1, "month"));
  }, [currentDate]);

  const handleNextClick = useCallback(() => {
    setCurrentDate(currentDate.add(1, "month"));
  }, [currentDate]);

  return (
    <Container>
      <Header>
        <MoveButton onClick={handlePrevClick}>
          <img src="/images/triangle_left.svg" alt="MoveLeftButton" />
        </MoveButton>
        <DateWrapper>
          <DateText>{months[currentDate.month()]}</DateText>
          <DateText>{currentDate.year()}</DateText>
        </DateWrapper>
        <MoveButton onClick={handleNextClick}>
          <img src="/images/triangle_right.svg" alt="MoveRightButton" />
        </MoveButton>
      </Header>
      <BodyWrapper>
        <Body>
          {calendarData.map((week, i) => (
            <Week key={i}>
              {week.map((day, i) => (
                <Day
                  key={i}
                  has_post={
                    day !== null && postsByDay[day - 1]?.length > 0 ? 1 : 0
                  }
                  is_blank={day === null ? 1 : 0}
                >
                  {day}
                </Day>
              ))}
            </Week>
          ))}
        </Body>
      </BodyWrapper>
    </Container>
  );
};

export default Calendar;
