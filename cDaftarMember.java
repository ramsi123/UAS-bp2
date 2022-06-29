package FinalProjectUAS;

public class cDaftarMember {
    cMember front, rear;
    int jumlah;
    
    //constructor
    cDaftarMember() {
        front = rear = null;
        jumlah = 0;
    }
    
    public void tambahMember(cMember baru) {
        if (rear == null) {
            front = rear = baru;
        } else {
            rear.next = baru;
            rear = baru;
        }
        
        jumlah++;
    }
    public void hapusMember(int id, int pwd) {
        cMember t = front;
        cMember prev = null;
        boolean ketemu = false;
        
        if (id == t.getId() && rear.next == null) {  //jika hapus posisi depan
            if (t.next == null) {
                front = rear = null;
            } else {
                front = front.next;
                t.next = null;
            }
            
             System.out.println("ID [" + t.getId() + "] dihapus..");
        } else {    //hapus di tengah atau belakang
            for (; t != null; t = t.next) {
                if (id == t.getId()) {
                    ketemu = true;
                    break;
                }
                prev = t;
            }
            
            if (ketemu == true) {
                if(t.next == null){
                    prev.next = null;
                    rear = prev;
                } else {
                    prev.next = t.next;
                    t = null;
                }
                System.out.println("ID [" + t.getId() + "] dihapus..");
            } else {
                System.out.println("Member tidak ada!");
            }
        }
    }
    public void lihatMember() {
        int i = 1;
        System.out.println("DAFTAR MEMBER");
        for (cMember t = front; t != null; t = t.next) {
            System.out.println(i + ". " + "ID : " + t.getId() + "\tPIN : " + t.getPwd());
            i++;
        }
    }
    public boolean cekMember(int id, int pwd) {
        boolean ada = false;
        for (cMember t = front; t != null; t = t.next) {
            if(id == t.getId() && pwd == t.getPwd()){
                ada = true;
            } else {
                System.out.println("ID atau PIN salah!");
            }
        }
        return ada;
    }
}
