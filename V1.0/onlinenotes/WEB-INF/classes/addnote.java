import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class addnote extends HttpServlet{
	
	public void doPost(HttpServletRequest request , HttpServletResponse response) throws IOException 
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
		
            String uid = (String)session.getAttribute("user_id");
			String  title = request.getParameter("title");
			String descrip = request.getParameter("descrip");
			

            String query="insert into notesdata(Title,descrip,note_id ) values('"+title+"','"+descrip+"','"+uid+"')"; 
            
            int rs = st.executeUpdate( query );
           
     if(rs>0)
			{

		
				response.sendRedirect("mainview");
		}
			else
			{
                out.println("<p> record could not insert </p>");		
				// response.sendRedirect("record could not insert");
		
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

