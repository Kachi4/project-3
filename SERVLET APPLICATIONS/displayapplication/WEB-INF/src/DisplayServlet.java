import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class DisplayServlet extends GenericServlet
{
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
    public void init(ServletConfig config)
    {
        try
        {
    	String driver=config.getInitParameter("p1");
    	String url=config.getInitParameter("p2");
	   Class.forName(driver);
	  con=DriverManager.getConnection(url);
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
              String qry="select *from student where sno="+no;   
              rs=st.executeQuery(qry);
        
              res.setContentType("text/html");
              PrintWriter pw=res.getWriter();

             pw.println("<html><body bgcolor=pink text=blue>");
pw.println("<Center>Student Information");
pw.println("<table border=1>");
pw.println("<tr><th>Sno </th> <th>Sname </th><th>tot </th></tr>");
pw.println("<tr>");
              if(rs.next())
              {
	pw.println("<td>"+rs.getInt(1)+"</td>");
	pw.println("<td>"+rs.getString(2)+"</td>");
	pw.println("<td>"+rs.getInt(3)+"</td>");
              } 
              else
              {
	pw.println("<h1>Record not found");
              }  
pw.println("</tr></table>") ;    
	pw.close();
   }
catch(Exception e)
{
	System.out.println(e);
}
  }
public void destroy()
{
         try{
	rs.close();
	st.close();
	con.close();
             }
	catch(Exception e)
	{
		System.out.println(e);
	}
}



}