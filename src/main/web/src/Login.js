import React, {useState} from 'react';
import makeStyles from "@material-ui/core/styles/makeStyles";
import TextField from "@material-ui/core/TextField";
import LoggedIn from "./LoggedIn";

const useStyles = makeStyles((theme) => ({
    root: {
        '& > *': {
            margin: theme.spacing(1),
            width: '25ch',
        },
    },
}));

export default function LoginForm() {
    const [username, setUsername] = useState("a");
    const [password, setPassword] = useState("b");
    const [token, setToken] = useState("");

    let requestAuthentication = (username, password) => {
        const requestParameters = {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify({username, password})
        };
        return fetch("http://localhost:8080/login", requestParameters)
            .then(response => response.json())
            .then(data => {
                console.log("Data: " + data[0])
                setToken(data)
            })
    };

    let handleSubmit = (event) => {
        console.log("onClick: " + username + " " + password)
        requestAuthentication(username, password)
            .then(console.log("after login"))
        event.preventDefault()
    };
    const classes = useStyles();
    let component = <div>Zaloguj sie aby zobaczyc aplikacje.</div>
    if (token) component = <LoggedIn/>
    let loginComponent =             <div><form className={classes.root} noValidate autoComplete="off" onSubmit={handleSubmit}>
        <TextField id="username" label="Username" color="secondary" onChange={e => {
            setUsername(e.target.value)
            console.log(username)
        }}/>
        <TextField type="password" id="pass" label="Hasło" color="secondary" onChange={e => {
            setPassword(e.target.value)
            console.log(password)
        }}/> <br/>
        <button type="submit" onClick={handleSubmit}>
            Login
        </button>
    </form>
    <div></div>
    </div>

    if(token) loginComponent = null

    return (
        <div>
            {loginComponent}
            {component}
        </div>
    );
}
