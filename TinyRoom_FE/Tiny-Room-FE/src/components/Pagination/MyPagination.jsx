import Pagination from "@mui/material/Pagination";

const MyPagination = ({ count, page, onChange }) => {
  return (
    <Pagination
      count={count}
      page={page}
      onChange={onChange}
      color="primary"
      shape="rounded"
      size="small"
    />
  );
};

export default MyPagination;
