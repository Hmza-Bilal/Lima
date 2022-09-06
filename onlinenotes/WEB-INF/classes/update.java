import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;

public class update extends HttpServlet{
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

				out = response.getWriter();
                String noteid = request.getParameter("noteid");
				// String user_id =(String)session.getAttribute("user_id");		
				
				String query ="Select * From notesdata where id="+noteid+"  ";

				ResultSet rs = st.executeQuery(query); 
		            
		 
			
				out.println("<html>");
				out.println("<body>");
				

	        while(rs.next())
			{
				String title = rs.getString("Title");
				String descrip = rs.getString("descrip");
				int mid = rs.getInt("id");
				
               
                
                out.println(" <form action=layout method=get enctype=multipart/form-data>");
                out.println("<input type='text' name='title' value='"+title+"' >");
				out.println("<input type='text' name='des' value='"+descrip+"' >");
				out.println("<input type='hidden' name='noteid' value='"+mid+"' >");
                out.println("<button type='submit' name='action' value='update'>Submit Update</button>");	
				out.println("</form>");
        

				
	   		}

			   
			   out.println("</body>");
			   out.println("</html>");
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
