import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";

export default function EditUser() {
	let navigate = useNavigate();

	const { id } = useParams();

	const [employee, setEmployee] = useState({
		employeeName: "",
		employeeEmail: "",
		employeeAddress: "",
		employeeDOB: "",
		designation: "",
	});

	useEffect(() => {
		loadEmployee();
	}, []);

	const loadEmployee = async () => {
		const emp = await axios.get(`http://localhost:8080/employee/getById/${id}`);
		console.log(emp.data);
		setEmployee(emp.data);
	};

	const {
		employeeName,
		employeeEmail,
		employeeAddress,
		employeeDOB,
		designation,
	} = employee;

	const onInputChange = (e) => {
		setEmployee({ ...employee, [e.target.name]: e.target.value });
	};

	const onSubmit = async (e) => {
		e.preventDefault();
		await axios.put(
			`http://localhost:8080/employee/updateUser/${id}`,
			employee
		);
		navigate("/");
	};

	return (
		<div className="container">
			<div className="row justify-content-center">
				<div className="col col-lg-6 col-md-6 border rounded mt-2 shadow">
					<h2 className="text-center m-4">Register Employee</h2>
					<form onSubmit={(e) => onSubmit(e)}>
						<div className="mb-3 row">
							<div className="col col-lg-6">
								<label htmlFor="employeeName" className="form-label">
									Employee Name
								</label>
							</div>
							<div className="col">
								<input
									id="employeeName"
									type="text"
									name="employeeName"
									className="form-control col"
									placeholder="Enter the employee's name"
									value={employeeName}
									onChange={(e) => onInputChange(e)}
								></input>
							</div>
						</div>

						<div className="mb-3 row">
							<div className="col">
								<label htmlFor="employeeEmail" className="form-label">
									Employee Email
								</label>
							</div>
							<div className="col">
								<input
									id="employeeEmail"
									type="email"
									name="employeeEmail"
									className="form-control"
									placeholder="Enter the employee's email id"
									value={employeeEmail}
									onChange={(e) => onInputChange(e)}
								></input>
							</div>
						</div>

						<div className="mb-3 row">
							<div className="col">
								<label htmlFor="employeeDOB" className="form-label">
									Employee Date-of-Birth
								</label>
							</div>
							<div className="col">
								<input
									id="employeeDOB"
									type="date"
									name="employeeDOB"
									className="form-control"
									placeholder="Enter the employee's date of birth"
									value={employeeDOB}
									onChange={(e) => onInputChange(e)}
								></input>
							</div>
						</div>

						<div className="mb-3 row">
							<div className="col">
								<label htmlFor="employeeLocation" className="form-label">
									Employee Address
								</label>
							</div>
							<div className="col">
								<input
									id="employeeLocation"
									type="text"
									name="employeeAddress"
									className="form-control"
									placeholder="Enter the employee's Address"
									value={employeeAddress}
									onChange={(e) => onInputChange(e)}
								></input>
							</div>
						</div>

						<div className="mb-3 row">
							<div className="col">
								<label htmlFor="employeeDesignation" className="form-label">
									Employee Designation
								</label>
							</div>
							<div className="col">
								<input
									id="employeeDesignation"
									type="text"
									name="designation"
									className="form-control"
									placeholder="Enter the employee's Designation"
									value={designation}
									onChange={(e) => onInputChange(e)}
								></input>
							</div>
						</div>

						<button className="btn btn-outline-primary mt-3 mb-3" type="submit">
							Update
						</button>
						<Link className="btn btn-outline-danger mt-3 mx-3 mb-3" to={"/"}>
							Cancel
						</Link>
					</form>
				</div>
			</div>
		</div>
	);
}
