import React, {Component, useState} from 'react';

import Button from "@material-ui/core/Button";
import Login from "./Login";
import Default from "./Default";
import {makeStyles} from "@material-ui/core/styles";

const useStyles = makeStyles((theme) => ({
    root: {
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
        '& > *': {
            margin: theme.spacing(1),
        },
    },
    button: {
        background: 'linear-gradient(45deg, #c2d1f0 30%, #ebf0fa 90%)',
        border: 0,
        borderRadius: 3,
        boxShadow: '0 3px 5px 2px rgba(255, 105, 135, .3)',
        color: 'white',
        height: 48,
        padding: '0 30px',
    },
    bg: {
        background: "#ccccff"
    }
}));

export default function Welcome() {
    let [component, setComponent] = useState("default");
    let login = () => {
        setComponent("login")
    }
    const classes = useStyles()

    if (component === "login") component = <Login/>
    else component = <Default/>

    return (
        <div className={classes.bg}>
            <div className="customerdetails">
                <Button variant="outlined" onClick={login} className={classes.button}>App</Button>
            </div>
            {component}
        </div>
    );
}