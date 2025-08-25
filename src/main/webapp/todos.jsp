<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%
    String username = (String) session.getAttribute("username");
    if (username == null) {
        response.sendRedirect("login.jsp");
        return;
    }
    List<String[]> todos = (List<String[]>) request.getAttribute("todos");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Your Todos</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #8360c3, #2ebf91);
            padding: 30px;
            color: #fff;
        }
        .card {
            background: white;
            padding: 20px;
            border-radius: 12px;
            box-shadow: 0px 4px 10px rgba(0,0,0,0.2);
            color: black;
        }
        h2 { margin-bottom: 20px; }
        form { margin-bottom: 20px; }
        input, select, button {
            padding: 10px;
            margin: 5px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }
        button {
            background: #2ebf91;
            color: white;
            border: none;
            cursor: pointer;
        }
        button:hover { background: #249b75; }
        table {
            width: 100%;
            margin-top: 15px;
            border-collapse: collapse;
        }
        th, td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: left;
        }
        th { background: #f5f5f5; }
        a { color: #2ebf91; font-weight: bold; }
    </style>
</head>
<body>
    <div class="card">
        <h2>Welcome, <%= username %> 👋</h2>

        <!-- Add Todo Form -->
        <form action="AddTodoServlet" method="post">
            <input type="text" name="task" placeholder="Todo task..." required>
            <select name="status">
                <option value="pending">pending</option>
                <option value="in-progress">in-progress</option>
                <option value="done">done</option>
            </select>
            <button type="submit">Add</button>
        </form>

        <!-- Show Todos -->
        <h3>Your Todos</h3>
        <table>
            <tr><th>ID</th><th>Task</th><th>Status</th></tr>
            <%
                if (todos != null && !todos.isEmpty()) {
                    for (String[] row : todos) {
            %>
            <tr>
                <td><%= row[0] %></td>
                <td><%= row[1] %></td>
                <td><%= row[2] %></td>
            </tr>
            <%  }
                } else { %>
            <tr>
                <td colspan="3">No todos yet. Add one above!</td>
            </tr>
            <% } %>
        </table>
        <br>
        <a href="LogoutServlet">Logout</a>
    </div>
</body>
</html>


