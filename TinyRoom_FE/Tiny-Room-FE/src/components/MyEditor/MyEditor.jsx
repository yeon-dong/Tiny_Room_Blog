import ReactQuill from "react-quill";
import "react-quill/dist/quill.snow.css";

const MyEditor = ({ myRef, value, onChange, defaultValue }) => {
  return (
    <ReactQuill
      ref={myRef}
      theme="snow"
      style={{ height: "100%" }}
      value={value}
      onChange={onChange}
      defaultValue={"<p>abcd</p>"}
    />
  );
};

export default MyEditor;
