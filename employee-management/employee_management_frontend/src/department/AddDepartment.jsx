import React, { useState } from "react";
import axios from "axios";
import { Link, useNavigate } from "react-router-dom";

export default function AddDepartment() {
	let navigate = useNavigate();

	const [department, setDepartment] = useState({
		departmentName: "",
	});

	const { departmentName } = department;

	const onInputChange = (e) => {
		setDepartment({ ...department, [e.target.name]: e.target.value });
	};

	const onSubmit = async (e) => {
		e.preventDefault();
		await axios.post(
			"http://localhost:8080/department/addDepartment",
			department
		);
		navigate("/");
	};
	return (
		<div className="container">
			<div className="row">
				<div className="col col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
					<h2 className="text-center m-3">Add-Department</h2>
					<form onSubmit={(e) => onSubmit(e)}>
						<div className="my-5 row">
							<div className="col">
								<label htmlFor="deptName" className="form-label">
									Department Name
								</label>
							</div>
							<div className="col">
								<input
									id="deptName"
									type="text"
									className="form-control"
									placeholder="Enter the name of the department"
									name="departmentName"
									value={departmentName}
									onChange={(e) => onInputChange(e)}
								></input>
							</div>
						</div>
						<button className="btn btn-outline-primary mt-3" type="submit">
							Submit
						</button>
						<Link className="btn btn-outline-danger mt-3 mx-3" to="/">
							Cancel
						</Link>
					</form>
				</div>
			</div>
		</div>
	);
}
