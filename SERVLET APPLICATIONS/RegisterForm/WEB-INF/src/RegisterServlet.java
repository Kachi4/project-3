import javax.servlet.*;
import java.sql.*;
import java.io.*;
import java.lang.*;

public class RegisterServlet extends GenericServlet
{
	Connection con=null;
	Statement st=null;
	public void init(ServletConfig config)
	{
	try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con=DriverManager.getConnection("jdbc:odbc:cmrcet");
		st=con.createStatement();
		}
	catch(Exception e)
		{
		System.out.println(e);
		}
	}


	public void service(ServletRequest req,ServletResponse res)
	{
		try
		{
		int no=Integer.parseInt(req.getParameter("t1"));
		String name=req.getParameter("t2");
		int marks=Integer.parseInt(req.getParameter("t3"));

		String qry="insert into student values("+no+",'"+name+"',"+marks+");";
		st.executeUpdate(qry);

		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		pw.println("<html>");
		pw.println("<body>");
		pw.println("<h1> <center> Registration Succesfull");
		pw.println("</center> </body> </html>");
		}
	catch(Exception e)
		{
		System.out.println(e);
		}
	}


	public void destroy()
	{
		try
	{
		st.close();
		con.close();
	}
	catch(Exception e)
		{
		System.out.println(e);
		}

	}

}