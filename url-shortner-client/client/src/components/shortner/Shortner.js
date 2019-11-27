import './Shortner.css';

import React, { useState } from "react";
import Button from "@material-ui/core/Button";
import TransformIcon from "@material-ui/icons/Transform";
import { makeStyles, ThemeProvider, createMuiTheme } from "@material-ui/core/styles";
import TextField from "@material-ui/core/TextField";
import { indigo } from '@material-ui/core/colors';

const useStyles = makeStyles(theme => ({
  button: {
    marginLeft: '30px',
    height: '56px',
    width: '15%',
    backgroundColor: '#283593',
    '&:hover': {
        background: '#3f51b5',
     }
  },
  textfield: {
    height: '56px',
    width: '45%',
  },
}));

const theme = createMuiTheme({
  palette: {
    primary: indigo
  }
});

function Shortner() {
  const classes = useStyles();

  function sendUrl() {
    console.log('button click event')
  }
  return (
    <div className="shortner-flex-container">
      <ThemeProvider theme={theme}>
        <TextField
          className={classes.textfield}
          label="Shorten your link"
          variant="outlined"
          id="mui-theme-provider-outlined-input"
        />
      </ThemeProvider>
      <Button
        variant="contained"
        color="primary"
        className={classes.button}
        endIcon={<TransformIcon />}
        onClick={sendUrl}
      >
        Shorten
      </Button>
    </div>
  );
}

export default Shortner;
