<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SpringBoot App</title>
</head>
<body style="text-align: center; font-family: sans-serif;">
	
	<h1>Hello World</h1>
	<h1>Happy New Year 2024</h1>
	
	<!-- <form action="add" method="post">
		Enter a value : <input type="text" name="t1" required="required" /><br><br>
		Enter a value : <input type="text" name="t2" required="required" /><br><br>
		<button>Submit</button>
	</form> -->
	
	<form action="addstudent" method="post">
		Enter Student Name : <input type="text" name="name" required="required" /><br><br>
		Enter Student Age : <input type="number" name="age" required="required" /><br><br>
		<button>Add to Database</button>
	</form>
	<br><br>
	<form action="getstudent" method="post">
		Enter Student Id : <input type="number" name="id" required="required" /><br><br>
		<button>Get Student From Database</button>
	</form>
	<br><br>
	<form action="updatestudent" method="post">
		Enter Id :<input type="number" name="id" /><br><br>
		Enter Name :<input type="text" name="name" /><br><br>
		Enter Age :<input type="number" name="age" /><br><br>
		<button>Update Student</button>
	</form>
	<br><br>
	<form action="deletestudent" method="post">
		Enter Id : <input type="text" name="id" /><br><br>
		<button>Delete Student</button>
	</form>
</body>
</html>