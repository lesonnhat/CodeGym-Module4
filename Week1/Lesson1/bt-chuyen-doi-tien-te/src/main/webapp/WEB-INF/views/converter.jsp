<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Currency Converter</title>
</head>
<body>
<h1>Convert USD to VND</h1>
<form action="convert" method="post">
  Exchange Rate: <input type="text" name="exchangeRate" required/><br/>
  Amount in USD: <input type="text" name="amount" required/><br/>
  <input type="submit" value="Convert"/>
</form>
</body>
</html>