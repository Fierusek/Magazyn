import {useEffect, useState} from "react";
import * as React from "react";
import {makeStyles} from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';


const useStyles = makeStyles({
    table: {
        minWidth: 650,
        maxWidth: 1000,
        background: "#ccccff",

    },
    bg: {
        alignItems: 'center',
        justifyContent: 'center',
    }
});

export default function Products(props) {
    const [data, setData] = useState([]);
    useEffect(() => {
        if (data.length < 10) loadData()

    });

    function loadData() {

        fetch('http://localhost:8080/products')
            .then(response => response.json())
            .then(data => {
                console.log("data");
                console.log(data);
                setData(data);
            })
            .catch((err) => {
                console.error(props.url, err.toString());
                console.log("no printerino")
            })
    }

    const classes = useStyles();

    let generateUrl = (link) => {
        let id = link.slice(-18);
        let redirectUrl = 'https://mcopue-dev-ed.lightning.force.com/lightning/r/Opportunity/' + id + '/view'
        return <a href={redirectUrl}>Go to salesforce {id}</a>
    }


    return (
        <div className={classes.bg}>
            <TableContainer component={Paper}>
                <Table className={classes.bg} aria-label="simple table">
                    <TableHead>
                        <TableRow>
                            <TableCell align="right">Name</TableCell>
                            <TableCell align="right">Typ Produktu</TableCell>
                            <TableCell align="right">Liczba Sztuk</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {data.map((row) => (
                            <TableRow key={row.id} onClick={() => console.log("clicked")}>
                                <TableCell align="right">{row.name}</TableCell>
                                <TableCell align="right">{row.productType}</TableCell>
                                <TableCell align="right">{row.packegeSize}</TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>
        </div>
    )
}



