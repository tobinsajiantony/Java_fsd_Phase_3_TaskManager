<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<title>Spring Application</title>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
</head>
<body>
<h2>All Tasks</h2>
<a href="/" style="float: right;">Logout</a>
	<table>
		<thead>
			<tr>
				<td>Name</td>
				<td>Start Date</td>
				<td>End Date</td>
				<td>Severity</td>
				<td>Description</td>
				<td>Email</td>
				<td>Options</td>
				<td>Options</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${tasks}" var="task">
				<tr>
					<td>${task.name}</td>
					<td>${task.startDate}</td>
					<td>${task.endDate}</td>
					<td>${task.severity}</td>
					<td>${task.description}</td>
					<td>${task.email}</td>
					<td>
						<form action="updateTask" method="get">
							<input type="hidden" name="taskId" value="${task.id}" /> <input
								type="hidden" id="id" value="${ userId }" name="userId"><br>
							<input type="submit" value="Update" name="update">
						</form>
					</td>
					<td>
						<form action="deleteTask" method="get">
							<input type="hidden" name="taskId" value="${task.id}" /> <input
								type="hidden" id="id" value="${ userId }" name="userId"><br>
							<input type="submit" value="Delete" name="delete">
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<form action="task" method="get">
		<input type="hidden" id="id" value="${ userId }" name="userId"><br>
		<input type="submit" value="Add New Task" name="addTask">
	</form>
</body>
</html>

