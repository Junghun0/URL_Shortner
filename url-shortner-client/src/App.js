import React, { Component } from 'react';
import './App.css';
import Shortner from './components/shortner/Shortner';
import Header from './components/header/Header';
import Result from './components/result/Result';

class App extends Component {
  render() {
    return (
      <div className="App">
        <div className="App-header">
          <Header/>
        </div>
        <div className="App-Body">
      
          <Shortner/>
          <Result/>
        
        </div>
      
      </div>
    );
  }
}

export default App;
