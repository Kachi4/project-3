import javax.servlet.*;
import java.io.*;

public class AdditionServlet extends GenericServlet
{
	public void service(ServletRequest request,ServletResponse response)
		throws IOException
  	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();

		String a=request.getParameter("t1");
		String b=request.getParameter("t2");

		int n1=Integer.parseInt(a);
		int n2=Integer.parseInt(b);
		int sum=n1+n2;
		
		pw.println("<html>");
		pw.println("<body bgcolor=cyan>");
		pw.println("<h1>The sum is:"+sum+"</h1>");
		pw.println("</body></html>");
		pw.close();
  	}
}
	
