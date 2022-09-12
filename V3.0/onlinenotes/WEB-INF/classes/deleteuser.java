import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class deleteuser extends HttpServlet{
	public void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException 
	{
		
		PrintWriter out;
		out = response.getWriter();		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
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
		int st = admindao.deleteuser(email,password,i);
		
       
    if(st > 0)
			{
			out.println("Deleted");
			response.sendRedirect("adminview");
       
       }
       else
        {
          out.println("<p> Record could not be deleted. </p>");
        }
	}
}
}