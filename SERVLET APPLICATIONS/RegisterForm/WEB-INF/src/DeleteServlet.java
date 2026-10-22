import javax.servlet.*;
import java.sql.*;
import java.io.*;

public class DeleteServlet extends GenericServlet
{
	Connection con=null;
	Statement st=null;
	static final String ADMIN_PASSWORD="cmrcet@admin2024";

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
		String pass=req.getParameter("pass");
		int no=Integer.parseInt(req.getParameter("no"));

		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();

		if(pass==ADMIN_PASSWORD)
			{
			pw.println("<html><body><h1>Wrong password</h1></body></html>");
			return;
			}

		String qry="delete from student where no="+no;
		st.executeUpdate(qry);

		pw.println("<html>");
		pw.println("<body>");
		pw.println("<h1> <center> Student "+no+" deleted");
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
