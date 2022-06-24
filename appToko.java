package FinalProjectUAS;
import java.util.Scanner;

public class appToko {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //daftar barang yg dijual
        cBarang brg1 = new cBarang("Tas", 100000);
        cBarang brg2 = new cBarang("Sandal", 50000);
        cBarang brg3 = new cBarang("Sepatu", 150000);
        
        
        //data member toko
        cDaftarMember member = new cDaftarMember();
        int id, pin;
        
        //daftar antrian transaksi yg masuk ke toko
        cDaftarTransaksi jual = new cDaftarTransaksi();
        int pilih = 0, pilih2 = 0, pilih3 = 0;
        int kode = 100, jumlah;
        
        do {
            System.out.println("\nAplikasi Toko Maju Sejahtera");
            System.out.println("1. Pembeli");
            System.out.println("2. Anggota");
            System.out.println("3. Admin");
            System.out.println("4. Pemilik");
            System.out.println("5. Exit");
            System.out.print("Pilih = ");
            pilih = sc.nextInt();
            
            switch (pilih) {
                case 1:
                    //pembeli
                    kode++;
                    cDaftarTransaksi beli = new cDaftarTransaksi();
                    System.out.print("Masukkan nama = ");
                    String nama = sc.next();
                    do {
                        System.out.println("Akun Pembeli");
                        System.out.println("1. Tambah");
                        System.out.println("2. Hapus");
                        System.out.println("3. Lihat");
                        System.out.println("4. Kembali");
                        System.out.print("Pilih = ");
                        pilih2 = sc.nextInt();
                        
                        switch (pilih2) {
                            case 1:
                                //tambah transaksi
                                cTransaksi br = null;
                                System.out.println("Daftar Barang:");
                                System.out.println("1. Tas");
                                System.out.println("2. Sandal");
                                System.out.println("3. Sepatu");
                                System.out.print("Pilih  = ");
                                pilih3 = sc.nextInt();
                                System.out.print("Jumlah = ");
                                jumlah = sc.nextInt();
                                
                                if (pilih3 == 1) {
                                    br = new cTransaksi(String.valueOf(kode), nama, brg1, jumlah, 0);
                                } else if (pilih3 == 2) {
                                    br = new cTransaksi(String.valueOf(kode), nama, brg2, jumlah, 0);
                                } else if (pilih3 == 3) {
                                    br = new cTransaksi(String.valueOf(kode), nama, brg3, jumlah, 0);
                                }
                                beli.tambahTransaksi(br);
                                break;
                            case 2:
                                //hapus transaksi
                                beli.lihatTransaksi();
                                System.out.print("Hapus nomor = ");
                                int hapus = sc.nextInt();
                                beli.hapusTransaksi(hapus);
                                break;
                            case 3:
                                //lihat transaksi
                                beli.lihatTransaksi();
                                break;
                            case 4:
                                //selesai. sambungkan transaksi pembeli
                                //ke antrian transaksi toko
                                jual.sambungTransaksi(beli.getFront(), beli.getRear());
                                System.out.println("Selamat datang kembali..");
                        }
                    } while (pilih2 != 4);
                    break;
                case 2:
                    //anggota
                    boolean valid = false;
                    do {
                        System.out.print("ID = ");
                        id = sc.nextInt();
                        System.out.print("PIN = ");
                        pin = sc.nextInt();
                        valid = member.cekMember(id, pin);
                    } while (valid == false);
                    
                    if (valid == true) {
                        System.out.println("Selamat Datang..");
                        kode++;
                        beli = new cDaftarTransaksi();
                        do {
                            System.out.println("Akun Member");
                            System.out.println("1. Tambah");
                            System.out.println("2. Hapus");
                            System.out.println("3. Lihat");
                            System.out.println("4. Kembali");
                            System.out.print("Pilih = ");
                            pilih2 = sc.nextInt();

                            switch (pilih2) {
                                case 1:
                                    //tambah transaksi
                                    cTransaksi br = null;
                                    System.out.println("Daftar Barang:");
                                    System.out.println("1. Tas");
                                    System.out.println("2. Sandal");
                                    System.out.println("3. Sepatu");
                                    System.out.print("Pilih  = ");
                                    pilih3 = sc.nextInt();
                                    System.out.print("Jumlah = ");
                                    jumlah = sc.nextInt();

                                    if (pilih3 == 1) {
                                        br = new cTransaksi(String.valueOf(kode), String.valueOf(id), brg1, jumlah, 0);
                                    } else if (pilih3 == 2) {
                                        br = new cTransaksi(String.valueOf(kode), String.valueOf(id), brg2, jumlah, 0);
                                    } else if (pilih3 == 3) {
                                        br = new cTransaksi(String.valueOf(kode), String.valueOf(id), brg3, jumlah, 0);
                                    }
                                    beli.tambahTransaksi(br);
                                    break;
                                case 2:
                                    //hapus transaksi
                                    beli.lihatTransaksi();
                                    System.out.print("Hapus nomor = ");
                                    int hapus = sc.nextInt();
                                    beli.hapusTransaksi(hapus);
                                    break;
                                case 3:
                                    //menampilkan daftar belanja dan diskon
                                    beli.lihatTransaksiMember();
                                    break;
                                case 4:
                                    //selesai. sambungkan transaksi pembeli
                                    //ke antrian transaksi toko
                                    jual.sambungTransaksi(beli.getFront(), beli.getRear());
                                    System.out.println("Selamat datang kembali..");
                            }
                        } while (pilih2 != 4);
                    }
                    break;
                case 3:
                    //admin
                    System.out.println("Akun Admin");
                    System.out.println("1. Pengelolaan Member");
                    System.out.println("2. Memproses Pesanan");
                    System.out.print("Pilih = ");
                    int pilih4 = sc.nextInt();
                    if(pilih4 == 1){
                        System.out.println("\nPENGELOLAAN MEMBER");
                        System.out.println("1. Tambah member");
                        System.out.println("2. Hapus member");
                        System.out.print("Pilih = ");
                        int pilih5 = sc.nextInt();
                        
                        if (pilih5 == 1) {
                            System.out.print("Masukkan ID = ");
                            id = sc.nextInt();
                            System.out.print("Masukkan PIN = ");
                            pin = sc.nextInt();
                            cMember baru = new cMember(id, pin);
                            member.tambahMember(baru);
                        } else if (pilih5 == 2) {
                            if (member.rear == null){
                                System.out.println("Daftar Member kosong!");
                            } else {
                                member.lihatMember();
                                System.out.println("\nMASUKKAN ID & PIN YANG INGIN DIHAPUS");
                                System.out.print("ID = ");
                                id = sc.nextInt();
                                System.out.print("PIN = ");
                                pin = sc.nextInt();
                                member.hapusMember(id, pin);
                            }
                        }
                    } else if(pilih4 == 2){
                        jual.lihatTransaksi();
                        //memproses tiap transaksi yg belum diproses
                        cTransaksi t = jual.getFront();
                        do {
                            if (t.getStatus() == 0) {
                                System.out.println("Kode    : " + t.getKode());
                                System.out.println("Pembeli : " + t.getPembeli());
                                System.out.println("Barang  : " + t.getBarang().getNama());
                                System.out.println("Jumlah  : " + t.getJumlah());
                                System.out.println("-Pilih Aksi-");
                                System.out.println("1. Diproses");
                                System.out.println("2. Selesai");
                                System.out.print("Pilih = ");
                                int aksi = sc.nextInt();

                                if (aksi == 1) {
                                    jual.prosesTransaksi(t);
                                    System.out.println("Berhasil diproses..");
                                } else {
                                    break;
                                }
                            }

                            t = t.next;
                        } while (t != null);
                    }
                    
                    break;
                case 4:
                    //pemilik
                    System.out.println("Akun Pemilik");
                    System.out.println("Transaksi Diproses : " + jual.lihatDiproses());
                    System.out.println("Pemasukan : " + jual.lihatPemasukan());
                    break;
                case 5:
                    System.out.println("Terima kasih..");
            }
        } while (pilih != 5);
    }
}
