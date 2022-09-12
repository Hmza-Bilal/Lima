import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.w3c.dom.UserDataHandler;

import java.sql.*;
public class signup extends HttpServlet{
	public void doPost(HttpServletRequest request , HttpServletResponse response) throws IOException 
	{
		
		PrintWriter out;
		out = response.getWriter();		
		String name = request.getParameter("fname");
		String Email = request.getParameter("email");
		String Password = request.getParameter("confpass");


		userDAO userdao = new userDAO();
		int st = userdao.insertUser(name , Email , Password,0);
		
       
    if(st > 0)
			{
			out.println("User Has been Registered");
       
       }
       else
        {
          out.println("<p> Record could not inserted. </p>");
        }
}
}