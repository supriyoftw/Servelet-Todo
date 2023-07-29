<%@page import="dto.Task"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>


	<h1>==============Welcome To Todo Home=================</h1>

	<form>
		<table border="2px solid black">
			<tr>
				<th>ID</th>
				<th>Task Name</th>
				<th>Description</th>
				<th>Task Date</th>
				<th>Task Completion Date</th>
				<th>Status</th>
				<th>Change Status</th>
				<th>Delete</th>
				<th>Update</th>

			</tr>
			<%
			List<Task> list = (List<Task>) request.getAttribute("list");
			for (Task task : list) {
			%>
			<tr>

				<td><%=task.getId()%></td>
				<td><%=task.getName()%></td>
				<td><%=task.getDescription()%></td>
				<td><%=task.getTaskdate()%></td>
				<td><%=task.getCompletionDate()%></td>
				<td><%=task.isStatus()%></td>
				<td><button>Change</button></td>
				<td>>
					<button>Delete</button>
				</td>
				<td><button>Update</button></td>

			</tr>
			<%
			}
			%>
		</table>
		<br>
		 <br>
		 <a href="addtask.html"><button type="button"
				                style="margin-left: 20px">Add Task</button></a> 
				                <a href="login.html"><button
				type="button" style="margin-left: 500px">Logout</button></a>
	</form>
</body>
</html>