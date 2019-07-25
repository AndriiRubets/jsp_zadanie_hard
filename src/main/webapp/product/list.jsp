<%@ page import="pl.sda.store.model.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ar
  Date: 24.07.2019
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>

<table>

    <tr>
        <th style="width: 150px;">ID</th>
        <th style="width: 150px;">Name</th>
        <th style="width: 150px;">INVENTORIES</th>
        <th style="width: 150px;">Name</th>
    </tr>
    <% List<Product> products = (List<Product>) request.getAttribute("productList");
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);

            out.print("<tr>");
            out.print("<td>" + p.getId() + "</td>");
            out.print("<td>" + p.getName() + "</td>");
            out.print("<td>" +
                    "<a href=\"/inventory/list?productId="+p.getId()+"\">See all Inventories</a>"+
                    "</td>");
            out.print("<td>" +
                    "<a href=\"/inventory/add?productId="+p.getId()+"\">Add inventory</a>"+
                    "</td>");
            out.print("</tr>");
        }
    %>
</table>
</body>
</html>