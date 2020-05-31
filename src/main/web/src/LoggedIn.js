import {useState} from 'react'
import ButtonGroup from "@material-ui/core/ButtonGroup"
import Button from "@material-ui/core/Button"
import EuroIcon from "@material-ui/icons/Euro"
import CameraIcon from "@material-ui/icons/Camera"
import {makeStyles} from "@material-ui/core/styles"
import * as React from 'react'
import Products from "./Products";
import Orders from "./Orders";

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
        background: 'linear-gradient(45deg, #ccccff 30%, #b3b3ff 90%)',
        border: 0,
        borderRadius: 3,
        boxShadow: '0 3px 5px 2px rgba(255, 105, 135, .3)',
        color: 'white',
        height: 48,
        padding: '0 30px',
    },
}));

export default function LoggedIn(props) {
    let [endpoint, setEndpoint] = useState("forex")


    const classes = useStyles()

    let orders = () => {
        console.log("Orders in custom router");
        setEndpoint("orders")
    }

    let prods = () => {
        setEndpoint("prods");
    }


    let currentComponent = <div>Wybierz magazyn lub zamówienia</div>
    if (endpoint === "orders") {
        currentComponent = <Orders/>
    } else if (endpoint === "prods")
        currentComponent = <Products/>

    return (
        <div>
            <div className={classes.root}>
                <ButtonGroup size="large" color="primary" aria-label="large outlined primary button group">
                    <Button
                        className={classes.button}
                        startIcon={<EuroIcon/>}
                        size="small"
                        onClick={orders}>Zamówienia</Button>
                    <Button
                        className={classes.button}
                        startIcon={<CameraIcon/>}
                        size="small"
                        onClick={prods}>Magazyn</Button>
                </ButtonGroup>

            </div>
            <center>{currentComponent}</center>
        </div>
    )
}

