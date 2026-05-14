<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.model.FeePayment" %>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Display Fee Payments</title>

<link rel="stylesheet" type="text/css" href="style.css">

</head>

<body>

<div class="container">

    <h2>Fee Payment Records</h2>

    <table>

        <tr>
            <th>Payment ID</th>
            <th>Student ID</th>
            <th>Student Name</th>
            <th>Payment Date</th>
            <th>Amount</th>
            <th>Status</th>
            <th>Actions</th>
        </tr>

        <%
            List<FeePayment> list =
                    (List<FeePayment>) request.getAttribute("list");

            if(list != null){

                for(FeePayment f : list){
        %>

        <tr>

            <td><%= f.getPaymentId() %></td>

            <td><%= f.getStudentId() %></td>

            <td><%= f.getStudentName() %></td>

            <td><%= f.getPaymentDate() %></td>

            <td><%= f.getAmount() %></td>

            <td><%= f.getStatus() %></td>

            <td>

                <a href="feepaymentupdate.jsp">
                    Edit
                </a>

                |

                <a href="DeleteFeePaymentServlet?id=<%=f.getPaymentId()%>">
                    Delete
                </a>

            </td>

        </tr>

        <%
                }
            }
        %>

    </table>

    <br>

    <a href="index.jsp">Back to Home</a>

</div>

</body>
</html>