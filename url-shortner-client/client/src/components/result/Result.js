import "./Result.css";

import React, { useState } from "react";
import { makeStyles } from "@material-ui/core/styles";
import Paper from "@material-ui/core/Paper";
import Typography from "@material-ui/core/Typography";

const useStyles = makeStyles(theme => ({
  root: {
    padding: theme.spacing(3, 2)
  }
}));


export const a = "asd"

function Result() {
  const classes = useStyles();
  const [result, setResult] = useState('Test result state');

  return (
    <div className="result-flex-container">
      <Paper className={classes.root}>
        <Typography variant="h5" component="h3">
          {result}
        </Typography>
      </Paper>
    </div>
  );
}

export default Result;
