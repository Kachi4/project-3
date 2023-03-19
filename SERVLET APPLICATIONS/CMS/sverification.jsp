<html>
<%@ page import='java.sql.*,java.text.*'%>
<body bgcolor=pink text=blue>
<%
  
    Connection cn=null;
     PreparedStatement pst=null;
     ResultSet rs=null;
   try
  {   
 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
  cn=DriverManager.getConnection("jdbc:odbc:myweb");
  
	String uname=request.getParameter("t1");
	String pwd=request.getParameter("t2");

	if(uname.length()!=0)
	{
	        if(pwd.length()!=0)
	        {
pst=cn.prepareStatement("select *from headinfo1 where status='Active' and headid="+Integer.parseInt(uname)+" and headID="+Integer.parseInt(pwd));
  rs=pst.executeQuery();
      if(rs.next())
       {
	session.setAttribute("headID",rs.getString(1));
	session.setAttribute("headname",rs.getString(2));
    	response.sendRedirect("headpage.jsp");

         }
                         else
	        {
out.println("<center><h1>Invalid UserName/Pwd");
	         }
	        }
	        else
	        {
out.println("<center><h1>Password not Specified");
	         }
	}
	else
	{
out.println("<center><h1>UserName not Specified");
	}
    }
    catch(Exception e)
    {
	out.println(e);
   }
%>
<br><a href='alogin.jsp'> Click Here</a> to back

</body>
</html>