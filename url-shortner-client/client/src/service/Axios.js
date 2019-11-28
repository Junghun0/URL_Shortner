import axios from "axios";

const connection = axios.create({
    baseURL: 'http://localhost:8080',
    timeout: 3000,
    headers: {'Content-Type': 'application/json', 'Accept': 'application/json'}
})

export default connection;