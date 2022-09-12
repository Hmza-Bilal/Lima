import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;

public class search extends HttpServlet{
	public void doPost(HttpServletRequest request , HttpServletResponse response) throws IOException 
	{
		PrintWriter out;
        HttpSession session = request.getSession(false);
			if(session != null)
		{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1/onlinenotes";
			Connection con=DriverManager.getConnection(url,"root","root");
	   		Statement st=con.createStatement();
			out = response.getWriter();
			String search_title = request.getParameter("search");
				
			String query ="SELECT * FROM notesdata WHERE Title LIKE '%"+search_title+"%' ";
			ResultSet rs = st.executeQuery(query); 
		            
		        
		
            RequestDispatcher red = request.getRequestDispatcher("mainview.html");
			red.include(request,response);
        while(rs.next())
		{
			 
			String title = rs.getString("Title");
			String descrip = rs.getString("descrip");
					
            out.println("<h5>"+title+" </h5> ");
            out.println("<p>"+descrip+" </p> ");
            String noteid = rs.getString("id");

            out.println(" <button><a href='delete?noteid="+noteid+"' > Delete</a></button>");
            out.println(" <button><a href='update?noteid="+noteid+"' > Update</a></button>");
   		}
           RequestDispatcher rec = request.getRequestDispatcher("Footer.html");
           rec.include(request,response); 
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
