import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;

public class delete extends HttpServlet{
		@Override
	public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException 
	{
        

		HttpSession session = request.getSession(false);
			if(session != null)
		{
		PrintWriter out;
	
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1/onlinenotes";
			Connection con=DriverManager.getConnection(url,"root","root");
	   		Statement st=con.createStatement();

	   		String noteid = request.getParameter("noteid");
			out = response.getWriter();
			String query ="Delete From notesdata where id="+noteid+"  ";
			int rs = st.executeUpdate( query );
            
        if(rs> 0)
		{
			response.sendRedirect("mainview");
		}
		}
		catch(Exception exp)
		{
		 	out = response.getWriter();

		 	out.println("<p> "+exp+" </p>");
		}
		out.close(); 
	}

		else if(session == null)
		{
			response.sendRedirect("login.html");
		}
            
       
        	

	}


}
