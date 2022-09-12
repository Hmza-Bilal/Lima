import java.sql.*;

public class userDAO {
    Connection con;
    public userDAO(){
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
    public int insertUser(String n , String e , String p, int s){
        int i =0;
        try{
        String query="insert into signup(Name,Email,Pass,status ) values(?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, n);
        pst.setString(2, e);
        pst.setString(3, p);
        pst.setInt(4, s);
        i =  pst.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex);
        }
        return i;
    }


public userinfo searchUser(String e , String p){
    userinfo usr = null;
    try{
    String query="Select * from signup where Email = ? and Pass = ?";
    PreparedStatement pst = con.prepareStatement(query);
    pst.setString(1, e);
    pst.setString(2, p);
    ResultSet rs =  pst.executeQuery();
    while(rs.next()){
        String name = rs.getString("Name"); 
		String email = rs.getString("Email"); 
        String password = rs.getString("Pass");
        int id = rs.getInt("id");
        int status = rs.getInt("status");
      

        usr = new userinfo(name,email,password,id,status);

    }
    }catch(Exception ex){
        System.out.println(ex);
    }
    return usr;
}
}

