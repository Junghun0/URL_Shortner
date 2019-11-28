import "./Shortner.css";

import React, { useState, useEffect } from "react";
import Button from "@material-ui/core/Button";
import TransformIcon from "@material-ui/icons/Transform";
import {
  makeStyles,
  ThemeProvider,
  createMuiTheme
} from "@material-ui/core/styles";
import TextField from "@material-ui/core/TextField";
import { indigo } from "@material-ui/core/colors";
import Axios from "../../service/Axios";

const useStyles = makeStyles(theme => ({
  button: {
    marginLeft: "30px",
    height: "56px",
    width: "15%",
    backgroundColor: "#283593",
    "&:hover": {
      background: "#3f51b5"
    }
  },
  textfield: {
    height: "56px",
    width: "45%"
  }
}));

const theme = createMuiTheme({
  palette: {
    primary: indigo
  }
});

function Shortner() {
  const classes = useStyles();

  const [sendUrl, setSendUrl] = useState("default");
  const [responseUrl, setResponseUrl] = useState("default");

  useEffect(() => {
    console.log(sendUrl);
  }, [sendUrl]);

  //버튼 클릭 이벤트
  function sendRequest() {

    Axios.get(`/url/${sendUrl}`)
    .then(response => {
      setResponseUrl(response);
      console.log(response.data);
    })
    .catch(err => {console.log(err)});

  }

  //텍스트필드 입력받기
  function onTextFieldChange(e) {
    setSendUrl(e.target.value);
  };

  return (
    <div className="shortner-flex-container">
      <ThemeProvider theme={theme}>
        <TextField
          className={classes.textfield}
          label="Shorten your link"
          variant="outlined"
          id="mui-theme-provider-outlined-input"
          onChange={e => onTextFieldChange(e)}
        />
      </ThemeProvider>
      <Button
        variant="contained"
        color="primary"
        className={classes.button}
        endIcon={<TransformIcon />}
        onClick={sendRequest}
      >
        Shorten
      </Button>
    </div>
  );
}

export default Shortner;
