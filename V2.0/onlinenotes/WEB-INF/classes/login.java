import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class login extends HttpServlet{
	
	public void doPost(HttpServletRequest request , HttpServletResponse response) throws IOException 
	{
		
		PrintWriter out = response.getWriter();
		response.setContentType("/text/html");
		String email = request.getParameter("email");
		String password = request.getParameter("pass");

		userDAO userdao = new userDAO();
		userinfo usr = userdao.searchUser(email, password);

		if(usr == null){
			out.println("Wrong Login Details");
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
