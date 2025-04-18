<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Tra cứu kết quả</title>
</head>
<body>
<h1>Kết quả tra cứu</h1>
<c:if test="${not empty meaning}">
  <p>Nghĩa: ${meaning}</p>
</c:if>
<c:if test="${not empty message}">
  <p>${message}</p>
</c:if>
<a href="/">Tra cứu lại</a>
</body>
</html>