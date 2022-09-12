import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import java.io.*;

public class logout extends HttpServlet{
	public void doGet(HttpServletRequest request , HttpServletResponse response ) throws IOException
	{
		HttpSession session = request.getSession(false);
			if(session != null)
		{
		session.invalidate();
        response.sendRedirect("login.html");
        }
         else if(session == null)
		{
			response.sendRedirect("login.html");
		}

			
	}
}

