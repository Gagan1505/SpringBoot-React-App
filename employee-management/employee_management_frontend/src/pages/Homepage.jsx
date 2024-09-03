import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";

export default function Homepage() {
	const { id } = useParams();
	const [employees, setEmployees] = useState([]);

	useEffect(() => {
		loadEmployees();
	}, []);

	const loadEmployees = async () => {
		const result = await axios.get("http://localhost:8080/employee/getAll");
		console.log(result.data);

		setEmployees(result.data);
	};

	const deleteEmployee = async (id) => {
		await axios.delete(`http://localhost:8080/employee/deleteUser/${id}`);
		loadEmployees();
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
							<th scope="col">Actions</th>
						</tr>
					</thead>
					<tbody>
						{employees.map((employee, index) => (
							<tr key={index}>
								<td scope="row">{employee.employeeName}</td>
								<td>{employee.employeeEmail}</td>
								<td>{employee.employeeAddress}</td>
								<td>{employee.designation}</td>
								<td>
									<Link
										className="btn btn-outline-success mx-2"
										to={`/viewEmployee/${employee.employeeId}`}
									>
										View
									</Link>
									<Link
										className="btn btn-outline-primary mx-2"
										to={`/editEmployee/${employee.employeeId}`}
									>
										Edit
									</Link>
									<button
										className="btn btn-outline-danger mx-2"
										onClick={() => deleteEmployee(employee.employeeId)}
									>
										Delete
									</button>
								</td>
							</tr>
						))}
					</tbody>
				</table>
			</div>
		</div>
	);
}
