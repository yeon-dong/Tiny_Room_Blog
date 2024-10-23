import { useCallback, useEffect, useRef } from "react";
import ReactQuill from "react-quill";
import "react-quill/dist/quill.snow.css";

const MyEditor = () => {
  const editorRef = useRef(null);

  const handleUploadImage = useCallback(() => {
    const input = document.createElement("input");
    input.setAttribute("type", "file");
    input.setAttribute("accept", "image/*");
    input.click();
    input.onchange = async () => {
      const editor = editorRef.current.getEditor();
      const file = input.files[0];

      // 현재 커서 위치 저장
      const range = editor.getSelection(true);

      console.log(file.name);

      // 서버에 올려질때까지 표시할 로딩 placeholder 삽입
      // editor.insertEmbed(range.index, "image", `/images/loading.gif`);

      try {
        // 이런식으로 서버에 업로드 한뒤 이미지 태그에 삽입할 url을 반환받도록 구현하면 된다
        const url = await uploadImage(file, filePath);

        // 정상적으로 업로드 됐다면 로딩 placeholder 삭제
        // getEditor().deleteText(range.index, 1);
        // 받아온 url을 이미지 태그에 삽입
        editor.insertEmbed(range.index, "image", url);

        // 사용자 편의를 위해 커서 이미지 오른쪽으로 이동
        editor.setSelection(range.index + 1);
      } catch (e) {
        // getEditor().deleteText(range.index, 1);
      }
    };
  }, []);

  useEffect(() => {
    if (editorRef.current) {
      const toolbar = editorRef.current.getEditor().getModule("toolbar");
      toolbar.addHandler("image", handleUploadImage);
    }
  }, []);

  return (
    <ReactQuill
      ref={editorRef}
      theme="snow"
      style={{ height: "100%" }}
      formats={[
        "header",
        "font",
        "size",
        "bold",
        "italic",
        "underline",
        "strike",
        "align",
        "blockquote",
        "list",
        "bullet",
        "indent",
        "background",
        "color",
        "link",
        "image",
        "video",
        "width",
      ]}
      modules={{
        toolbar: {
          container: [
            ["link", "image", "video"],
            [{ header: [1, 2, 3, false] }],
            ["bold", "italic", "underline", "strike"],
            ["blockquote"],
            [{ list: "ordered" }, { list: "bullet" }],
            [{ color: [] }, { background: [] }],
            [{ align: [] }],
          ],
        },
      }}
    />
  );
};

export default MyEditor;
