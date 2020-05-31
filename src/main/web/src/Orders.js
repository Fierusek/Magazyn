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
import IconButton from "@material-ui/core/IconButton";
import KeyboardArrowDownIcon from '@material-ui/icons/KeyboardArrowDown';
import KeyboardArrowUpIcon from '@material-ui/icons/KeyboardArrowUp';
import Typography from "@material-ui/core/Typography";
import Box from "@material-ui/core/Box";
import Collapse from "@material-ui/core/Collapse";


const useStyles = makeStyles({
    table: {
        minWidth: 650,
        maxWidth: 1000,
    },
    bg: {
        alignItems: 'center',
        justifyContent: 'center',
    }
});

const useRowStyles = makeStyles({
    root: {
        '& > *': {
            borderBottom: 'unset',
        },
    },
});


function Row(props) {
    const { row } = props;
    const [open, setOpen] = React.useState(false);
    const classes = useRowStyles();

    console.log("Row row: " + row.toString())
    return (
        <React.Fragment>
            <TableRow className={classes.root}>
                <TableCell>
                    <IconButton aria-label="expand row" size="small" onClick={() => setOpen(!open)}>
                        {open ? <KeyboardArrowUpIcon /> : <KeyboardArrowDownIcon />}
                    </IconButton>
                </TableCell>
                <TableCell component="th" scope="row">
                    {row.id}
                </TableCell>
                <TableCell align="right">{row.client.name}</TableCell>
                <TableCell align="right">20</TableCell>
            </TableRow>
            <TableRow>
                <TableCell style={{ paddingBottom: 0, paddingTop: 0 }} colSpan={6}>
                    <Collapse in={open} timeout="auto" unmountOnExit>
                        <Box margin={1}>
                            <Typography variant="h6" gutterBottom component="div">
                                History
                            </Typography>
                            <Table size="small" aria-label="purchases">
                                <TableHead>
                                    <TableRow>
                                        <TableCell>Date</TableCell>
                                        <TableCell>Składniki</TableCell>
                                        <TableCell align="right">Typ</TableCell>
                                    </TableRow>
                                </TableHead>
                                <TableBody>
                                    {row.products.map((historyRow) => (
                                        <TableRow key={historyRow.date}>
                                            <TableCell component="th" scope="row">
                                                {row.dateRealised[0]}/{row.dateRealised[1]}/{row.dateRealised[2]}
                                            </TableCell>
                                            <TableCell>{historyRow.name}</TableCell>
                                            <TableCell align="right">{historyRow.productType}</TableCell>
                                            <TableCell align="right">
                                            </TableCell>
                                        </TableRow>
                                    ))}

                                    test
                                </TableBody>
                            </Table>
                        </Box>
                    </Collapse>
                </TableCell>
            </TableRow>
        </React.Fragment>
    );
}

export default function Orders(props) {
    const [data, setData] = useState([]);
    useEffect(() => {
        if (data.length < 2) loadData()
    });

    function loadData() {
        fetch('http://localhost:8080/orders')
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



    return (<div className={classes.bg}>
        <TableContainer component={Paper} className={classes.bg}>
            <Table aria-label="collapsible table">
                <TableHead>
                    <TableRow>
                        <TableCell>Info</TableCell>
                        <TableCell>ID Zamowienia</TableCell>
                        <TableCell align="right">Klient</TableCell>
                        <TableCell align="right">Wartosc</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {data.map((row) => (
                        <Row key={row.id} row={row} />
                    ))}
                </TableBody>
            </Table>
        </TableContainer>
        </div>
    );
}



