import java.sql.*;
import java.util.ArrayList;

public class adminDAO {
    Connection con;
    public adminDAO(){
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

public admininfo searchadmin(String e , String p){
    admininfo admin = null;
    try{
    String query="Select * from admin where email = ? and password = ?";
    PreparedStatement pst = con.prepareStatement(query);
    pst.setString(1, e);
    pst.setString(2, p);
    ResultSet rs =  pst.executeQuery();
    while(rs.next()){
        String email = rs.getString("email"); 
		 
        String password = rs.getString("password");
        int id = rs.getInt("id");
        admin = new admininfo(email,password,id);

    }
    }catch(Exception ex){
        System.out.println(ex);
    }
    return admin;
}


public ArrayList<userinfo> getuser(){
    ArrayList<userinfo> AL = new ArrayList<userinfo>();
    try{
        String query ="Select * From signup";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query); 
        while(rs.next()){

            String name = rs.getString("Name");
            String email = rs.getString("Email");
            int id = Integer.parseInt(rs.getString("id"));

                AL.add(new userinfo(name,email,id));

        }
    }catch(Exception ex){
        System.out.println(ex);
    }
    return AL;
}

public int deleteuser(String n , String e, int id){
    int i =0;
    try{
    String query1= "Delete from notesdata where note_id = "+id+" ";
    String query2="Delete From signup where id="+id+"  ";
    Statement st = con.createStatement();
    i = st.executeUpdate(query1);
    i =  st.executeUpdate(query2);
    }catch(Exception ex){
        System.out.println(ex);
    }
    
    return i;
}

public int blockuser(int id){
    int i =0;
    try{
    String query="update signup set status = 1 where id="+id+"  ";
    Statement st = con.createStatement();
    i = st.executeUpdate(query);
    }catch(Exception ex){
        System.out.println(ex);
    }
    
    return i;
}

public int unblockuser(int id){
    int i =0;
    try{
    String query="update signup set status = 0 where id="+id+"  ";
    Statement st = con.createStatement();
    i = st.executeUpdate(query);
    }catch(Exception ex){
        System.out.println(ex);
    }
    
    return i;
}










}