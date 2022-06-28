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
        int i = 1, transaksiBelum = 0, transaksiSudah = 0;
        System.out.println("Daftar Transaksi:");
        System.out.println("no\tkode\tpembeli\tbarang\tkuantitas\tstatus");
        for (cTransaksi t = front; t != null; t = t.next) {
            if (t.getStatus() == 0) {
                transaksiBelum++;
            } else {
                transaksiSudah++;
            }
            
            System.out.print(i + "\t");
            System.out.print(t.getKode() + "\t");
            System.out.print(t.getPembeli() + "\t");
            System.out.print(t.getBarang().getNama() + "\t");
            System.out.print(t.getJumlah() + "\t\t");
            System.out.println(t.getStatus());
            i++;
        }
        System.out.println("Transaksi belum diproses : " + transaksiBelum);
        System.out.println("Transaksi sudah diproses : " + transaksiSudah);
    }
    public void lihatTransaksiMember() {
        int i = 1;
        double total = 0, diskon;
        System.out.println("Daftar Transaksi Member:");
        System.out.println("no\tkode\tpembeli\tbarang\tkuantitas\tstatus");
        for (cTransaksi t = front; t != null; t = t.next) {
            System.out.print(i + "\t");
            System.out.print(t.getKode() + "\t");
            System.out.print(t.getPembeli() + "\t");
            System.out.print(t.getBarang().getNama() + "\t");
            System.out.print(t.getJumlah() + "\t\t");
            System.out.println(t.getStatus());
            i++;
            total = total + t.getBarang().getHarga() * t.getJumlah();
        }
        
        System.out.println("Total Belanja   : " + Math.round(total));
        System.out.println("Diskon          : " + Math.round((0.1 * total)));
        System.out.println("Jumlah Dibayar  : " + Math.round((total - (0.1 * total))));
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
    public int lihatBelumDiproses() {
        int blmProses = 0;
        for (cTransaksi t = front; t != null; t = t.next) {
            if (t.getStatus() == 0) {
                blmProses++;
            }
        }
        return blmProses;
    }
    public double lihatPemasukan() {
        cTransaksi t = front;
        double nominal = 0;
        for (; t != null; t = t.next) {
            if (t.getStatus() == 1) {
                //cek member berdasarkan data kode/nama pembeli
                if (t.getPembeli().equalsIgnoreCase("10") || t.getPembeli().equalsIgnoreCase("11") || t.getPembeli().equalsIgnoreCase("12")) {
                    nominal = nominal + (t.getBarang().getHarga() * t.getJumlah() - (t.getBarang().getHarga() * t.getJumlah() * 0.1));
                } else {
                    nominal = nominal + t.getBarang().getHarga() * t.getJumlah();
                }
            }
        }
        
        return nominal;
    }
    public void lihatPenjualanHarianBarang() {
        double hargaTas = 0, hargaSandal = 0, hargaSepatu = 0, hargaBaju = 0, hargaTopi = 0;
        for (cTransaksi t = front; t != null; t = t.next) {
            if (t.getStatus() == 1) {
                if (t.getBarang().getNama().equalsIgnoreCase("Tas")) {
                    if (t.getPembeli().equalsIgnoreCase("10") || t.getPembeli().equalsIgnoreCase("11") || t.getPembeli().equalsIgnoreCase("12")) {
                        hargaTas = hargaTas + (t.getBarang().getHarga() * t.getJumlah() - (t.getBarang().getHarga() * t.getJumlah() * 0.1));
                    } else {
                        hargaTas = hargaTas + t.getBarang().getHarga() * t.getJumlah();
                    }
                } else if (t.getBarang().getNama().equalsIgnoreCase("Sandal")) {
                    if (t.getPembeli().equalsIgnoreCase("10") || t.getPembeli().equalsIgnoreCase("11") || t.getPembeli().equalsIgnoreCase("12")) {
                        hargaSandal = hargaSandal + (t.getBarang().getHarga() * t.getJumlah() - (t.getBarang().getHarga() * t.getJumlah() * 0.1));
                    } else {
                        hargaSandal = hargaSandal + t.getBarang().getHarga() * t.getJumlah();
                    }
                } else if (t.getBarang().getNama().equalsIgnoreCase("Sepatu")) {
                    if (t.getPembeli().equalsIgnoreCase("10") || t.getPembeli().equalsIgnoreCase("11") || t.getPembeli().equalsIgnoreCase("12")) {
                        hargaSepatu = hargaSepatu + (t.getBarang().getHarga() * t.getJumlah() - (t.getBarang().getHarga() * t.getJumlah() * 0.1));
                    } else {
                        hargaSepatu = hargaSepatu + t.getBarang().getHarga() * t.getJumlah();
                    }
                } else if (t.getBarang().getNama().equalsIgnoreCase("Baju")) {
                    if (t.getPembeli().equalsIgnoreCase("10") || t.getPembeli().equalsIgnoreCase("11") || t.getPembeli().equalsIgnoreCase("12")) {
                        hargaBaju = hargaBaju + (t.getBarang().getHarga() * t.getJumlah() - (t.getBarang().getHarga() * t.getJumlah() * 0.1));
                    } else {
                        hargaBaju = hargaBaju + t.getBarang().getHarga() * t.getJumlah();
                    }
                } else if (t.getBarang().getNama().equalsIgnoreCase("Topi")) {
                    if (t.getPembeli().equalsIgnoreCase("10") || t.getPembeli().equalsIgnoreCase("11") || t.getPembeli().equalsIgnoreCase("12")) {
                        hargaTopi = hargaTopi + (t.getBarang().getHarga() * t.getJumlah() - (t.getBarang().getHarga() * t.getJumlah() * 0.1));
                    } else {
                        hargaTopi = hargaTopi + t.getBarang().getHarga() * t.getJumlah();
                    }
                }
            }
        }
        
        //print daftar penjualan harian barang
        System.out.println("1. " + "Tas     : " + Math.round(hargaTas));
        System.out.println("2. " + "Sandal  : " + Math.round(hargaSandal));
        System.out.println("3. " + "Sepatu  : " + Math.round(hargaSepatu));
        System.out.println("4. " + "Baju    : " + Math.round(hargaBaju));
        System.out.println("5. " + "Topi    : " + Math.round(hargaTopi));
    }
    public void lihatTotalBelanjaMember() {
        double totalID10 = 0, totalID11 = 0, totalID12 = 0;
        for (cTransaksi t = front; t != null; t = t.next) {
            if (t.getPembeli().equalsIgnoreCase("10")) {
                totalID10 = totalID10 + (t.getBarang().getHarga() * t.getJumlah() - (t.getBarang().getHarga() * t.getJumlah() * 0.1));
            } else if (t.getPembeli().equalsIgnoreCase("11")) {
                totalID11 = totalID11 + (t.getBarang().getHarga() * t.getJumlah() - (t.getBarang().getHarga() * t.getJumlah() * 0.1));
            } else if (t.getPembeli().equalsIgnoreCase("12")) {
                totalID12 = totalID12 + (t.getBarang().getHarga() * t.getJumlah() - (t.getBarang().getHarga() * t.getJumlah() * 0.1));
            }
        }
        
        System.out.println("1. Budi : " + Math.round(totalID10));
        System.out.println("2. Aji  : " + Math.round(totalID11));
        System.out.println("3. Iwan : " + Math.round(totalID12));
    }
    public void lihatGrafikPenjualan() {
        double hargaTas = 0, hargaSandal = 0, hargaSepatu = 0, hargaBaju = 0, hargaTopi = 0;
        for (cTransaksi t = front; t != null; t = t.next) {
            if (t.getStatus() == 1) {
                if (t.getBarang().getNama().equalsIgnoreCase("Tas")) {
                    if (t.getPembeli().equalsIgnoreCase("10") || t.getPembeli().equalsIgnoreCase("11") || t.getPembeli().equalsIgnoreCase("12")) {
                        hargaTas = hargaTas + (t.getBarang().getHarga() * t.getJumlah() - (t.getBarang().getHarga() * t.getJumlah() * 0.1));
                    } else {
                        hargaTas = hargaTas + t.getBarang().getHarga() * t.getJumlah();
                    }
                } else if (t.getBarang().getNama().equalsIgnoreCase("Sandal")) {
                    if (t.getPembeli().equalsIgnoreCase("10") || t.getPembeli().equalsIgnoreCase("11") || t.getPembeli().equalsIgnoreCase("12")) {
                        hargaSandal = hargaSandal + (t.getBarang().getHarga() * t.getJumlah() - (t.getBarang().getHarga() * t.getJumlah() * 0.1));
                    } else {
                        hargaSandal = hargaSandal + t.getBarang().getHarga() * t.getJumlah();
                    }
                } else if (t.getBarang().getNama().equalsIgnoreCase("Sepatu")) {
                    if (t.getPembeli().equalsIgnoreCase("10") || t.getPembeli().equalsIgnoreCase("11") || t.getPembeli().equalsIgnoreCase("12")) {
                        hargaSepatu = hargaSepatu + (t.getBarang().getHarga() * t.getJumlah() - (t.getBarang().getHarga() * t.getJumlah() * 0.1));
                    } else {
                        hargaSepatu = hargaSepatu + t.getBarang().getHarga() * t.getJumlah();
                    }
                } else if (t.getBarang().getNama().equalsIgnoreCase("Baju")) {
                    if (t.getPembeli().equalsIgnoreCase("10") || t.getPembeli().equalsIgnoreCase("11") || t.getPembeli().equalsIgnoreCase("12")) {
                        hargaBaju = hargaBaju + (t.getBarang().getHarga() * t.getJumlah() - (t.getBarang().getHarga() * t.getJumlah() * 0.1));
                    } else {
                        hargaBaju = hargaBaju + t.getBarang().getHarga() * t.getJumlah();
                    }
                } else if (t.getBarang().getNama().equalsIgnoreCase("Topi")) {
                    if (t.getPembeli().equalsIgnoreCase("10") || t.getPembeli().equalsIgnoreCase("11") || t.getPembeli().equalsIgnoreCase("12")) {
                        hargaTopi = hargaTopi + (t.getBarang().getHarga() * t.getJumlah() - (t.getBarang().getHarga() * t.getJumlah() * 0.1));
                    } else {
                        hargaTopi = hargaTopi + t.getBarang().getHarga() * t.getJumlah();
                    }
                }
            }
        }
        
        int grafikTas = (int) hargaTas - (int) hargaTas % 10000;
        int grafikSandal = (int) hargaSandal - (int) hargaSandal % 10000;
        int grafikSepatu = (int) hargaSepatu - (int) hargaSepatu % 10000;
        int grafikBaju = (int) hargaBaju - (int) hargaBaju % 10000;
        int grafikTopi = (int) hargaTopi - (int) hargaTopi % 10000;
        
        //print grafik penjualan barang
        System.out.print("1. " + "Tas     : ");
        for (int i = 0; i < grafikTas / 10000; i++) {
            System.out.print("X");
        }
        System.out.println(" " + grafikTas);
        
        System.out.print("2. " + "Sandal  : ");
        for (int i = 0; i < grafikSandal / 10000; i++) {
            System.out.print("X");
        }
        System.out.println(" " + grafikSandal);
        
        System.out.print("3. " + "Sepatu  : ");
        for (int i = 0; i < grafikSepatu / 10000; i++) {
            System.out.print("X");
        }
        System.out.println(" " + grafikSepatu);
        
        System.out.print("4. " + "Baju    : ");
        for (int i = 0; i < grafikBaju / 10000; i++) {
            System.out.print("X");
        }
        System.out.println(" " + grafikBaju);
        
        System.out.print("5. " + "Topi    : ");
        for (int i = 0; i < grafikTopi / 10000; i++) {
            System.out.print("X");
        }
        System.out.println(" " + grafikTopi);
    }
}
