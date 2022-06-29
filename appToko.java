package FinalProjectUAS;
import java.util.Scanner;

public class appToko {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //daftar barang yg dijual
        cBarang brg1 = new cBarang("Nasi Bungkus", 7000);
        cBarang brg2 = new cBarang("Mie Goreng", 6000);
        cBarang brg3 = new cBarang("Sosis Bakar", 5000);
        cBarang brg4 = new cBarang("Teh Hangat", 3000);
        cBarang brg5 = new cBarang("Kopi Hitam", 4000);
        
        //data member toko
        //cDaftarMember member = new cDaftarMember();
        String nama1 = "Budi", nama2 = "Aji", nama3 = "Iwan";
        int id1 = 10, id2 = 11, id3 = 12;
        int pwd1 = 111, pwd2 = 222, pwd3 = 333;
        int id, pin;
        
        //daftar antrian transaksi yg masuk ke toko
        cDaftarTransaksi jual = new cDaftarTransaksi();
        int pilih = 0, pilih2 = 0, pilih3 = 0;
        int kode = 100, jumlah;
        
        //data admin dan pemilik
        int passAdmin = 123;
        int passPemilik = 456;
        
        do {
            System.out.println("\nAplikasi Warung Angkringan Jenggolo");
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
                    sc = new Scanner(System.in);
                    String nama = sc.nextLine();
                    
                    //pengecekan nama pembeli
                    boolean valid = false;
                    do {
                        if (nama.equalsIgnoreCase(nama1) || nama.equalsIgnoreCase(nama2) || nama.equalsIgnoreCase(nama3)) {
                            System.out.print("Pembeli telah terdaftar sebagai member. ");
                            System.out.println("Silahkan masuk ke pilihan anggota!");
                            break;
                        } else {
                            valid = true;
                        }
                    } while (valid == false);
                    
                    if (valid == false) {
                        break;
                    }
                    
                    //menu pembeli
                    do {
                        System.out.println("\nAkun Pembeli");
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
                                System.out.println("1. Nasi Bungkus [" + brg1.getHarga() + "]");
                                System.out.println("2. Mie Goreng   [" + brg2.getHarga() + "]");
                                System.out.println("3. Sosis Bakar  [" + brg3.getHarga() + "]");
                                System.out.println("4. Teh Hangat   [" + brg4.getHarga() + "]");
                                System.out.println("5. Kopi Hitam   [" + brg5.getHarga() + "]");
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
                                } else if (pilih3 == 4) {
                                    br = new cTransaksi(String.valueOf(kode), nama, brg4, jumlah, 0);
                                } else if (pilih3 == 5) {
                                    br = new cTransaksi(String.valueOf(kode), nama, brg5, jumlah, 0);
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
                    valid = false;
                    do {
                        System.out.print("ID = ");
                        id = sc.nextInt();
                        System.out.print("PIN = ");
                        pin = sc.nextInt();
                        
                        if (id == id1 && pin == pwd1) {
                            valid = true;
                        } else if (id == id2 && pin == pwd2) {
                            valid = true;
                        } else if (id == id3 && pin == pwd3) {
                            valid = true;
                        } else {
                            System.out.println("Akun tidak ditemukan!");
                        }
                    } while (valid == false);
                    
                    if (valid == true) {
                        System.out.println("1. Membuat Transaksi");
                        System.out.println("2. Ubah Password");
                        System.out.print("Pilih = ");
                        pilih2 = sc.nextInt();
                        
                        if (pilih2 == 1) {
                            System.out.println("Selamat Datang..");
                            kode++;
                            beli = new cDaftarTransaksi();
                            do {
                                System.out.println("\nAkun Member");
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
                                        System.out.println("1. Nasi Bungkus [" + brg1.getHarga() + "]");
                                        System.out.println("2. Mie Goreng   [" + brg2.getHarga() + "]");
                                        System.out.println("3. Sosis Bakar  [" + brg3.getHarga() + "]");
                                        System.out.println("4. Teh Hangat   [" + brg4.getHarga() + "]");
                                        System.out.println("5. Kopi Hitam   [" + brg5.getHarga() + "]");
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
                                        } else if (pilih3 == 4) {
                                            br = new cTransaksi(String.valueOf(kode), String.valueOf(id), brg4, jumlah, 0);
                                        } else if (pilih3 == 5) {
                                            br = new cTransaksi(String.valueOf(kode), String.valueOf(id), brg5, jumlah, 0);
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
                                        beli.lihatTransaksi();
                                        break;
                                    case 4:
                                        //selesai. sambungkan transaksi pembeli
                                        //ke antrian transaksi toko
                                        jual.sambungTransaksi(beli.getFront(), beli.getRear());
                                        System.out.println("Selamat datang kembali..");
                                }
                            } while (pilih2 != 4);
                        } else if (pilih2 == 2) {
                            int passBaru;
                            
                            do {
                                System.out.print("Masukkan Passsword baru = ");
                                passBaru = sc.nextInt();
                                
                                if (passBaru == pin) {
                                    System.out.println("Password sama dengan sebelumnya!");
                                } else {
                                    if (id == id1) {
                                        pwd1 = passBaru;
                                    } else if (id == id2) {
                                        pwd2 = passBaru;
                                    } else if (id == id3) {
                                        pwd3 = passBaru;
                                    }
                                    System.out.println("Password berhasil diganti..");
                                }
                            } while (passBaru == pin);
                        }
                    }
                    break;
                case 3:
                    //admin
                    System.out.print("Password = ");
                    int pass = sc.nextInt();
                    
                    if (pass == passAdmin) {
                        System.out.println("\nAkun Admin");
                        jual.adminLihatTransaksi();
                        //memproses tiap transaksi yg belum diproses
                        cTransaksi t = jual.getFront();
                        do {
                            if (t.getStatus() == 0) {
                                System.out.println("\nKode    : " + t.getKode());
                                System.out.println("Pembeli : " + t.getPembeli());
                                System.out.println("Barang  : " + t.getBarang().getNama());
                                System.out.println("Jumlah  : " + t.getJumlah());
                                System.out.println("\n-Pilih Aksi-");
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
                    } else {
                        System.out.println("Password salah!");
                    }
                    
                    /*System.out.println("1. Pengelolaan Member");
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
                    }*/
                    break;
                case 4:
                    //pemilik
                    System.out.print("Password = ");
                    pass = sc.nextInt();
                    
                    if (pass == passPemilik) {
                        do {
                            System.out.println("\nAkun Pemilik");
                            System.out.println("1. Laporan Penjualan Warung Angkringan Jenggolo");
                            System.out.println("2. Total Nilai Penjualan Harian Barang");
                            System.out.println("3. Total Belanja Member");
                            System.out.println("4. Lihat Grafik Penjualan");
                            System.out.println("5. Ubah Harga Barang");
                            System.out.println("6. Kembali");
                            System.out.print("Pilih = ");
                            pilih2 = sc.nextInt();

                            if (pilih2 == 1) {
                                System.out.println("Akun Pemilik");
                                System.out.println("Transaksi sudah diproses : " + jual.lihatDiproses());
                                System.out.println("Transaksi belum diproses : " + jual.lihatBelumDiproses());
                                System.out.println("Pemasukan : " + Math.round(jual.lihatPemasukan()));
                            } else if (pilih2 == 2) {
                                System.out.println("Total Pendapatan : " + Math.round(jual.lihatPemasukan()));
                                jual.lihatPenjualanHarianBarang();
                            } else if (pilih2 == 3) {
                                System.out.println("Total Belanja Member");
                                jual.lihatTotalBelanjaMember();
                            } else if (pilih2 == 4) {
                                System.out.println("Grafik Penjualan Warung Angkringan");
                                jual.lihatGrafikPenjualan();
                            } else if (pilih2 == 5) {
                                System.out.println("Daftar Barang:");
                                System.out.println("1. Nasi Bungkus [" + brg1.getHarga() + "]");
                                System.out.println("2. Mie Goreng   [" + brg2.getHarga() + "]");
                                System.out.println("3. Sosis Bakar  [" + brg3.getHarga() + "]");
                                System.out.println("4. Teh Hangat   [" + brg4.getHarga() + "]");
                                System.out.println("5. Kopi Hitam   [" + brg5.getHarga() + "]");
                                System.out.print("Pilih  = ");
                                pilih3 = sc.nextInt();

                                System.out.print("Masukkan harga baru = ");
                                int hargaBaru = sc.nextInt();

                                if (pilih3 == 1) {
                                    brg1.setHarga(hargaBaru); 
                                } else if (pilih3 == 2) {
                                    brg2.setHarga(hargaBaru); 
                                } else if (pilih3 == 3) {
                                    brg3.setHarga(hargaBaru); 
                                } else if (pilih3 == 4) {
                                    brg4.setHarga(hargaBaru); 
                                } else if (pilih3 == 5) {
                                    brg5.setHarga(hargaBaru); 
                                }
                                System.out.println("Pengubahan harga berhasil..");
                            } else if (pilih2 == 6) {
                                //null
                            }
                        } while (pilih2 != 6);
                    } else {
                        System.out.println("Password salah!");
                    }
                    break;
                case 5:
                    System.out.println("Terima kasih..");
            }
        } while (pilih != 5);
    }
}
