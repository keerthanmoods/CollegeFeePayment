<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>College Fee Payment System</title>

<link rel="stylesheet" type="text/css" href="style.css">

<style>

body{
    margin:0;
    padding:0;
    font-family: Arial, sans-serif;
    background: linear-gradient(135deg,#1e3c72,#2a5298);
    height:100vh;
}

.container{
    width:450px;
    margin:80px auto;
    background:white;
    padding:40px;
    border-radius:20px;
    box-shadow:0 10px 30px rgba(0,0,0,0.3);
    text-align:center;
}

h1{
    color:#1e3c72;
    margin-bottom:35px;
    font-size:32px;
}

.menu{
    display:flex;
    flex-direction:column;
    gap:20px;
}

.menu a{
    text-decoration:none;
    background:#2a5298;
    color:white;
    padding:15px;
    border-radius:10px;
    font-size:18px;
    transition:0.3s;
    font-weight:bold;
}

.menu a:hover{
    background:#1e3c72;
    transform:scale(1.05);
}

</style>

</head>

<body>

<div class="container">

    <h1>College Fee Payment System</h1>

    <div class="menu">

        <a href="feepaymentadd.jsp">
            Add Fee Payment
        </a>

        <a href="feepaymentupdate.jsp">
            Update Fee Payment
        </a>

        <a href="DisplayFeePaymentsServlet">
            Display Fee Payments
        </a>

        <a href="report_form.jsp">
            Reports
        </a>

    </div>

</div>

</body>
</html>