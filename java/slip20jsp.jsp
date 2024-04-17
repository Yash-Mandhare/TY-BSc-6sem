<!-- Create a JSP page to accept a number from a user and display it in words: Example: 123 – One Two Three. The output should be in red color. -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <html>
        <body>
            <form method=get action="">
                Enter Any Number : <input type=text name=num><br><br>
                <input type=submit value="Display">
                </form>
        <font color=red>
        <%! int i,n;
               String s1;
        %>
        <% 
    s1 = request.getParameter("num");
    if(s1 != null && !s1.isEmpty()) {
        n = s1.length();
        i = 0;
        do {
            char ch = s1.charAt(i);
            switch(ch) {
                case '0': out.println("Zero  "); break;
                case '1': out.println("One  "); break;
                case '2': out.println("Two  "); break;
                case '3': out.println("Three  "); break;
                case '4': out.println("Four "); break;
                case '5': out.println("Five  "); break;
                case '6': out.println("Six  "); break;
                case '7': out.println("Seven  "); break;
                case '8': out.println("Eight  "); break;
                case '9': out.println("Nine  "); break;
            }
            i++;
        } while (i < n);
    } else {
        out.println("Please enter a number.");
    }
%>

        </font>
        </body>
        </html>
