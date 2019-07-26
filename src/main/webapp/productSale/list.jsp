<%@ page import="java.util.List" %>
<%@ page import="pl.sda.store.model.ProductSale" %><%--

Created by IntelliJ IDEA.
  User: ar
  Date: 24.07.2019
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Invoice List</title>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>

<table>
    <tr>
        <th style="width: 150px;">ID</th>
        <th style="width: 150px;">Sale Quantity</th>
        <th style="width: 150px;">Price</th>
        <th style="width: 150px;">Invoice ID</th>
    </tr>
    <% List<ProductSale> productSales = (List<ProductSale>) request.getAttribute("productSaleList");
        for (int i = 0; i < productSales.size(); i++) {
            ProductSale productSale = productSales.get(i);

            out.print("<tr>");
            out.print("<td>" + productSale.getId() + "</td>");
            out.print("<td>" + productSale.getQuantity() + "</td>");
            out.print("<td>" + productSale.getPrice() + "</td>");
            out.print("<td>" + productSale.getInvoice().getId() + "</td>");
        }
    %>
</table>
</body>
</html>
