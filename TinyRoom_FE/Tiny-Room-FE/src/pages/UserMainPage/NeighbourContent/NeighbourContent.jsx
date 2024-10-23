import MyPagination from "../../../components/Pagination/MyPagination";
import {
  Container,
  NeighbourList,
  PaginationWrapper,
} from "./NeighbourContent.style";
import NeighbourItem from "./NeighbourItem";

const NeighbourContent = () => {
  return (
    <Container>
      <NeighbourList>
        <NeighbourItem />
        <NeighbourItem />
        <NeighbourItem />
        <NeighbourItem />
        <NeighbourItem />
      </NeighbourList>
      <PaginationWrapper>
        <MyPagination />
      </PaginationWrapper>
    </Container>
  );
};

export default NeighbourContent;
