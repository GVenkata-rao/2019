<%@ page language="java"
    contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
                                <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
		<title>login</title>
	</head>

	<body>

	<form action="/login" method="post">
    		<table style="with: 50%">

    			<tr>
    				<td>UserName</td>
    				<td><input type="text" name="userName" /></td>
    			</tr>
    				<tr>
    				<td>Password</td>
    				<td><input type="password" name="password" /></td>
    			</tr>
    		</table>
    		<input type="submit" value="Login" /></form>
    		</body>
</html>