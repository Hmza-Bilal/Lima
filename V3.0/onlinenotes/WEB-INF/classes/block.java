import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class block extends HttpServlet{
	public void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException 
	{
		
		PrintWriter out;
		out = response.getWriter();		
		//String name = request.getParameter("Name");
		//String email = request.getParameter("Email");
		//int id = Integer.parseInt(request.getParameter("id"));

		HttpSession session = request.getSession(false);
	
if(session == null){
	out.println("Session not Found");
	RequestDispatcher rd = request.getRequestDispatcher("login.html");
	rd.include(request, response);

}
else{
		int i = Integer.parseInt(request.getParameter("id"));

		adminDAO admindao = new adminDAO();
		int st = admindao.blockuser(i);
		
       
    if(st > 0)
			{
			out.println("User Blocked");
			RequestDispatcher rd = request.getRequestDispatcher("adminview");
	rd.include(request, response);
       
       }
       else
        {
          out.println("<p> User Could not be blocked </p>");
        }
	}
}
}