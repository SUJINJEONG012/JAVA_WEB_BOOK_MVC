<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form id="form1" action="/todo/modify" method="post">
		<div>
			<input type="text" name="tno" value="${dto.tno}" readonly>
		</div>
		<div>
			<input type="text" name="title" value="${dto.title}">
		</div>
		<div>
			<input type="date" name="dueDate" value="${dto.dueDate}">
		</div>
		<div>
			<input type="checkbox" name="finished" ${dto.finished ? "checked" : "" }>
		</div>
		
		<div>
		<button type="submit">Modify</button>
		</div>
	</form>
</body>
</html>