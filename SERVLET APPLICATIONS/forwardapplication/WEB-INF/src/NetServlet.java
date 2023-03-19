import javax.servlet.*;
import java.io.*;
public class NetServlet extends GenericServlet
{
    public void service(ServletRequest req,ServletResponse res) throws IOException
    {
        res.setContentType("text/html");
        PrintWriter pw=res.getWriter();
        try{
            float gs=(float)req.getAttribute("gr");
            float ded=gs*0.04f;
            float ns=gs-ded;

            pw.println("<html>");
            pw.println("<body bgcolor='black' text='white'>");
            pw.println("<center><h1>");
            pw.println("GrossSalary:"+gs);
            pw.println("<br>Deductions:"+ded);
            pw.println("<br>NetSalary:"+ns);
            pw.println("</h1></center>");
            pw.println("</body></html>");
            pw.close();

        }catch(Exception e)
        {
            pw.println(e); 
        }
    }
}