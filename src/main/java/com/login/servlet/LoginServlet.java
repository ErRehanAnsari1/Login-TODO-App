package com.login.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String uname = req.getParameter("username");
        String pass = req.getParameter("password");

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBConnection.getConnection(); // taking connection of our db
            String query = "select * from users where username=? and password=?";
            ps = con.prepareStatement(query);
            ps.setString(1, uname);
            ps.setString(2, pass);

            rs = ps.executeQuery();

            if (rs.next()) {
                // Save username in request scope
                req.setAttribute("username", uname);
                // Forwarding to welcome.jsp
                req.getRequestDispatcher("welcome.jsp").forward(req, resp);
            } else {
                // Forwarding to error.jsp
                req.getRequestDispatcher("error.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            req.setAttribute("errorMsg", "Database Error!");
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {}
        }
    }
}
