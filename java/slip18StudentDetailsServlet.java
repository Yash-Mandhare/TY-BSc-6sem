// Write a SERVLET program in java to accept details of student (SeatNo, Stud_Name, Class, Total_Marks). Calculate percentage and grade obtained and display details on page.


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class slip18StudentDetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Accepting details from the request parameters
        int seatNo = Integer.parseInt(request.getParameter("seatNo"));
        String studName = request.getParameter("studName");
        String studClass = request.getParameter("studClass");
        int totalMarks = Integer.parseInt(request.getParameter("totalMarks"));
        
        // Calculating percentage
        double percentage = (totalMarks / 500.0) * 100;
        
        // Determining grade
        String grade;
        if (percentage >= 90) {
            grade = "A+";
        } else if (percentage >= 80) {
            grade = "A";
        } else if (percentage >= 70) {
            grade = "B";
        } else if (percentage >= 60) {
            grade = "C";
        } else if (percentage >= 50) {
            grade = "D";
        } else {
            grade = "Fail";
        }
        
        // Displaying student details and result on the web page
        out.println("<html><body>");
        out.println("<h2>Student Details</h2>");
        out.println("<p>Seat No: " + seatNo + "</p>");
        out.println("<p>Name: " + studName + "</p>");
        out.println("<p>Class: " + studClass + "</p>");
        out.println("<p>Total Marks: " + totalMarks + "</p>");
        out.println("<p>Percentage: " + percentage + "%</p>");
        out.println("<p>Grade: " + grade + "</p>");
        out.println("</body></html>");
        
        out.close();
    }
}
