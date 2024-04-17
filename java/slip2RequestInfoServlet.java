// Design a servlet that provides information about a HTTP request from a client, such as IP-Address and browser type. The servlet also provides information about the server on which the servlet is running, such as the operating system type, and the names of currently loaded servlets.

import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;



public class show extends HttpServlet {


    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{	res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		out.println("Protocol = "+req.getProtocol()+"<br>");
		out.println("Remote Address = "+req.getRemoteAddr()+"<br>");
		out.println("Remote Host = "+req.getRemoteHost()+"<br>");
		out.println("Server Name = "+req.getServerName()+"<br>");
		out.println("Server Port = "+req.getServerPort()+"<br>");
		out.println("Server Path = "+req.getServletPath()+"<br>");
		out.println("Server Method = "+req.getMethod()+"<br>");
		out.println("Server Remote User = "+req.getRemoteUser()+"<br>");
		out.close();
	}
}

