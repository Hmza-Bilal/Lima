import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.ArrayList;

public class search extends HttpServlet{
	public void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException 
	{
		
		PrintWriter out;
		out = response.getWriter();		
		String title = request.getParameter("title");

		HttpSession session = request.getSession(false);
	
if(session == null){
	out.println("Session not Found");
	RequestDispatcher rd = request.getRequestDispatcher("login.html");
	rd.include(request, response);

}
else{
		notesDAO notesdao = new notesDAO();
		ArrayList<notesinfo> AL = notesdao.searchnotes(title);

		for(int i = 0 ; i < AL.size() ; i++){
			notesinfo ni = AL.get(i);
			out.println(ni.getTitle());
			out.println(ni.getdescrip());
		}
		
	}
}
}