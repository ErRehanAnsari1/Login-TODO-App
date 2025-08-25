package com.todo.servlet;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.login.servlet.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/TodosServlet")
public class TodosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        String username = (String) session.getAttribute("username");
        List<String[]> todos = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "SELECT id, task, status FROM todos WHERE username=? ORDER BY id DESC")) {

            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String[] row = new String[3];
                    row[0] = String.valueOf(rs.getInt("id"));
                    row[1] = rs.getString("task");
                    row[2] = rs.getString("status");
                    todos.add(row);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("todos", todos);
        req.getRequestDispatcher("todos.jsp").forward(req, resp);
    }
}


