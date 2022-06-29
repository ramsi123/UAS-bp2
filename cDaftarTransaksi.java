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
    public void adminLihatTransaksi() {
        int i = 1, transaksiBelum = 0, transaksiSudah = 0;
        System.out.println("\nDaftar Transaksi");
        System.out.println("no\tkode\tpembeli\t\tbarang\t\tkuantitas\tstatus");
        for (cTransaksi t = front; t != null; t = t.next) {
            if (t.getStatus() == 0) {
                transaksiBelum++;
            } else {
                transaksiSudah++;
            }
            
            System.out.print(i + "\t");
            System.out.print(t.getKode() + "\t");
            System.out.print(t.getPembeli() + "\t\t");
            System.out.print(t.getBarang().getNama() + "\t");
            System.out.print(t.getJumlah() + "\t\t");
            System.out.println(t.getStatus());
            i++;
        }
        System.out.println("Transaksi belum diproses : " + transaksiBelum);
        System.out.println("Transaksi sudah diproses : " + transaksiSudah);
    }
    public void lihatTransaksi() {
        int i = 1;
        boolean member = false;
        double total = 0, diskon;
        cTransaksi t = front;
        if (t.getPembeli().equalsIgnoreCase("10") || t.getPembeli().equalsIgnoreCase("11") || t.getPembeli().equalsIgnoreCase("12")) {
            member = true;
        } else {
            //null
        }
        
        System.out.println("\nDaftar Transaksi");
        System.out.println("no\tkode\tpembeli\t\tbarang\t\tkuantitas\tstatus");
        for (; t != null; t = t.next) {
            System.out.print(i + "\t");
            System.out.print(t.getKode() + "\t");
            System.out.print(t.getPembeli() + "\t\t");
            System.out.print(t.getBarang().getNama() + "\t");
            System.out.print(t.getJumlah() + "\t\t");
            System.out.println(t.getStatus());
            i++;
            total = total + t.getBarang().getHarga() * t.getJumlah();
        }
        
        if (member == true) {
            System.out.println("Total Belanja   : " + Math.round(total));
            System.out.println("Diskon          : " + Math.round((0.05 * total)));
            System.out.println("Jumlah Dibayar  : " + Math.round((total - (0.05 * total))));
        } else {
            System.out.println("Total Belanja   : " + Math.round(total));
            System.out.println("Diskon          : " + Math.round((0 * total)));
            System.out.println("Jumlah Dibayar  : " + Math.round((total - (0 * total))));
        }
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
                    nominal = nominal + (t.getBarang().getHarga() * t.getJumlah() - (t.getBarang().getHarga() * t.getJumlah() * 0.05));
                } else {
                    nominal = nominal + t.getBarang().getHarga() * t.getJumlah();
                }
            }
        }
        
        return nominal;
    }
    public void lihatPenjualanHarianBarang() {
        double brg1 = 0, brg2 = 0, brg3 = 0, brg4 = 0, brg5 = 0;
        for (cTransaksi t = front; t != null; t = t.next) {
            if (t.getStatus() == 1) {
                if (t.getBarang().getNama().equalsIgnoreCase("Nasi Bungkus")) {
                    if (t.getPembeli().equalsIgnoreCase("10") || t.getPembeli().equalsIgnoreCase("11") || t.getPembeli().equalsIgnoreCase("12")) {
                        brg1 = brg1 + (t.getBarang().getHarga() * t.getJumlah() - (t.getBarang().getHarga() * t.getJumlah() * 0.05));
                    } else {
                        brg1 = brg1 + t.getBarang().getHarga() * t.getJumlah();
                    }
                } else if (t.getBarang().getNama().equalsIgnoreCase("Mie Goreng")) {
                    if (t.getPembeli().equalsIgnoreCase("10") || t.getPembeli().equalsIgnoreCase("11") || t.getPembeli().equalsIgnoreCase("12")) {
                        brg2 = brg2 + (t.getBarang().getHarga() * t.getJumlah() - (t.getBarang().getHarga() * t.getJumlah() * 0.05));
                    } else {
                        brg2 = brg2 + t.getBarang().getHarga() * t.getJumlah();
                    }
                } else if (t.getBarang().getNama().equalsIgnoreCase("Sosis Bakar")) {
                    if (t.getPembeli().equalsIgnoreCase("10") || t.getPembeli().equalsIgnoreCase("11") || t.getPembeli().equalsIgnoreCase("12")) {
                        brg3 = brg3 + (t.getBarang().getHarga() * t.getJumlah() - (t.getBarang().getHarga() * t.getJumlah() * 0.05));
                    } else {
                        brg3 = brg3 + t.getBarang().getHarga() * t.getJumlah();
                    }
                } else if (t.getBarang().getNama().equalsIgnoreCase("Teh Hangat")) {
                    if (t.getPembeli().equalsIgnoreCase("10") || t.getPembeli().equalsIgnoreCase("11") || t.getPembeli().equalsIgnoreCase("12")) {
                        brg4 = brg4 + (t.getBarang().getHarga() * t.getJumlah() - (t.getBarang().getHarga() * t.getJumlah() * 0.05));
                    } else {
                        brg4 = brg4 + t.getBarang().getHarga() * t.getJumlah();
                    }
                } else if (t.getBarang().getNama().equalsIgnoreCase("Kopi Hitam")) {
                    if (t.getPembeli().equalsIgnoreCase("10") || t.getPembeli().equalsIgnoreCase("11") || t.getPembeli().equalsIgnoreCase("12")) {
                        brg5 = brg5 + (t.getBarang().getHarga() * t.getJumlah() - (t.getBarang().getHarga() * t.getJumlah() * 0.05));
                    } else {
                        brg5 = brg5 + t.getBarang().getHarga() * t.getJumlah();
                    }
                }
            }
        }
        
        //print daftar penjualan harian barang
        System.out.println("1. " + "Nasi Bungkus : " + Math.round(brg1));
        System.out.println("2. " + "Mie Goreng   : " + Math.round(brg2));
        System.out.println("3. " + "Sosis Bakar  : " + Math.round(brg3));
        System.out.println("4. " + "Teh Hangat   : " + Math.round(brg4));
        System.out.println("5. " + "Kopi Hitam   : " + Math.round(brg5));
    }
    public void lihatTotalBelanjaMember() {
        double totalID10 = 0, totalID11 = 0, totalID12 = 0;
        for (cTransaksi t = front; t != null; t = t.next) {
            if (t.getPembeli().equalsIgnoreCase("10")) {
                totalID10 = totalID10 + (t.getBarang().getHarga() * t.getJumlah() - (t.getBarang().getHarga() * t.getJumlah() * 0.05));
            } else if (t.getPembeli().equalsIgnoreCase("11")) {
                totalID11 = totalID11 + (t.getBarang().getHarga() * t.getJumlah() - (t.getBarang().getHarga() * t.getJumlah() * 0.05));
            } else if (t.getPembeli().equalsIgnoreCase("12")) {
                totalID12 = totalID12 + (t.getBarang().getHarga() * t.getJumlah() - (t.getBarang().getHarga() * t.getJumlah() * 0.05));
            }
        }
        
        System.out.println("1. Budi : " + Math.round(totalID10));
        System.out.println("2. Aji  : " + Math.round(totalID11));
        System.out.println("3. Iwan : " + Math.round(totalID12));
    }
    public void lihatGrafikPenjualan() {
        double brg1 = 0, brg2 = 0, brg3 = 0, brg4 = 0, brg5 = 0;
        for (cTransaksi t = front; t != null; t = t.next) {
            if (t.getStatus() == 1) {
                if (t.getBarang().getNama().equalsIgnoreCase("Nasi Bungkus")) {
                    if (t.getPembeli().equalsIgnoreCase("10") || t.getPembeli().equalsIgnoreCase("11") || t.getPembeli().equalsIgnoreCase("12")) {
                        brg1 = brg1 + (t.getBarang().getHarga() * t.getJumlah() - (t.getBarang().getHarga() * t.getJumlah() * 0.05));
                    } else {
                        brg1 = brg1 + t.getBarang().getHarga() * t.getJumlah();
                    }
                } else if (t.getBarang().getNama().equalsIgnoreCase("Mie Goreng")) {
                    if (t.getPembeli().equalsIgnoreCase("10") || t.getPembeli().equalsIgnoreCase("11") || t.getPembeli().equalsIgnoreCase("12")) {
                        brg2 = brg2 + (t.getBarang().getHarga() * t.getJumlah() - (t.getBarang().getHarga() * t.getJumlah() * 0.05));
                    } else {
                        brg2 = brg2 + t.getBarang().getHarga() * t.getJumlah();
                    }
                } else if (t.getBarang().getNama().equalsIgnoreCase("Sosis Bakar")) {
                    if (t.getPembeli().equalsIgnoreCase("10") || t.getPembeli().equalsIgnoreCase("11") || t.getPembeli().equalsIgnoreCase("12")) {
                        brg3 = brg3 + (t.getBarang().getHarga() * t.getJumlah() - (t.getBarang().getHarga() * t.getJumlah() * 0.05));
                    } else {
                        brg3 = brg3 + t.getBarang().getHarga() * t.getJumlah();
                    }
                } else if (t.getBarang().getNama().equalsIgnoreCase("Teh Hangat")) {
                    if (t.getPembeli().equalsIgnoreCase("10") || t.getPembeli().equalsIgnoreCase("11") || t.getPembeli().equalsIgnoreCase("12")) {
                        brg4 = brg4 + (t.getBarang().getHarga() * t.getJumlah() - (t.getBarang().getHarga() * t.getJumlah() * 0.05));
                    } else {
                        brg4 = brg4 + t.getBarang().getHarga() * t.getJumlah();
                    }
                } else if (t.getBarang().getNama().equalsIgnoreCase("Kopi Hitam")) {
                    if (t.getPembeli().equalsIgnoreCase("10") || t.getPembeli().equalsIgnoreCase("11") || t.getPembeli().equalsIgnoreCase("12")) {
                        brg5 = brg5 + (t.getBarang().getHarga() * t.getJumlah() - (t.getBarang().getHarga() * t.getJumlah() * 0.05));
                    } else {
                        brg5 = brg5 + t.getBarang().getHarga() * t.getJumlah();
                    }
                }
            }
        }
        
        int grafikBrg1 = (int) brg1 - (int) brg1 % 10000;
        int grafikBrg2 = (int) brg2 - (int) brg2 % 10000;
        int grafikBrg3 = (int) brg3 - (int) brg3 % 10000;
        int grafikBrg4 = (int) brg4 - (int) brg4 % 10000;
        int grafikBrg5 = (int) brg5 - (int) brg5 % 10000;
        
        //print grafik penjualan barang
        System.out.print("1. " + "Nasi Bungkus : ");
        for (int i = 0; i < grafikBrg1 / 10000; i++) {
            System.out.print("X");
        }
        System.out.println(" " + grafikBrg1);
        
        System.out.print("2. " + "Mie Goreng   : ");
        for (int i = 0; i < grafikBrg2 / 10000; i++) {
            System.out.print("X");
        }
        System.out.println(" " + grafikBrg2);
        
        System.out.print("3. " + "Sosis Bakar  : ");
        for (int i = 0; i < grafikBrg3 / 10000; i++) {
            System.out.print("X");
        }
        System.out.println(" " + grafikBrg3);
        
        System.out.print("4. " + "Teh Hangat   : ");
        for (int i = 0; i < grafikBrg4 / 10000; i++) {
            System.out.print("X");
        }
        System.out.println(" " + grafikBrg4);
        
        System.out.print("5. " + "Kopi Hitam   : ");
        for (int i = 0; i < grafikBrg5 / 10000; i++) {
            System.out.print("X");
        }
        System.out.println(" " + grafikBrg5);
    }
}
