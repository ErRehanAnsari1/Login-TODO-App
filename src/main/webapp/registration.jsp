<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    HttpSession ses = request.getSession(false);
    if (ses != null && session.getAttribute("username") != null) {
        response.sendRedirect("TodosServlet");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Registration</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #ff9a9e, #fad0c4);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background: white;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0px 4px 10px rgba(0,0,0,0.2);
            width: 320px;
            text-align: center;
        }
        .container h2 { margin-bottom: 20px; color: #333; }
        .container input {
            width: 90%;
            padding: 10px;
            margin: 10px 0;
            border-radius: 5px;
            border: 1px solid #ccc;
        }
        .container input[type="submit"] {
            background: #ff758c;
            color: white;
            border: none;
            cursor: pointer;
            transition: 0.3s;
        }
        .container input[type="submit"]:hover {
            background: #e05670;
        }
        a { color: #ff758c; text-decoration: none; }
    </style>
</head>
<body>
    <div class="container">
        <h2>Register</h2>
        <form action="RegisterServlet" method="post">
            <input type="text" name="username" placeholder="Enter Username" required><br>
            <input type="password" name="password" placeholder="Enter Password" required><br>
            <input type="submit" value="Register">
        </form>
        <p>Already registered? <a href="login.jsp">Login here</a></p>
    </div>
</body>
</html>

