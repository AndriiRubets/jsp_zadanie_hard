<%@ page import="pl.sda.store.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="pl.sda.store.model.Inventory" %><%--
  Created by IntelliJ IDEA.
  User: ar
  Date: 24.07.2019
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inventory List</title>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>

<table>
    <tr>
        <th style="width: 150px;">ID</th>
        <th style="width: 150px;">Quantity</th>
        <th style="width: 150px;">Value</th>
        <th style="width: 150px;">Date Arrived</th>
    </tr>
    <% List<Inventory> inventories = (List<Inventory>) request.getAttribute("inventoryList");
        for (int i = 0; i < inventories.size(); i++) {
            Inventory inventory = inventories.get(i);

            out.print("<tr>");
            out.print("<td>" + inventory.getId() + "</td>");
            out.print("<td>" + inventory.getQuantity() + "</td>");
            out.print("<td>" + inventory.getValue() + "</td>");
            out.print("<td>" + inventory.getDateArrived() + "</td>");

        }
    %>
</table>
</body>
</html>
