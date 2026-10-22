import javax.servlet.*;
import java.sql.*;
import java.io.*;

public class SearchServlet extends GenericServlet
{
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;

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
		String name=req.getParameter("name");

		String qry="select * from student where name like '%"+name+"%'";
		rs=st.executeQuery(qry);

		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		pw.println("<html>");
		pw.println("<body>");
		pw.println("<h2> Results for: "+name+"</h2>");
		pw.println("<table border=1>");
		pw.println("<tr><th>No</th><th>Name</th><th>Marks</th></tr>");
		while(rs.next())
			{
			pw.println("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getInt(3)+"</td></tr>");
			}
		pw.println("</table>");
		pw.println("</body> </html>");
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
