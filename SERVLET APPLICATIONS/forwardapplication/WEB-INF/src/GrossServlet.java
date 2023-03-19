import javax.servlet.*;
import java.io.*;
public class GrossServlet extends GenericServlet
{
    public void service(ServletRequest req,ServletResponse res)
    {
        try{
            float bs=Float.parseFloat(req.getParameter("t1"));
            float da=bs*0.1f;
            float hra=da*0.1f;
            float gs=bs+da+hra;

            req.setAttribute("gr",gs);
            RequestDispatcher rd=req.getRequestDispatcher("./starget");
            rd.forward(req,res);

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}