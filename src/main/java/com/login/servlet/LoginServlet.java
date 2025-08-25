package com.login.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String uname = req.getParameter("username");
        String pass = req.getParameter("password");

        if (uname == null || pass == null) {
            req.setAttribute("errorMsg", "Username/Password required");
            req.getRequestDispatcher("error.jsp").forward(req, resp);
            return;
        }

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "SELECT * FROM users WHERE username=? AND password=?")) {

            ps.setString(1, uname.trim());
            ps.setString(2, pass.trim());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    HttpSession session = req.getSession();
                    session.setAttribute("username", uname);
                    resp.sendRedirect("TodosServlet");
                } else {
                    req.setAttribute("errorMsg", "Invalid Username or Password!");
                    req.getRequestDispatcher("error.jsp").forward(req, resp);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            req.setAttribute("errorMsg", "Database Error!");
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}



