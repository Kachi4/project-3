<body bgcolor=pink text=blue>
<%@ page language='java' import='java.sql.*,java.text.*' %>

  <%
    Connection cn=null;
     PreparedStatement pst=null;
      try
     {

      String s1=request.getParameter("t1");
      String s2=request.getParameter("t2");
      String s3=request.getParameter("t3");
      String s4=request.getParameter("t4");
      String s5=request.getParameter("t5");
      String s6=request.getParameter("t6");
      String s7=request.getParameter("t7");

  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
  cn=DriverManager.getConnection("jdbc:odbc:cmsdsn");
  pst=cn.prepareStatement("insert into staffinfo values(?,?,?,?,?,?,?,?)");

    pst.setInt(1,Integer.parseInt(s1));
    pst.setString(2,s2);
    pst.setString(3,s3);
    pst.setString(4,s4);
    pst.setString(5,s5);
    pst.setString(6,s6);
    pst.setString(7,s7);
    pst.setString(8,"Active");

    pst.executeUpdate();

out.println("<h1> Successfully Registered");
  pst.close();
   cn.close();
}
catch(Exception e)
{
	out.println(e);
}
%>


</body>