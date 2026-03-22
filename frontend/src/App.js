import {useEffect,useState} from "react";

export default function App(){
    const[employees,setEmployees]=useState([]);
    const [page, setPage] = useState("home");

    const fetchEmployees = async () => {
        const res = await fetch("http://localhost:8080/employees");
        const data = await res.json();
        setEmployees(data);
        setPage("employeesList");
    };
    const deleteEmployees= async()=>{

    };
    return (
        <div>
            <h1>Employees Management</h1>
            {page==="home" &&(
            <>
                    <button onClick={fetchEmployees}>すべての職員の一覧</button>
                    {/*<button onClick={deleteEmployees}>職員の記録を消す</button>
                    <button onClick={addEmployee}>新規登録</button>
                    <button onClick={searchEmployee}>職員検索</button>*/}
            </>
            )}
            {page==="employeesList" &&(
                <>
                <ul> {employees.map(emp => (
                    <li key = {emp.id}>
                        <p>{emp.id}</p>
                        <p>{emp.firstName}</p>
                    </li> ))}
                </ul>
                </>
            )}
        </div>
        );
    }
