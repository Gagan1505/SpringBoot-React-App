import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";

export default function ViewUser() {
	const { id } = useParams();
	const [employee, setEmployee] = useState([]);

	useEffect(() => {
		loadEmployee();
	}, []);

	const loadEmployee = async () => {
		const result = await axios.get(
			`http://localhost:8080/employee/getById/${id}`
		);
		console.log(result.data);

		setEmployee(result.data);
	};
	return (
		<div className="container">
			<div className="py-4">
				<table className="table border shadow">
					<thead>
						<tr>
							<th scope="col">Name</th>
							<th scope="col">Email</th>
							<th scope="col">Address</th>
							<th scope="col">Designation</th>
						</tr>
					</thead>
					<tbody>
						{
							<tr>
								<td scope="row">{employee.employeeName}</td>
								<td>{employee.employeeEmail}</td>
								<td>{employee.employeeAddress}</td>
								<td>{employee.designation}</td>
							</tr>
						}
					</tbody>
				</table>
			</div>
		</div>
	);
}
