import "./Result.css";

import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import Paper from "@material-ui/core/Paper";
import Typography from "@material-ui/core/Typography";

const useStyles = makeStyles(theme => ({
  root: {
    padding: theme.spacing(3, 2)
  },
  typographySuccess: {
    color: '#283593'
  },
  typographyFail: {
    color: '#d32f2f'
  }
}));

function Result({url, isValid}) {
  const classes = useStyles();
  const cssClassName = isValid ? classes.typographySuccess : classes.typographyFail;

  console.log('result components',url,'valid-> ',isValid)

  return (
    <div className="result-flex-container">
      <Paper className={classes.root}>
        <Typography variant="h5" component="h2" className = {cssClassName}>
          {!isValid ? <div>Unable to shorten that link. It is not a valid url.</div> : url}
        </Typography>
      </Paper>
    </div>
  );
}

export default Result;
