package FinalProjectUAS;

public class cMember {
    int id, pwd;
    cMember next;
    
    //constructor
    cMember(int i, int p) {
        id = i;
        pwd = p;
        next = null;
    }
    
    //setter
    public void setId(int i) {
        id = i;
    }
    public void setPwd(int p) {
        pwd = p;
    }
    
    //getter
    public int getId() {
        return id;
    }
    public int getPwd() {
        return pwd;
    }
}
