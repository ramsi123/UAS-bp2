package FinalProjectUAS;

public class cTransaksi {
    String kode;
    String pembeli;
    cBarang barang;
    int jumlahBrg;
    int status;
    cTransaksi next;
    
    //constructor
    cTransaksi(String k, String p, cBarang b, int j, int s) {
        kode = k;
        pembeli = p;
        barang = b;
        jumlahBrg = j;
        status = s;
        next = null;
    }
    
    //setter
    public void setStatus(int s) {
        status = s;
    }
    
    //getter
    public String getKode() {
        return kode;
    }
    public String getPembeli() {
        return pembeli;
    }
    public cBarang getBarang() {
        return barang;
    }
    public int getJumlah() {
        return jumlahBrg;
    }
    public int getStatus() {
        return status;
    }
}
