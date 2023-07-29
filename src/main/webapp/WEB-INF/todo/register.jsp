<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/todo/register" method="post">
		<div>
			<input type="text" name="title" placeholder="타이틀 ">
		</div>
		<div>
			<input type="date" name="dueDate">
		</div>
		
		<div>
		<button type="reset">RESET</button>
		<button type="submit">REGISTER</button>
		</div>
	</form>
</body>
</html>