<body bgcolor=pink text=blue>
<%@ page language='java' import='java.sql.*,java.text.*' %>
<center> <table border=1 width=600 >
<tr>
     <th> head Id</th>
     <th> head name</th>
     <th>  Gender</th>
     <th>  Address</th>
     <th> contact</th>
       <th>Registered Date</th>
     <th> Image</th>
</tr>
<%
    Connection cn=null;
     PreparedStatement pst=null;
     ResultSet rs=null;
      try
     {
 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
  cn=DriverManager.getConnection("jdbc:odbc:cmsdsn");
  pst=cn.prepareStatement("select *from headinfo where status='Active' ");
   rs=pst.executeQuery();

  while(rs.next())
   {
out.println("<tr>");
out.println("<td>"+rs.getInt(1)+"</td>");
out.println("<td>"+rs.getString(2)+"</td>");
out.println("<td>"+rs.getString(3)+"</td>");
out.println("<td>"+rs.getString(4)+"</td>");
out.println("<td>"+rs.getString(5)+"</td>");
out.println("<td>"+rs.getString(6)+"</td>");
out.println("<td>"+rs.getString(7)+"</td>");
   }
   rs.close();
   pst.close();
   cn.close();
}
catch(Exception e)
{
	out.println(e);
}
%>
</body>