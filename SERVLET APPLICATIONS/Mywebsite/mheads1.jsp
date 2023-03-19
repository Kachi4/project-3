<%@ page import='java.sql.*,java.text.*'%>
<body bgcolor=pink text=blue>
<form action='mstaff2.jsp'>
<center><h1> head UPDATION FORM

<%
	
  int no=0;
try
{

String s1=request.getParameter("t1");
	out.println(s1);

   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
  Connection con=DriverManager.getConnection("jdbc:odbc:cmsdsn");
 String qry="select *from headinfo where  headid="+Integer.parseInt(s1);
 PreparedStatement st=con.prepareStatement(qry);
   ResultSet rs=st.executeQuery();
out.println("<table border=0>");
   if(rs.next())
   {
out.println("<tr><th>headId </th><td><input type=text name=t1 value="+rs.getString(1)+" readonly></td></tr>");
out.println("<tr><th>headname </th><td><input type=text name=t2 value="+rs.getString(2)+"></td></tr>");
	
   }
}
catch(Exception e)
{
	no=10001;
}
    

%>


<input type=submit value=REGISTER>
</form>
</body>
