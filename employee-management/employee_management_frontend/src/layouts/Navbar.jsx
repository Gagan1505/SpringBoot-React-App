import React from "react";
import { Link } from "react-router-dom";

export default function Navbar() {
	return (
		<div>
			<nav
				className="navbar bg-primary border-bottom border-body"
				data-bs-theme="dark"
			>
				<div className="container-fluid">
					<a className="navbar-brand" href="/">
						Employee Management System
					</a>
					<div className="">
						<Link
							className="btn btn-success btn-outline-light mx-2"
							to="/addUser"
						>
							Add User
						</Link>
						<Link
							className="btn btn-success btn-outline-light"
							to="/addDepartment"
						>
							Add Department
						</Link>
					</div>
				</div>
			</nav>
		</div>
	);
}
