<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Update Fee Payment</title>

<link rel="stylesheet" type="text/css" href="style.css">

</head>

<body>

<div class="container">

    <h2>Update Fee Payment</h2>

    <form action="UpdateFeePaymentServlet" method="post">

        <label>Payment ID</label>
        <input type="text" name="id" required>

        <label>Student ID</label>
        <input type="text" name="studentId" required>

        <label>Student Name</label>
        <input type="text" name="studentName" required>

        <label>Payment Date</label>
        <input type="date" name="paymentDate" required>

        <label>Amount</label>
        <input type="text" name="amount" required>

        <label>Status</label>

        <select name="status">

            <option value="Paid">Paid</option>

            <option value="Overdue">Overdue</option>

        </select>

        <input type="submit" value="Update Payment">

    </form>

    <br>

    <a href="index.jsp">Back to Home</a>

</div>

</body>
</html>