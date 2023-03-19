

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class RegistrationServletTwo extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		String nm=request.getParameter("t1");
		String pw=request.getParameter("t2");
		String pf=request.getParameter("t3");
		String em=request.getParameter("t4");
		String mn=request.getParameter("t5");


		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		out.println("<body bgcolor=cyan>");
		out.println("<center><h1>name :"+nm);
		out.println("<br>password :"+pw);
		out.println("<br>Profession :"+pf);
		out.println("<br>Email :"+em);
		out.println("<br>Mobile no :"+mn);

		out.println("Registration Successfully");
		
		out.println("</body>");
		out.close();			
	}

}