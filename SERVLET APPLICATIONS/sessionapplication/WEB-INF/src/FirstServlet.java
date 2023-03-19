import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
public class FirstServlet extends HttpServlet{
public void doGet(HttpServletRequest request,HttpServletResponse response){
try{
response.setContentType("text/html");
PrintWriter out=response.getWriter();
String n=request.getParameter("userName");
out.print("Welcome"+n);
HttpSession session=request.getSession();
session.setAttribute("uname",n);
long x=session.getLastAccessedTime();
out.println("Accessed Time:"+x);
out.print("<a href='servlet2'>visit</a>");
out.close();
}
catch(Exception e){System.out.println(e);}
}
}