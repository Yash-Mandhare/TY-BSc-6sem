// Write a SERVLET program which counts how many times a user has visited a web page. If user is visiting the page for the first time, display a welcome message. If the user is revisiting the page, display the number of times visited. (Use Cookie)

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class  slip15VisitCounterServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get the existing cookies
        Cookie[] cookies = request.getCookies();
        int visitCount = 0;

        // Check if the cookies contain the visit count
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

        // Create a new cookie to store the visit count
        Cookie visitCookie = new Cookie("visitCount", String.valueOf(visitCount));
        visitCookie.setMaxAge(3600); // Cookie expires in 1 hour
        response.addCookie(visitCookie);

        // Display welcome message or visit count
        if (visitCount == 1) {
            out.println("<h1>Welcome! This is your first visit.</h1>");
        } else {
            out.println("<h1>Welcome back! You have visited this page " + visitCount + " times.</h1>");
        }
    }
}