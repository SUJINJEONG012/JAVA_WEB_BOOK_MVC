<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Title</title>
</head>
<body>
	<h1>List Page</h1>

	<ul>
		<%-- <c:forEach var="dto" items="${list}">
        <li>${dto}</li>
    </c:forEach> --%>

		<%-- <c:forEach var="num" begin="1" end="10">
    <li>${num}</li>
    </c:forEach> --%>

		<%-- <c:if test="${list.size() % 2 == 0}">
    짝수
    </c:if>
    <c:if test="${list.size() % 2 != 0}">
    홀수
    </c:if> --%>

		<c:choose>
			<c:when test="${list.size() % 2 == 0}">
     짝수
     </c:when>
			<c:otherwise>
     홀수
     </c:otherwise>
		</c:choose>

	</ul>

</body>
</html>