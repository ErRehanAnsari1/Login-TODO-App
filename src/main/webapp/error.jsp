<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Failed</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background: linear-gradient(to right, #ff5f6d, #ffc371);
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        color: #fff;
    }
    .card {
        background: white;
        padding: 30px;
        border-radius: 12px;
        box-shadow: 0px 4px 10px rgba(0,0,0,0.2);
        text-align: center;
        color: #ff5f6d;
    }
    a {
        display: inline-block;
        margin-top: 20px;
        background: #ff5f6d;
        color: #fff;
        padding: 10px 20px;
        text-decoration: none;
        border-radius: 8px;
        font-weight: bold;
    }
    a:hover { background: #e14b57; }
</style>
</head>
<body>
    <div class="card">
        <h2>❌ Invalid Username or Password ❌</h2>
        <p>Please try again with correct credentials.</p>
        <a href="login.jsp">Back to Login</a>
    </div>
</body>
</html>

