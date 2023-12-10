<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body{
		justify-content: center;
		display: flex;
	}
	#i1{
		
		margin-top:30px;
	}
	#i2 {
		margin-left: 20px;
	}
	fieldset{
		border: 4px solid red;
	}
	p{
		text-align: center;
	}
	input:hover{
		background-color: rgb(192, 192, 192);
		color: red;
		
	}
	input{
		border-radius: 4px;
		font-size: 20px;
	}
	div{
		display: flex;
		justify-content: center;
	}
	button{
		width: 150px;
		font-size: 20px;
		border-radius: 10px;
		margin-left:50px;
	}
	button:hover{
		background-color: yellowgreen;
		color: orange;
		
	}
	fieldset:hover{
		border-radius: 4px;
		background-color: antiquewhite;
		color:red;
	}
</style>
<body>
	<%String message = (String)request.getAttribute("list"); %>
	<%=message %>
	<form action = "login" method = "post">
		<input type = "text" name = "email" id = "i1" placeholder = "enter email">
		<br><br>
		<input type = "text" name = "password" placeholder = "enter password">
		<br><br>
		<button>login</button>
	</form>
</body>
</html>