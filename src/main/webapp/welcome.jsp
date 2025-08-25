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
        color: #4facfe;
    }
    a {
        display: inline-block;
        margin-top: 20px;
        background: #4facfe;
        color: #fff;
        padding: 10px 20px;
        border-radius: 8px;
        font-weight: bold;
        text-decoration: none;
    }
    a:hover { background: #2f7acc; }
</style>
</head>
<body>
<%
    String uname = (String) session.getAttribute("username");
    if (uname == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
    <div class="card">
        <h2>🎉 Welcome, <%= uname %> 🎉</h2>
        <p>You have successfully logged in.</p>
        <a href="LogoutServlet">Logout</a>
    </div>
</body>
</html>

