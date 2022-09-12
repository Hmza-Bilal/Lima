public class userinfo { 
    String name; 
    String email; 
    String password; 
    int id;
    int status;

    public userinfo(String n, String e, String p,int id,int s) { 
    name = n; 
    email = e; 
    password = p; 
    this.id = id;
    status = s;
   
    } 
    public userinfo(String n, String e,int id) { 
        name = n; 
        email = e;  
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
    public int getstatus(){
        return status;
    }
}
    
    