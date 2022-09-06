import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class login extends HttpServlet{
	
	public void doPost(HttpServletRequest request , HttpServletResponse response) throws IOException 
	{
		
		PrintWriter out;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1/onlinenotes";
			Connection con=DriverManager.getConnection(url,"root","root");
	   	Statement st=con.createStatement();

		 	out = response.getWriter();
		
		
			String  Page_email = request.getParameter("email");
			String Page_pass = request.getParameter("pass");
			

			String query="Select * From signup where Email ='"+Page_email+"' ";
			ResultSet rs = st.executeQuery(query); 
           
     if(rs.next())
			{

			String db_pass = rs.getString("Pass");
			if(db_pass.equals(Page_pass))
			{

				String user_id = rs.getString("id");
				HttpSession session = request.getSession();
				// session.setAttribute("email",Page_email);
				session.setAttribute("user_id", user_id);
				response.sendRedirect("mainview");
		}
			else
			{		
				response.sendRedirect("login.html");
		
			}
		}
		else
        {
			response.sendRedirect("login.html");            
        }
    }
		catch(Exception exp)
		{
		 out = response.getWriter();

		 out.println("<p> "+exp+" </p>");
		}
            
          
     out.close();
	}

}
