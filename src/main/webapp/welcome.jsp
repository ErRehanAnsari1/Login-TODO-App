<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background: linear-gradient(to right, #4facfe, #00f2fe);
        text-align: center;
        padding: 50px;
        color: #fff;
    }
    h2 {
        margin-bottom: 20px;
    }
    a {
        background: #fff;
        color: #4facfe;
        padding: 10px 20px;
        text-decoration: none;
        border-radius: 8px;
        font-weight: bold;
    }
    a:hover {
        background: #e6f7ff;
    }
</style>
</head>
<body>
    <h2>🎉 Welcome, <%= request.getParameter("username") %> 🎉</h2>
    <p>You have successfully logged in.</p>
    <a href="login.jsp">Logout</a>
</body>
</html>
