public class notesinfo { 
    String Title; 
    String descrip;  
    int note_id;
    int id;
    public notesinfo(String t, String d, int nid,int id) { 
    Title = t; 
    descrip = d; 
    note_id = nid;
    this.id = id;
    } 
    public String getTitle(){
        return Title;
    }
    
    public String getdescrip(){
        return descrip;
    }
    
    public int getnote_id(){
        return note_id;
    }
    public int getid(){
        return id;
    }
}
    
