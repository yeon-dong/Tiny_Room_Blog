import { useEffect, useMemo, useState } from "react";

const useLocalStorage = () => {
  const [at, setAt] = useState(null);
  const isLogin = useMemo(() => {
    return Boolean(at);
  }, [at]);

  useEffect(() => {
    const newAt = localStorage.getItem("at");
    if (Boolean(newAt)) setAt(newAt);
  }, []);

  return {
    at,
    isLogin,
  };
};

export default useLocalStorage;
