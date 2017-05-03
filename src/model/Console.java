/*
 * Tugas Besar - Pemrograman Berorientasi Objek
 * Muhammad Maulud H. R. | 1301154166
 * M. Widadio Ilham	  | 1301154360
 * Afra W. D.	  | 1301150432
 */
package model;

import java.util.Scanner;
import model.Aplikasi;

/**
 *
 * @author Muhammad Maulud H R
 */
public class Console {

    private Aplikasi model = new Aplikasi();
    //Lakukan koneksi dengan database

    public void menuUtama() {
        System.out.println("Main Menu: "
                + "\n 1. Login as Admin"
                + "\n 2. Login as User"
                + "\n 3. Exit");
    }

    public void pilMenuAdmin() {
        System.out.println("Menu Admin: "
                + "\n 1. Tambah Mahasiswa"
                + "\n 2. Tambah Dosen"
                + "\n 3. Tambah Mata Kuliah"
                + "\n 4. Hapus Mahasiswa"
                + "\n 5. Hapus Dosen"
                + "\n 6. Hapus Mata Kuliah"
                + "\n 7. Cari Mahasiswa"
                + "\n 8. Cari Dosen"
                + "\n 9. Cari Mata Kuliah"
                + "\n 10. Tampilkan Mahasiswa"
                + "\n 11. Tampilkan Dosen"
                + "\n 12. Tampilkan Mata Kuliah"
                + "\n 0. Back");
    }

    public void tambahMahasiswa() {
        Scanner input = new Scanner(System.in);

        System.out.println("Masukan Identitas Mahasiswa: ");
        System.out.print("Nama          : ");
        String nama = input.nextLine();
        System.out.print("NIM           : ");
        String NIM = input.nextLine();
        System.out.print("Tanggal Lahir : ");
        String tgl_lahir = input.nextLine();
        System.out.print("Tempat Lahir  : ");
        String tmpt_lahir = input.nextLine();
        System.out.print("Jenis Kelamin : ");
        String gender = input.nextLine();

        //Searching unique attribute
        model.addMahasiswa(nama, tgl_lahir, tmpt_lahir, gender, NIM);
        //add to Database

        System.out.println("Berhasil memasukan Data!");
    }

    public void tambahDosen() {
        Scanner input = new Scanner(System.in);

        System.out.println("Masukan Identitas Dosen: ");
        System.out.print("Nama          : ");
        String nama = input.nextLine();
        System.out.print("NIP           : ");
        String NIP = input.nextLine();
        System.out.print("Tanggal Lahir : ");
        String tgl_lahir = input.nextLine();
        System.out.print("Tempat Lahir  : ");
        String tmpt_lahir = input.nextLine();
        System.out.print("Jenis Kelamin : ");
        String gender = input.nextLine();

        //Searching unique attribute
        model.addDosen(nama, tgl_lahir, tmpt_lahir, gender, NIP);
        //add to Database

        System.out.println("Berhasil memasukan Data!");
    }

    public void tambahMataKuliah() {
        Scanner input = new Scanner(System.in);

        System.out.println("Masukan Data Mata Kuliah: ");
        System.out.print("Nama          : ");
        String nama_mk = input.nextLine();
        System.out.print("Kode          : ");
        String kode_mk = input.nextLine();

        //Searching unique attribute
        model.addMataKuliah(nama_mk, kode_mk);
        //add to Database

        System.out.println("Berhasil memasukan Data!");

    }

    public void hapusMahasiswa() {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukan NIM     : ");
        String NIM = input.nextLine();

    }

    public void hapusDosen() {
        Scanner input = new Scanner(System.in);

    }

    public void hapusMataKuliah() {
        Scanner input = new Scanner(System.in);

    }

    public void cariMahasiswa() {
        Scanner input = new Scanner(System.in);
        boolean exist = false;

        System.out.print("\nMasukan NIM     : ");
        String NIM = input.nextLine();
        for (Mahasiswa m : model.getDaftarMahasiswa()) {
            if (m.getNIM().equals(NIM)) {
                System.out.println("\nNama        : " + m.getNama());
                exist = true;
            }
        }
        if (exist != true) {
            System.out.println("NIM tersebut tidak terdaftar!");
        }
        System.out.println("");
    }

    public void cariDosen() {
        Scanner input = new Scanner(System.in);
        boolean exist = false;

        System.out.print("\nMasukan NIP   : ");
        String NIP = input.nextLine();
        for (Dosen d : model.getDaftarDosen()) {
            if (d.getNIP().equals(NIP)) {
                System.out.println("\nNama        : " + d.getNama());
                exist = true;
            }
        }
        if (exist != true) {
            System.out.println("NIP tersebut tidak terdaftar!");
        }
        System.out.println("");
    }

    public void cariMataKuliah() {
        Scanner input = new Scanner(System.in);
        boolean exist = false;

        System.out.print("\nMasukan kode matakuliah   : ");
        String kode_mk = input.nextLine();
        for (MataKuliah mk : model.getDaftarMataKuliah()) {
            if (mk.getKodeMK().equals(kode_mk)) {
                System.out.println("\nNama        : " + mk.getNamaMK());
                exist = true;
            }
        }
        if (exist != true) {
            System.out.println("Kode matakuliah tersebut tidak terdaftar!");
        }
        System.out.println("");
    }

    public void tampilMahasiswa() {
        System.out.println("---Data Mahasiswa---\n");
        for (Mahasiswa m : model.getDaftarMahasiswa()) {
            System.out.println("Nama            : " + m.getNama());
            System.out.println("NIM             : " + m.getNIM());
            System.out.println("Jenis Kelamin   : " + m.getGender());
            System.out.println("Tempat Lahir    : " + m.getTmptLahir());
            System.out.println("Tanggal Lahir   : " + m.getTglLahir());
            System.out.println("");
        }
        System.out.println("--------------------");
    }

    public void tampilDosen() {
        System.out.println("---Data Dosen---\n");
        for (Dosen d : model.getDaftarDosen()) {
            System.out.println("Nama            : " + d.getNama());
            System.out.println("NIP             : " + d.getNIP());
            System.out.println("Jenis Kelamin   : " + d.getGender());
            System.out.println("Tempat Lahir    : " + d.getTmptLahir());
            System.out.println("Tanggal Lahir   : " + d.getTglLahir());
            System.out.println("");
        }
        System.out.println("----------------");
    }

    public void tampilMataKuliah() {
        System.out.println("---Data Dosen---\n");
        for (MataKuliah mk : model.getDaftarMataKuliah()) {
            System.out.println("Nama            : " + mk.getNamaMK());
            System.out.println("Kode            : " + mk.getKodeMK());
            System.out.println("");
        }
        System.out.println("----------------");
    }

    public void menuAdmin() {
        boolean back = false;

        do {
            pilMenuAdmin();
            try {
                Scanner input = new Scanner(System.in);
                int opt = input.nextInt();

                switch (opt) {
                    case 1:
                        try {
                            tambahMahasiswa();
                        } catch (Exception e) {
                            System.out.println("Gagal menambahkan mahasiswa");
                        }
                        break;
                    case 2:
                        try {
                            tambahDosen();
                        } catch (Exception e) {
                            System.out.println("Gagal menambahkan dosen");
                        }
                        break;
                    case 3:
                        try {
                            tambahMataKuliah();
                        } catch (Exception e) {
                            System.out.println("Gagal menambahkan matakuliah");
                        }
                        break;
                    case 4:
                        try {
                            hapusMahasiswa();
                        } catch (Exception e) {
                            System.out.println("Gagal menghapus mahasiswa");
                        }
                        break;
                    case 5:
                        try {
                            hapusDosen();
                        } catch (Exception e) {
                            System.out.println("Gagal menghapus dosen");
                        }
                        break;
                    case 6:
                        try {
                            hapusMataKuliah();
                        } catch (Exception e) {
                            System.out.println("Gagal menghapus matakuliah");
                        }
                        break;
                    case 7:
                        try {
                            cariMahasiswa();
                        } catch (Exception e) {
                            System.out.println("Gagal mencari mahasiswa");
                        }
                        break;
                    case 8:
                        try {
                            cariDosen();
                        } catch (Exception e) {
                            System.out.println("Gagal mencari dosen");
                        }
                        break;
                    case 9:
                        try {
                            cariMataKuliah();
                        } catch (Exception e) {
                            System.out.println("Gagal mencari matakuliah");
                        }
                        break;
                    case 10:
                        try {
                            tampilMahasiswa();
                        } catch (Exception e) {
                            System.out.println("Gagal menampilkan mahasiswa");
                        }
                        break;
                    case 11:
                        try {
                            tampilDosen();
                        } catch (Exception e) {
                            System.out.println("Gagal menampilkan dosen");
                        }
                        break;
                    case 12:
                        try {
                            tampilMataKuliah();
                        } catch (Exception e) {
                            System.out.println("Gagal menampilkan matakuliah");
                        }
                        break;
                    case 0:
                        back = true;
                        break;
                    default:
                        System.out.println("Tolong inputannya yaa~");
                }
            } catch (Exception e) {
                System.out.println("Input Error!");
            }
        } while (back == false);
    }

    public void pilMenuUser() {
        System.out.println("Menu User: "
                + "\n 1. Tipe User Dosen"
                + "\n 2. Tipe User Mahasiswa"
                + "\n 0. Back");
    }
    
    public void pilMenuDosen() {
        System.out.println("Menu Dosen: "
                + "\n 1. Tambah Kelas"
                + "\n 2. Tambah Tugas"
                + "\n 3. Hapus Kelas"
                + "\n 4. Hapus Tugas"
                + "\n 5. Cari Kelas"
                + "\n 6. Cari Tugas"
                + "\n 7. Back");
    }

    public void pilMenuMahasiswa() {
        System.out.println("Menu Mahasiswa: "
                + "\n 1. Lihat Daftar Kelas"
                + "\n 2. Mendaftar ke Kelas"
                + "\n 3. Lihat Daftar Tugas"
                + "\n 0. Back");
    }
    
    public void menuUser() {
        boolean back = false;

        do {
            pilMenuUser();
            try {
                Scanner input = new Scanner(System.in);
                int opt = input.nextInt();

                switch (opt) {
                    case 1:
                        pilMenuDosen();
                        break;
                    case 2:
                        pilMenuMahasiswa();
                        break;
                    case 0:
                        back = true;
                        break;
                    default:
                        System.out.println("Inputan salah!");
                }
            } catch (Exception e) {
                System.out.println("Terjadi error");
            }
        } while (back == false);

    }
}