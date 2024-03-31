// Design a servlet that provides information about a HTTP request from a client, such as IP-Address and browser type. The servlet also provides information about the server on which the servlet is running, such as the operating system type, and the names of currently loaded servlets.

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Enumeration;

public class RequestInfoServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Request Information</title></head><body>");
        out.println("<h1>Request Information:</h1>");
        out.println("<p><b>Client IP Address:</b> " + request.getRemoteAddr() + "</p>");
        out.println("<p><b>Browser Type:</b> " + request.getHeader("User-Agent") + "</p>");

        out.println("<h1>Server Information:</h1>");
        out.println("<p><b>Server Operating System:</b> " + System.getProperty("os.name") + "</p>");

        out.println("<p><b>Names of currently loaded servlets:</b></p>");
        ServletContext context = getServletContext();
        Enumeration<String> servletNames = context.getServletNames();
        while (servletNames.hasMoreElements()) {
            out.println("<p>" + servletNames.nextElement() + "</p>");
        }

        out.println("</body></html>");
        out.close();
    }
}

