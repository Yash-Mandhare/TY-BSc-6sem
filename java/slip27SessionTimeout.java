// Write a SERVLET program to change inactive time interval of session.


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class slip27SessionTimeout extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set session inactive interval to 5 minutes (300 seconds)
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(300);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Session Timeout</title></head><body>");
        out.println("<h1>Session Timeout Changed</h1>");
        out.println("<p>Session inactive interval set to 5 minutes.</p>");
        out.println("</body></html>");
    }
}
