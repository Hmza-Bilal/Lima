import java.security.AllPermission;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

public class notesDAO {
    Connection con;
    public notesDAO(){
        try{

			Class.forName(  "com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1/onlinenotes";
			con=DriverManager.getConnection(url, "root", "root");
        }
		catch(Exception exp)
		{
            System.out.println(exp);
        }
	}
    public int addnotes(String t , String d, int id){
        int i =0;
        try{
        String query="INSERT into notesdata(Title,descrip,note_id) values(?,?,?)";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, t);
        pst.setString(2, d);
        pst.setInt(3, id);
        i =  pst.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex);
        }
        return i;
    }

    public int deletenotes(String t , String d, int id){
        int i =0;
        try{
        String query="Delete From notesdata where id="+id+"  ";
        Statement st = con.createStatement();
        i =  st.executeUpdate(query);
        }catch(Exception ex){
            System.out.println(ex);
        }
        return i;
    }

    public int updatenotes(String t , String d, int id){
        int i =0;
        try{
        String query="UPDATE notesdata SET Title = ? , descrip = ? where id= ? ";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1,t);
        pst.setString(2,d);
        pst.setInt(3,id);
        i =  pst.executeUpdate();
        con.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
        return i;
    }







public ArrayList<notesinfo> getnotes(int i){
    ArrayList<notesinfo> AL = new ArrayList<notesinfo>();
    try{
        String query ="Select * From notesdata where note_id = "+i+" ";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query); 
        while(rs.next()){

            String title = rs.getString("Title");
            String descrip = rs.getString("descrip");
            int noteid = Integer.parseInt(rs.getString("note_id"));
            int id = Integer.parseInt(rs.getString("id"));

                AL.add(new notesinfo(title,descrip,noteid,id));

        }
    }catch(Exception ex){
        System.out.println(ex);
    }
    return AL;
}

public ArrayList<notesinfo> searchnotes(String t){
    ArrayList<notesinfo> AL = new ArrayList<notesinfo>();
    try{
        String query ="Select * from notesdata where Title = ? ";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, t);
        ResultSet rs = pst.executeQuery(); 
        while(rs.next()){

            String title = rs.getString("Title");
            String descrip = rs.getString("descrip");
            int noteid = Integer.parseInt(rs.getString("note_id"));
            int id = Integer.parseInt(rs.getString("id"));

                AL.add(new notesinfo(title,descrip,noteid,id));

        }
    }catch(Exception ex){
        System.out.println(ex);
    }
    return AL;
}




}