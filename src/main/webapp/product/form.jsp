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
    <title>Product Form</title>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>

<form action="/product/add" method="post">
    Product name: <input type="text" name="name"><br>
    <input type="submit">
</form>
</body>
</html>
