import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class mainview extends HttpServlet{
	
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
           
            String user_id =(String)session.getAttribute("user_id");
			String query ="Select * From notesdata where note_id = "+user_id+" ";
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

                // out.println( "<div class='col-4'>");
                // out.println("<div class='card-body'>");
                // out.println( " <h5 class='card-title'>"+title+"");
                // out.println( " <p class='card-text'>"+descrip+"</p>");
                // out.println( "<a href='#' class='tn btn-primary'> Delete </a>");
                // out.println(    "<a href='#' class='tn btn-primary'> Update </a>");
                // // out.println(     "  <a href='#' class='btn btn-primaryv> Update </a>");
                // out.println(   "</div>");
                // out.println( "</div>");
                // out.println( "</div>");
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
