import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class slip11servlet extends HttpServlet {

    // This method will handle GET requests
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        // Retrieve the customer number from the request parameters
        String customerNumber = req.getParameter("customerNumber");

        // Connect to the database (Replace the connection details with your own)
        String url = "jdbc:postgresql://localhost:5432/your_database";
        String username = "postgres";
        String password = "6512";

        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            
            // Prepare a SQL statement to search for the customer
            String sql = "SELECT * FROM customer WHERE customer_number = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, customerNumber);
            
            // Execute the query
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // If a customer with the provided number is found, display their details
                out.println("<h2>Customer Details</h2>");
                out.println("<p>Customer Number: " + rs.getString("customer_number") + "</p>");
                out.println("<p>Name: " + rs.getString("name") + "</p>");
                out.println("<p>Email: " + rs.getString("email") + "</p>");
                // You can display other customer details here
            } else {
                // If no customer with the provided number is found, display an error message
                out.println("<h2>Error</h2>");
                out.println("<p>Customer with number " + customerNumber + " not found.</p>");
            }

            // Close the database connection and resources
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            // If an exception occurs, display an error message
            out.println("<h2>Error</h2>");
            out.println("<p>An error occurred while searching for the customer.</p>");
            e.printStackTrace(out); // This prints the stack trace to the browser for debugging
        }

        out.close();
    }
}
