import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class adminlogin extends HttpServlet{
	
	public void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		response.setContentType("/text/html");
	
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		adminDAO admindao = new adminDAO();
		admininfo admin = admindao.searchadmin(email, password);

		if(admin == null){
			out.println("Wrong Login Details");
		}
		else{
				HttpSession session = request.getSession();
				session.setAttribute("email",email);
				session.setAttribute("password",password);
				session.setAttribute("id",admin.getid());
				response.sendRedirect("adminview");
		}
    }
	

}
