<html>
<body bgcolor=pink text=blue>

<%
   try
  {
	String uname=request.getParameter("t1");
	String pwd=request.getParameter("t2");

	if(uname.length()!=0)
	{
	        if(pwd.length()!=0)
	        {
   if(uname.equals("Admin") && pwd.equals("Admin"))
   {
	response.sendRedirect("AdminPage.jsp");
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