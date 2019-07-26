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
    <title>Product Sale Form</title>
</head>
<body>

<form action="/productSale/add" method="post">
    Quantity : <input type="text" name="quantity"><br>
    Price : <input type="text" name="price"><br>

    <input type="hidden" name="invoiceId" value="<%=request.getAttribute("invoiceId")%>" readonly>
    <input type="submit">
</form>
</body>
</html>
