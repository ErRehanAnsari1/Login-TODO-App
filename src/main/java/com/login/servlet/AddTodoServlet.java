package com.login.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/AddTodoServlet")
public class AddTodoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String username = (String) session.getAttribute("username");
        String task = request.getParameter("task");
        String status = request.getParameter("status");

        if (task == null || task.isBlank()) {
            request.setAttribute("errorMsg", "Task cannot be empty");
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }
        if (status == null || status.isBlank()) status = "pending";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "INSERT INTO todos (username, task, status) VALUES (?, ?, ?)")) {

            ps.setString(1, username);
            ps.setString(2, task.trim());
            ps.setString(3, status.trim());
            ps.executeUpdate();

            response.sendRedirect("TodosServlet");
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMsg", "DB Error while adding todo");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}

