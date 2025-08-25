package com.login.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // basic validation
        if (username == null || username.isBlank() || password == null || password.isBlank()) {
            req.setAttribute("errorMsg", "Username/Password required");
            req.getRequestDispatcher("error.jsp").forward(req, resp);
            return;
        }

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "INSERT INTO users(username, password) VALUES (?, ?)")) {

            ps.setString(1, username.trim());
            ps.setString(2, password.trim());
            int result = ps.executeUpdate();

            if (result > 0) {
                // registration successful -> go to login
                resp.sendRedirect("login.jsp");
            } else {
                req.setAttribute("errorMsg", "Registration failed. Try again.");
                req.getRequestDispatcher("error.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            // likely duplicate username or SQL issue
            e.printStackTrace();
            req.setAttribute("errorMsg", "Username already exists or DB error.");
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}

