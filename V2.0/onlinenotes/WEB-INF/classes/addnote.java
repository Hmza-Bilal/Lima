import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class addnote extends HttpServlet{
	public void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException 
	{
		
		PrintWriter out;
		out = response.getWriter();	
		String title = request.getParameter("title");
		String descrip = request.getParameter("descrip");

		HttpSession session = request.getSession(false);
	
if(session == null){
	out.println("Session not Found");
	RequestDispatcher rd = request.getRequestDispatcher("login.html");
	rd.include(request, response);

}
else{
		int i = (int)session.getAttribute("id");
		notesDAO notesdao = new notesDAO();
		int st = notesdao.addnotes(title,descrip,i);
		
       
    if(st > 0)
			{
			out.println("Notes Added");
			response.sendRedirect("mainview");
       
       }
       else
        {
          out.println("<p> Record could not inserted. </p>");
        }
	}
}
}