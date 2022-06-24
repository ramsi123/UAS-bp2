package FinalProjectUAS;

public class cDaftarTransaksi {
    cTransaksi front, rear;
    int jumlah;
    
    //constructor
    cDaftarTransaksi() {
        front = rear = null;
        jumlah = 0;
    }
    
    //getter
    public cTransaksi getFront() {
        return front;
    }
    public cTransaksi getRear() {
        return rear;
    }
    
    //custom method
    public void tambahTransaksi(cTransaksi baru) {
        if (rear == null) {
            front = rear = baru;
        } else {
            rear.next = baru;
            rear = baru;
        }
        
        System.out.println("Penambahan sukses..");
    }
    public void lihatTransaksi() {
        int i = 1;
        System.out.println("Daftar Transaksi:");
        for (cTransaksi t = front; t != null; t = t.next) {
            System.out.print(i + ". ");
            System.out.print(t.getKode() + " - ");
            System.out.print(t.getPembeli() + " - ");
            System.out.print(t.getBarang().getNama() + " - ");
            System.out.print(t.getJumlah() + " - ");
            System.out.println(t.getStatus());
            i++;
        }
    }
    public void lihatTransaksiMember() {
        int i = 1;
        double total = 0, diskon;
        System.out.println("Daftar Transaksi Member:");
        for (cTransaksi t = front; t != null; t = t.next) {
            System.out.print(i + ". ");
            System.out.print(t.getKode() + " - ");
            System.out.print(t.getPembeli() + " - ");
            System.out.print(t.getBarang().getNama() + " - ");
            System.out.print(t.getJumlah() + " - ");
            System.out.println(t.getStatus());
            i++;
            total = total + t.getBarang().getHarga() * t.getJumlah();
        }
        
        System.out.println("Total Belanja   : " + total);
        System.out.println("Diskon          : " + (0.1 * total));
        System.out.println("Jumlah Dibayar  : " + (total - (0.1 * total)));
    }
    public void hapusTransaksi(int nomor) {
        cTransaksi t = front;
        cTransaksi prev = null;
        boolean ketemu = false;
        int i = 1;
        if (nomor == 1) {   //hapus posisi terdepan
            if (t.next == null) {
                front = rear = null;
            } else {
                front = front.next;
                t.next = null;
            }
            
            System.out.println("[" + t.getBarang().getNama() + "] dihapus..");
        } else {
            for (; t != null; t = t.next) {
                if (i == nomor) {
                    ketemu = true;
                    break;
                }
                
                i++;
                prev = t;
            }
            
            if (ketemu == true) {
                if (t.next == null) {   //yg dihapus di ujung belakang
                    rear = prev;
                    rear.next = null;
                } else {                //yg dihapus di tengah2
                    prev.next = t.next;
                    t.next = null;
                }
                
                System.out.println("[" + t.getBarang().getNama() + "] dihapus..");
            } else {
                System.out.println("Barang tidak ada!");
            }
        }
    }
    public void sambungTransaksi(cTransaksi depan, cTransaksi belakang) {
        if (rear == null) { //transaksi toko masih kosong
            front = depan;
            rear = belakang;
        } else {            //transaksi toko sudah terisi
            rear.next = depan;
            rear = belakang;
        }
    }
    public void prosesTransaksi(cTransaksi t) {
        t.setStatus(1);
    }
    public void prosesTransaksiMember(cTransaksi t) {
        //mendapatkan diskon
        //hanya contoh, jika ingin menambahkan methode baru untuk memproses pembelian member
    }
    public int lihatDiproses() {
        cTransaksi t = front;
        int proses = 0;
        for (; t != null; t = t.next) {
            if (t.getStatus() == 1) {
                proses++;
            }
        }
        
        return proses;
    }
    public double lihatPemasukan() {
        cTransaksi t = front;
        double nominal = 0;
        for (; t != null; t = t.next) {
            if (t.getStatus() == 1) {
                //cek member berdasarkan data kode/nama pembeli
                //nominal = nominal + t.getBarang().getHarga() * t.getJumlah();
                if (t.getPembeli().equalsIgnoreCase("10") || t.getPembeli().equalsIgnoreCase("11") || t.getPembeli().equalsIgnoreCase("12")) {
                    nominal = nominal + (t.getBarang().getHarga() * t.getJumlah() - (t.getBarang().getHarga() * t.getJumlah() * 0.1));
                } else {
                    nominal = nominal + t.getBarang().getHarga() * t.getJumlah();
                }
            }
        }
        
        return nominal;
    }
}
