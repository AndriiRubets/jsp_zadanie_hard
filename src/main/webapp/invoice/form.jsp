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
    <title>Invoice Form</title>
</head>
<body>

<form action="/invoice/add" method="post">
    Invoice col: <input type="text" name="invoicecol"><br>

    <input type="hidden" name="clientId" value="<%=request.getAttribute("clientId")%>" readonly>
    <input type="submit">
</form>
</body>
</html>
