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
		display: flex;
		justify-content: center;
	}
	input{
		width:400px;
		height:40px;
		color:red;
		border-radius: 4px;
		border: 3px solid rgb(128, 0, 64);
	}
	input:hover{
		background-color: yellow;
		color: black;
	}
	div{
		display: flex;
		justify-content: center;
	}
	fieldset{
		border: 4px solid green;
		border-radius: 3px;
	}
	H1{
		text-align: CENTER;
		color: red;
		text-decoration: underline;
	}
	#i1{
		margin-top: 50px;;
	}
	.i2{
		text-align:center;
		color :red;
		font-size:32px;
		margin-top:30px;
		border:none;
	}
	.i2:hover{
		background-color:white;
	}
	#i3{
		margin-left: 26px;;
	}
	#i4{
		margin-left: 20px;;	
	}
	#i5{
		margin-left: 33px;;
	}
	#i6{
		margin-left: 10px;;
	}	
	button{
		width:150px;
		height:30px;
		font-family: 100px;
		font-size: 20px;
	}
	button:hover{
		background-color: rgb(128, 255, 255);
		border-radius: 10px;
	}
	fieldset:hover{
		background-color: rgb(192, 192, 192);;
	}
	#b2{
		margin-left: 110px;
		
	}
	a{
		text-decoration :none;
		color:black;
	}
	</style>
<body>
	<form action = "signup" method = "post">
		<input type= "text" class ="i2" name = "text" placeholder = "LOGIN AND SIGNUP PAGE"><BR><BR>
		<input type = "number" id = "i1" name = "id" placeholder = "enter id">
		<br><br>
		<input type = "text" name = "name" placeholder = "enter name">
		<br><br>
		<input type = "tel" name = "phone" placeholder = "enter phone">
		<br><br>
		<input type = "text" name = "address" placeholder = "enter address">
		<br><br>
		<input type = "text" name = "email" placeholder = "enter email">
		<br><br>
		<input type = "text" name = "password" placeholder = "enter password">
		<br><br>
		<button>submit</button><button id = "b2"><a href = "login.jsp">login</a></button>
	</form>
</body>
</html>