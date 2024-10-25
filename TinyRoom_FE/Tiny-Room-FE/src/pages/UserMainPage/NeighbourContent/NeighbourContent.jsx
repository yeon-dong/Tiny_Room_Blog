import { useCallback, useEffect, useState } from "react";
import MyPagination from "../../../components/Pagination/MyPagination";
import {
  ButtonWrapper,
  Container,
  NeighbourList,
  PaginationWrapper,
} from "./NeighbourContent.style";
import NeighbourItem from "./NeighbourItem";
import axios from "axios";
import MainButton from "../../../components/MainButton/MainButton";

const NeighbourContent = () => {
  const [neighbours, setNeighbours] = useState({
    totalCount: 0,
    data: [],
  });
  const [page, setPage] = useState(1);

  const getNeighbours = useCallback(async (p) => {
    const response = await axios.get(
      `http://localhost:8080/neighbour/neighbourList?page=${p - 1}`,
      { headers: { auth_token: localStorage.getItem("token") } }
    );

    setNeighbours(response.data);
  }, []);

  console.log(neighbours);

  useEffect(() => {
    getNeighbours(page);
  }, [page]);

  const handlePageChange = useCallback((e, newPage) => {
    setPage(newPage);
  }, []);

  return (
    <Container>
      <NeighbourList>
        {neighbours.data.map((neighbour, i) => (
          <NeighbourItem key={i} neighbour={neighbour} idx={i} />
        ))}
      </NeighbourList>
      <PaginationWrapper>
        <MyPagination
          page={page}
          count={Math.ceil(neighbours.totalCount / 3)}
          onChange={handlePageChange}
        />
        <ButtonWrapper>
          <MainButton>받은 신청</MainButton>
        </ButtonWrapper>
      </PaginationWrapper>
    </Container>
  );
};

export default NeighbourContent;
