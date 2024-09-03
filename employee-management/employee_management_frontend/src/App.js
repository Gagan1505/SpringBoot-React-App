import "./App.css";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Navbar from "./layouts/Navbar";
import Homepage from "./pages/Homepage";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import AddUser from "./users/AddUser";
import AddDepartment from "./department/AddDepartment";
import EditUser from "./users/EditUser";
import ViewUser from "./users/ViewUser";

function App() {
	return (
		<div className="App">
			<Router>
				<Navbar />
				<Routes>
					<Route exact path="/" element={<Homepage />} />
					<Route exact path="/addUser" element={<AddUser />} />
					<Route exact path="/addDepartment" element={<AddDepartment />} />
					<Route exact path="/viewEmployee/:id" element={<ViewUser />} />
					<Route exact path="/editEmployee/:id" element={<EditUser />} />
				</Routes>
			</Router>
		</div>
	);
}

export default App;
