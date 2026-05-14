<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Delete Fee Payment</title>

<link rel="stylesheet" type="text/css" href="style.css">

</head>

<body>

<div class="container">

    <h2>Delete Fee Payment</h2>

    <form action="DeleteFeePaymentServlet" method="get">

        <label>Payment ID</label>

        <input type="text" name="id" required>

        <input type="submit" value="Delete Payment">

    </form>

    <br>

    <a href="index.jsp">Back to Home</a>

</div>

</body>
</html>