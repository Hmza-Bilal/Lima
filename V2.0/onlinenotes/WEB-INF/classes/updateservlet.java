
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class updateservlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request , HttpServletResponse response) throws IOException , ServletException
	{
        HttpSession session = request.getSession(false);
			if(session != null)
		{
		PrintWriter out;
		out = response.getWriter();	
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String descrip = request.getParameter("descrip");

		
	
	if(session == null){
		out.println("Session not Found");
		RequestDispatcher rd = request.getRequestDispatcher("login.html");
		rd.include(request, response);

}
else{
		
		notesDAO notesdao = new notesDAO();
		int st = notesdao.updatenotes(title ,descrip,id);
		
       
    if(st > 0)
			{
			out.println("Updated");
			response.sendRedirect("mainview");
       
       }
       else
        {
          out.println("<p> Record could not inserted. </p>");
        }

		
		
  
	}

		}
		else
		{
			response.sendRedirect("login.html");
		}
	}
}

