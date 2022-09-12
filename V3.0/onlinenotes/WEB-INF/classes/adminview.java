import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.ArrayList;
public class adminview extends HttpServlet{
	
	public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException , ServletException
	{	
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession(false);
		int id = (int)session.getAttribute("id");
			if(session != null && id == 0)
		{
		
	
		int i =(int)session.getAttribute("id");
		try{
			adminDAO admindao = new adminDAO();
			ArrayList<userinfo> user = admindao.getuser();
			out.println("<h1> All Users </h1>");
			out.println(" <button><a href='logout' > Logout</a></button><br>");
     for(int x =0; x<user.size();x++)
			{
				userinfo usr = user.get(x);
                String name = usr.getname();
                String email = usr.getemail();
				//int noteid = n.getnote_id();
				int usr_id = usr.getid();


                out.println("UserName :<br>");
                out.println("<h5>"+name+" </h5> ");
				out.println("Email: <br>");
                out.println("<p>"+email+" </p> ");
                out.println("ID: <br>");
                out.println("<p>"+usr_id+" </p> ");


                out.println(" <button><a href='deleteuser?id="+usr_id+"' > Delete User</a></button><br></br>");
			    out.println(" <button><a href='block?id="+usr_id+"' > Block User</a></button><br></br>");
				
				out.println(" <button><a href='unblock?id="+usr_id+"' > Unblock User</a></button><br></br>");
				

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
		out.println("Seesion Invalid");
		RequestDispatcher rd = request.getRequestDispatcher("login.html");
		rd.include(request,response);
	}            
    
	}

}
