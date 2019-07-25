<%@ page import="pl.sda.store.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="pl.sda.store.model.Client" %><%--
  Created by IntelliJ IDEA.
  User: ar
  Date: 24.07.2019
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Client List</title>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>

<table>

    <tr>
        <th style="width: 150px;">ID</th>
        <th style="width: 150px;">Name</th>
        <th style="width: 150px;">Last Name</th>
        <th style="width: 150px;">NIP</th>
        <th style="width: 150px;">INVOICES</th>
        <th style="width: 150px;">ADD INVOICES</th>
    </tr>
    <% List<Client> clients = (List<Client>) request.getAttribute("clientList");
        for (int i = 0; i < clients.size(); i++) {
            Client c = clients.get(i);

            out.print("<tr>");
            out.print("<td>" + c.getId() + "</td>");
            out.print("<td>" + c.getName() + "</td>");
            out.print("<td>" + c.getLastname() + "</td>");
            out.print("<td>" + c.getNip() + "</td>");
            out.print("<td>" +
                    "<a href=\"/invoice/list?clientId="+c.getId()+"\">See all Invoices</a>"+
                    "</td>");
            out.print("<td>" +
                    "<a href=\"/invoice/add?clientId="+c.getId()+"\">Add Invoice</a>"+
                    "</td>");
            out.print("</tr>");
        }
    %>
</table>
</body>
</html>