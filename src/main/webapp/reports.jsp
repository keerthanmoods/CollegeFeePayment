<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Reports</title>

<link rel="stylesheet" type="text/css" href="style.css">

</head>

<body>

<div class="container">

    <h2>Fee Payment Reports</h2>

    <div class="menu">

        <a href="report_form.jsp">
            Generate Reports
        </a>

        <a href="DisplayFeePaymentsServlet">
            View All Payments
        </a>

    </div>

    <br>

    <form action="ReportServlet" method="post">

        <label>Select Report Type</label>

        <select name="type">

            <option value="overdue">
                Students with Overdue Payments
            </option>

            <option value="total">
                Total Collection by Date Range
            </option>

        </select>

        <br><br>

        <label>From Date</label>
        <input type="date" name="from">

        <label>To Date</label>
        <input type="date" name="to">

        <br><br>

        <input type="submit" value="Generate Report">

    </form>

    <br>

    <a href="index.jsp">Back to Home</a>

</div>

</body>
</html>