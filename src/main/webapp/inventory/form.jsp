<%--
  Created by IntelliJ IDEA.
  User: ar
  Date: 24.07.2019
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inventory Form</title>
</head>
<body>

<form action="/inventory/add" method="post">
    Quantity: <input type="text" name="quantity"><br>
    Value: <input type="text" name="value"><br>

    <input type="hidden" name="productId" value="<%=request.getAttribute("productId")%>" readonly>
    <input type="submit">
</form>
</body>
</html>
