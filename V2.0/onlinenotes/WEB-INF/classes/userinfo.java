public class userinfo { 
    String name; 
    String email; 
    String password; 
    int id;
    int utype;
    public userinfo(String n, String e, String p,int id) { 
    name = n; 
    email = e; 
    password = p; 
    this.id = id;
   
    } 
    public String getname(){
        return name;
    }
    
    public String getemail(){
        return email;
    }
    
    public int getid(){
        return id;
    }
}
    
    