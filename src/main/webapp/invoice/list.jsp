<%@ page import="pl.sda.store.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="pl.sda.store.model.Inventory" %>
<%@ page import="pl.sda.store.model.Invoice" %><%--
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
        <th style="width: 150px;">Invoice Col</th>
        <th style="width: 150px;">Date Arrived</th>
        <th style="width: 150px;">SALES LIST</th>
        <th style="width: 150px;">ADD LIST</th>
    </tr>
    <% List<Invoice> invoices = (List<Invoice>) request.getAttribute("invoiceList");
        for (int i = 0; i < invoices.size(); i++) {
            Invoice invoice = invoices.get(i);

            out.print("<tr>");
            out.print("<td>" + invoice.getId() + "</td>");
            out.print("<td>" + invoice.getInvoicecol() + "</td>");
            out.print("<td>" + invoice.getSaleDate() + "</td>");
            out.print("<td>" +
                    "<a href=\"/productSale/list?invoiceId="+invoice.getId()+"\">See all Product Sales</a>"+
                    "</td>");
            out.print("<td>" +
                    "<a href=\"/productSale/add?invoiceId="+invoice.getId()+"\">Add Sale</a>"+
                    "</td>");
            out.print("</tr>");
        }
    %>
</table>
</body>
</html>
