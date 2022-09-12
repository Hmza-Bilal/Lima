import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class signup extends HttpServlet{
	public void doPost(HttpServletRequest request , HttpServletResponse response) throws IOException 
	{
		
		PrintWriter out;
		try{

			Class.forName(  "com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1/onlinenotes";
			Connection con=DriverManager.getConnection(url, "root", "root");
			Statement st=con.createStatement();

			out = response.getWriter();
					
			String name = request.getParameter("fname");
			String Email = request.getParameter("email");
			String Password = request.getParameter("confpass");
		
      String query="insert into signup(Name,Email,Pass ) values('"+name+"','"+Email+"', '"+Password+"')"; 
            
	    int rs = st.executeUpdate( query );
       
    if(rs > 0)
			{
			
			response.sendRedirect("login.html");
       
       }
       else
        {
          out.println("<p> Record could not inserted. </p>");
        }
        

    
    }
		catch(Exception exp)
		{
		 	out = response.getWriter();

		 	out.println("<p>Something Went wrong!</p>");
		 	out.println("<p> "+exp+" </p>");
			}
        out.close(); 
	}

}
