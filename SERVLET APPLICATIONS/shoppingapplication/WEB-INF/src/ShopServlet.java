import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class ShopServlet extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();

		pw.println("<body bgcolor=pink text=blue>");
		
		HttpSession session=req.getSession();
		String sb=req.getParameter("s");

		if(sb.equals("Add Item"))
		{
			String code=req.getParameter("t1");
			String qty=req.getParameter("t2");
			
			session.setAttribute(code,qty);
			res.sendRedirect("shoppage.html");
		}
		else if(sb.equals("Remove Item"))
		{
			String code=req.getParameter("t1");
			session.removeAttribute(code);	
			res.sendRedirect("shoppage.html");
		}
		else if(sb.equals("Show Items"))
		{
			Enumeration e=session.getAttributeNames();
			if(e.hasMoreElements())
			{
			      pw.println("<center><h2> Ur Shoping Items");
			       while(e.hasMoreElements())
			       {
				String c=(String)e.nextElement();
				pw.println("Product code :"+c);
			pw.println("<br>Quantity is :"+session.getAttribute(c));
				
			        }
			}
			else
			{
				pw.println("<center><h2>No Items Please");
			}
		    pw.println("<a href='shoppage.html'> Click Here to shopping</a>");
		}
		else if(sb.equals("Log Out"))
		{
			session.invalidate();
		pw.println("<a href='shoppage.html'>want to shop again</a>");
		}
		pw.println("</body>");		
		pw.close();
	}
}