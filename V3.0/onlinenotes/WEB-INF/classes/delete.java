import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class delete extends HttpServlet{
	public void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException 
	{
		
		PrintWriter out;
		out = response.getWriter();		
		String title = request.getParameter("title");
		String descrip = request.getParameter("descrip");
		//int id = Integer.parseInt(request.getParameter("id"));

		HttpSession session = request.getSession(false);
	
if(session == null){
	out.println("Session not Found");
	RequestDispatcher rd = request.getRequestDispatcher("login.html");
	rd.include(request, response);

}
else{
		int i = Integer.parseInt(request.getParameter("id"));
		notesDAO notesdao = new notesDAO();
		int st = notesdao.deletenotes(title , descrip,i);
		
       
    if(st > 0)
			{
			out.println("Deleted");
			response.sendRedirect("mainview");
       
       }
       else
        {
          out.println("<p> Record could not be deleted. </p>");
        }
	}
}
}