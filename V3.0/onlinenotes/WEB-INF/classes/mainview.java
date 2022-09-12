import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.ArrayList;
public class mainview extends HttpServlet{
	
	public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException ,ServletException
	{	
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession(false);
		int usr_id = (int)session.getAttribute("id");
			if(session != null && usr_id != 0 )
		{
		
	
		int i =(int)session.getAttribute("id");
		try{
			notesDAO notesdao = new notesDAO();
			ArrayList<notesinfo> notes = notesdao.getnotes(i);
			out.println("<h1> My Notes </h1>");
			out.println("<form action='search' method = 'post' ><input type='text' name='title' /><input type='submit' value='Search'/></form>");
			out.println("<form action='addnotes.html' method = 'post' ><button value='Addnote'> Add Note</button></form><br>");
			out.println(" <button><a href='logout' > Logout</a></button><br>");
     for(int x =0; x<notes.size();x++)
			{
				notesinfo n = notes.get(x);
                String title = n.getTitle();
                String descrip = n.getdescrip();
				//int noteid = n.getnote_id();
				int id = n.getid();


                
				out.println("Title :<br>");
                out.println("<h5>"+title+" </h5> ");
				out.println("Description: <br>");
                out.println("<p>"+descrip+" </p> ");

				
                out.println(" <button><a href='delete?id="+id+"' > Delete</a></button>");
			    out.println(" <button><a href='update.jsp?id="+id+"&title="+title+"&descrip="+descrip+"' > Update</a></button><br>");

                // out.println( "<div class='col-4'>");
                // out.println("<div class='card-body'>");
                // out.println( " <h5 class='card-title'>"+title+"");
                 //out.println( " <p class='card-text'>"+descrip+"</p>");
                // out.println( "<a href='#' class='tn btn-primary'> Delete </a>");
                // out.println(    "<a href='#' class='tn btn-primary'> Update </a>");
                // // out.println(     "  <a href='#' class='btn btn-primaryv> Update </a>");
                // out.println(   "</div>");
                // out.println( "</div>");
            // //out.println( "</div>");
		}
       
            
      
    }
		catch(Exception exp)
		{
		 out = response.getWriter();

		 out.println("<p> "+exp+" </p>");
		}
		out.close(); 
	}
	else{
		out.println("Please Login As User First");
		RequestDispatcher rd = request.getRequestDispatcher("login.html");
		rd.include(request,response);
	}
            
          
    
	}

}
