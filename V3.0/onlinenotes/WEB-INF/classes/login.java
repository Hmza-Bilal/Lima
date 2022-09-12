import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class login extends HttpServlet{
	
	public void doPost(HttpServletRequest request , HttpServletResponse response) throws IOException , ServletException
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		
		String email = request.getParameter("email");
		String password = request.getParameter("pass");

		userDAO userdao = new userDAO();
		userinfo usr = userdao.searchUser(email, password);

		if(usr == null){
			out.println("Wrong Login Details");
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request,response);
		}
		else if(usr.getstatus() == 1){
			out.println("You have been blocked by admin");
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request,response);
		}
		else{

				HttpSession session = request.getSession();
				session.setAttribute("email",email);
				session.setAttribute("pass",password);
				session.setAttribute("id",usr.getid());
				response.sendRedirect("mainview");
		}
    }
	

}
