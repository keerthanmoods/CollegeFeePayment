<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.model.FeePayment" %>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Report Result</title>

<link rel="stylesheet" type="text/css" href="style.css">

</head>

<body>

<div class="container">

    <h2>Report Result</h2>

    <%
        if(request.getAttribute("list") != null){

            List<FeePayment> list =
                    (List<FeePayment>) request.getAttribute("list");
    %>

    <table>

        <tr>

            <th>Payment ID</th>
            <th>Student ID</th>
            <th>Student Name</th>
            <th>Payment Date</th>
            <th>Amount</th>
            <th>Status</th>

        </tr>

        <%
            for(FeePayment f : list){
        %>

        <tr>

            <td><%= f.getPaymentId() %></td>

            <td><%= f.getStudentId() %></td>

            <td><%= f.getStudentName() %></td>

            <td><%= f.getPaymentDate() %></td>

            <td><%= f.getAmount() %></td>

            <td><%= f.getStatus() %></td>

        </tr>

        <%
            }
        %>

    </table>

    <%
        }
    %>

    <%
        if(request.getAttribute("total") != null){
    %>

    <h3>
        Total Collection :
        ₹ <%= request.getAttribute("total") %>
    </h3>

    <%
        }
    %>

    <%
        if(request.getAttribute("error") != null){
    %>

    <p class="error">
        <%= request.getAttribute("error") %>
    </p>

    <%
        }
    %>

    <br>

    <a href="index.jsp">
        Back to Home
    </a>

</div>

</body>
</html>