// Write a SERVLET application to accept username and password, search them into database, if found then display appropriate message on the browser otherwise display error message.

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet("/LoginServlet")
public class slip19LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieving username and password from the form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // JDBC connection parameters
        String jdbcUrl = "jdbc:mysql://localhost:3306/your_database_name";
        String dbUsername = "your_database_username";
        String dbPassword = "your_database_password";

        // JDBC connection
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);

            // SQL query to search for username and password in the database
            String query = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Username and password found in the database
                out.println("<html><body>");
                out.println("<h2>Login Successful!</h2>");
                out.println("<p>Welcome, " + username + "!</p>");
                out.println("</body></html>");
            } else {
                // Username and password not found in the database
                out.println("<html><body>");
                out.println("<h2>Login Failed!</h2>");
                out.println("<p>Incorrect username or password. Please try again.</p>");
                out.println("</body></html>");
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
