import { useCallback, useEffect, useState } from "react";
import MainButton from "../../../components/MainButton/MainButton";
import {
  ButtonBox,
  ButtonsCol,
  Container,
  Header,
  MessageCol,
  NameCol,
  Row,
  Table,
  Wrapper,
} from "./NewNeighbourModal.style";
import axios from "axios";

const NewNeighbourModal = ({ closeModal }) => {
  const [newNeighbours, setNewNeighbours] = useState({
    totalCount: 0,
    data: [],
  });

  const getNewNeighbours = useCallback(async () => {
    const response = await axios.get(
      `http://localhost:8080/neighbour/sendList?page=0`,
      { headers: { auth_token: localStorage.getItem("token") } }
    );

    setNewNeighbours(response.data);
  }, []);

  useEffect(() => {
    getNewNeighbours();
  }, []);

  const handleAccept = useCallback(async (id) => {
    const response = await axios.get(
      `http://localhost:8080/neighbour/approve?neighbour_id=${id}`,
      { headers: { auth_token: localStorage.getItem("token") } }
    );

    getNewNeighbours();
  }, []);

  const handleReject = useCallback(async (id) => {
    const response = await axios.delete(
      `http://localhost:8080/neighbour/refuse?neighbour_id=${id}`,
      { headers: { auth_token: localStorage.getItem("token") } }
    );

    getNewNeighbours();
  }, []);

  return (
    <Wrapper onClick={() => closeModal()}>
      <Container onClick={(e) => e.stopPropagation()}>
        <Header>받은 신청</Header>
        <Table>
          <Row is_header={1}>
            <NameCol>신청한 사람</NameCol>
            <MessageCol>신청 메시지</MessageCol>
            <ButtonsCol>관리</ButtonsCol>
          </Row>
          {newNeighbours.data.map((newNeighbour) => (
            <Row key={newNeighbour.member_id}>
              <NameCol>{newNeighbour.nickname}</NameCol>
              <MessageCol>{newNeighbour.description}</MessageCol>
              <ButtonsCol>
                <ButtonBox>
                  <MainButton
                    onClick={() => handleAccept(newNeighbour.neighbour_id)}
                  >
                    수락
                  </MainButton>
                  <MainButton
                    onClick={() => handleReject(newNeighbour.neighbour_id)}
                  >
                    거절
                  </MainButton>
                </ButtonBox>
              </ButtonsCol>
            </Row>
          ))}
        </Table>
      </Container>
    </Wrapper>
  );
};

export default NewNeighbourModal;
