// Write a SERVLET program which counts how many times a user has visited a web page. If user is visiting the page for the first time, display a welcome message. If the user is revisiting the page, display the number of times visited. (Use Cookie)

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VisitCounterServlet")
public class VisitCounterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the cookies associated with the request
        Cookie[] cookies = request.getCookies();
        
        // Initialize a counter variable
        int visitCount = 0;

        // Check if the cookies contain a visit count
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("visitCount")) {
                    visitCount = Integer.parseInt(cookie.getValue());
                    break;
                }
            }
        }

        // Increment the visit count
        visitCount++;

        // Create a cookie to store the visit count
        Cookie visitCountCookie = new Cookie("visitCount", String.valueOf(visitCount));
        visitCountCookie.setMaxAge(24 * 60 * 60); // Cookie will expire in 24 hours

        // Add the cookie to the response
        response.addCookie(visitCountCookie);

        // Set the response content type
        response.setContentType("text/html");

        // Write HTML response
        response.getWriter().println("<html><head><title>Visit Counter Servlet</title></head><body>");

        // Check if it's the user's first visit
        if (visitCount == 1) {
            response.getWriter().println("<h1>Welcome, First Time Visitor!</h1>");
        } else {
            response.getWriter().println("<h1>Welcome Back! You've visited this page " + visitCount + " times.</h1>");
        }

        response.getWriter().println("</body></html>");
    }
}

