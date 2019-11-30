import React, { Component, useState, useEffect } from "react";
import "./App.css";
import Shortner from "./components/shortner/Shortner";
import Header from "./components/header/Header";
import Result from "./components/result/Result";

function App() {
  const [result, setResult] = useState("");
  const [isValid, setValid] = useState(true);

  const changeResult = url => {
    setResult(url);
  };

  useEffect(() => {
    console.log('result-->',result);
  }, [result]);

  return (
    <div className="App">
      <div className="App-header">
        <Header />
      </div>
      <div className="App-Body">
        <Shortner changeResult={changeResult} />
        {result == null ? <Result url={result} isValid={false}/> : <Result url={result} isValid={true}/>}
      </div>
    </div>
  );
}

export default App;
