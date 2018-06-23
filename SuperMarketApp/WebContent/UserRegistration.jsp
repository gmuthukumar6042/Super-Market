<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Registration</title>
</head>
<body>
<form method="post" action="RegisterServlet">
<p>Employee ID		<input type="text" name="empid"/></p>
<p>Employee Name	<input type="text" name ="empname"/></p>
<p>Department Code	<input type="text" name ="deptcode"/></p>
<p>Date of Joining	<input type="text" name ="dateofjoining"/><b>Note:</b><i>Enter date in (dd/mm/yyyy)</i></p>
<p>Password			<input type="password" name ="userpassword"/> </p>
<p><input type="submit" value="Submit"/></p>
</form>
</body>
</html>