<%@ page import='java.sql.*,java.text.*'%>
<body bgcolor=pink text=blue>
<form action='astaff1.jsp'>
<center><h1> STAFF REGISTRATION

<%
  int no=0;
try
{
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
  Connection con=DriverManager.getConnection("jdbc:odbc:cmsdsn");
  Statement st=con.createStatement();
  String qry="select max(staffid) from staffinfo";
  ResultSet rs=st.executeQuery(qry);
   if(rs.next())
   {
	no=Integer.parseInt(rs.getString(1))+1;
   }
}
catch(Exception e)
{
	no=10001;
}
    

%>

<table border="0">
<tr>
	<th>Staff ID :</th>
	<td><input type=text name=t1 value=<%=no%> readonly></td>
</tr>
<tr>
	<th>Staff Name :</th>
	<td><input type=text name=t2 ></td>
</tr>
<tr>
	<th>Gender :</th>
	<td><select name=t3>
		<option>Select</option>
		<option>Male</option>
		<option>Female</option>
		</select></td>
</tr>
<tr>
	<th>Address :</th>
	<td><textarea name=t4 rows=3 cols=30></textarea></td>
</tr>
<tr>
	<th>Contact :</th>
	<td><input type=text name=t5></td>
</tr>
<tr>
	<th>Registration Date :</th>
<%
	SimpleDateFormat sd=new SimpleDateFormat("dd-MM-yyyy");
	String str=sd.format(new java.util.Date()).toString();

%>

	<td><input type=text name=t6 value=<%=str%> readonly></td>
</tr>
<tr>
	<th>Image:</th>
	<td><input type=file name=t7></td>
</tr>
</table>
<input type=submit value=REGISTER>
</form>
</body>