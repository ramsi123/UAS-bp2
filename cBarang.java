package FinalProjectUAS;

public class cBarang {
    String nama;
    int harga;
    
    //constructor
    cBarang(String n, int h) {
        nama = n;
        harga = h;
    }
    
    //setter
    public void setHarga(int h) {
        harga = h;
    }
    
    //getter
    public String getNama() {
        return nama;
    }
    public int getHarga() {
        return harga;
    }
}
