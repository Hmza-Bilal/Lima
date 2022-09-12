public class admininfo { 
    String email; 
    String password; 
    int id;
    public admininfo(String e, String p ,int id) { 
    email = e; 
    password = p; 
    this.id = id;
   
    } 
    public String getemail(){
        return email;
    }
    
    public int getid(){
        return id;
    }
}
    
    