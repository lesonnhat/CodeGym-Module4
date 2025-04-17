<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Danh sách khách hàng</title>
</head>
<body>
<h2>Danh sách khách hàng</h2>
<ul>
    <c:forEach var="customer" items="${customerList}">
        <li>${customer}</li>
    </c:forEach>
</ul>
</body>
</html>