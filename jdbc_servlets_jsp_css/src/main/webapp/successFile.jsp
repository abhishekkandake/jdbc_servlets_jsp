<%@page import="jsp_servlet_jsp.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%List<Employee> employees = (List)request.getAttribute("list"); %>
	<table>
		<tr>
			<td>id</td>
			<td>name</td>
			<td>phone</td>
			<td>address</td>
			<td>email</td>
			<td>password</td>
		</tr>
		<%for(Employee employee:employees){ %>
			<tr>
				<td><%=employee.getId() %></td>
				<td><%=employee.getName() %></td>
				<td><%=employee.getPhone() %></td>
				<td><%=employee.getAddress() %></td>
				<td><%=employee.getEmail() %></td>
				<td><%=employee.getPassword() %></td>
				<td><a href="delete?id=<%=employee.getId()%>"><button>delete</button></a></td>	
				<td><a href="update?id=<%=employee.getId()%>"><button>update</button></a></td>
			</tr>
		<%} %>
	</table>
	
</body>
</html>