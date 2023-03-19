

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class RegistrationServletOne extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		String nm=request.getParameter("t1");
		String pw=request.getParameter("t2");
		String pf=request.getParameter("t3");

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		out.println("<body bgcolor=cyan>");
		out.println("<h1>Complete the Registration");
		out.println("<form action='./registertwo' method='post'>");
		out.println("<input type=hidden name=t1 value="+nm+">");
		out.println("<input type=hidden name=t2 value="+pw+">");
		out.println("<input type=hidden name=t3 name value="+pf+">");
		out.println("Email Id<input type=text name=t4 ><br><br>");
		out.println("Mobile No<input type=text name=t5 ><br><br>");
		out.println("<input type=submit value=register now>");
		out.println("</form></body>");
		out.close();			
	}

}