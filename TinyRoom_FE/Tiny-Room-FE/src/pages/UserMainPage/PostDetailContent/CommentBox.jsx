import { useCallback, useEffect, useState } from "react";
import { Container } from "./CommentBox.style";
import CommentItem from "./CommentItem";

const CommentBox = () => {
  const [comments, setComments] = useState({
    totalCount: 0,
    data: [],
  });

  const getComments = useCallback(async () => {
    setComments({
      totalCount: 7,
      data: [
        {
          comment_id: 2,
          content: "asdf",
          post_id: 2,
          user_id: 2,
          username: "park",
          parent_id: -1,
          date: "2014.10.21 17:07",
          children: [
            {
              comment_id: 2,
              content:
                "asdfasdfasdfasdfaksjdfhakjshdfkjahsdkjf@@@@@@@@@@@@@@@@@@@@@@@@@@@@@asdfasdfasdfasdfaksjdfhakjshdfkjahsdkjf@@@@@@@@@@@@@@@@@@@@@@@@@@@@@",
              post_id: 2,
              user_id: 2,
              username: "park",
              parent_id: 2,
              date: "2014.10.21 17:07",
            },
          ],
        },
        {
          comment_id: 3,
          content: "asdf",
          post_id: 2,
          user_id: 2,
          username: "kim",
          parent_id: -1,
          date: "2014.10.21 17:07",
          children: [],
        },
      ],
    });
  }, []);

  useEffect(() => {
    getComments();
  }, []);

  return (
    <Container>
      {comments.data.map((comment) => (
        <CommentItem key={comment.comment_id} comment={comment} />
      ))}
    </Container>
  );
};

export default CommentBox;
