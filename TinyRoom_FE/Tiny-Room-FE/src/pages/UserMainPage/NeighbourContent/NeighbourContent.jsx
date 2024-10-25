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
import NewNeighbourModal from "./NewNeighbourModal";

const NeighbourContent = () => {
  const [neighbours, setNeighbours] = useState({
    totalCount: 0,
    data: [],
  });
  const [page, setPage] = useState(1);
  const [isModalOpen, setModalOpen] = useState(false);

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

  const openModal = useCallback(() => {
    setModalOpen(true);
  }, []);

  const closeModal = useCallback(() => {
    setModalOpen(false);
    getNeighbours(page);
  }, [page]);

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
          <MainButton onClick={() => openModal()}>받은 신청</MainButton>
        </ButtonWrapper>
      </PaginationWrapper>
      {isModalOpen && <NewNeighbourModal closeModal={closeModal} />}
    </Container>
  );
};

export default NeighbourContent;
