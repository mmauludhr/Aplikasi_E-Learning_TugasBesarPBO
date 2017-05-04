/*
 * Tugas Besar - Pemrograman Berorientasi Objek
 * Muhammad Maulud H. R. | 1301154166
 * M. Widadio Ilham	  | 1301154360
 * Afra W. D.	  | 1301150432
 */
package model;

import database.Database;
import java.util.Scanner;
import model.Aplikasi;

/**
 *
 * @author Muhammad Maulud H R
 */
public class Console {

    Database db;
    private Aplikasi model;// = new Aplikasi(d);
    private Dosen currentDosen;
    private Mahasiswa currentMahasiswa;
    private boolean aksesDosen = false;
    private boolean aksesMahasiswa = false;
    
    //Lakukan koneksi dengan database
    
    public Console(Database db){
        this.db = db;
        model = new Aplikasi(db);
        
    }

    public void menuUtama() {
        System.out.println("Main Menu: "
                + "\n 1. Login as Admin"
                + "\n 2. Login as User"
                + "\n 0. Exit");
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
//        boolean uniqueNIM = false;
        boolean uniqueUsername = false;

        System.out.println("Masukan Identitas Mahasiswa: ");
        System.out.print("NIM           : ");
        String NIM = input.nextLine();

        //Searching unique attribute
        if (model.isNIMMahasiswaExist(NIM) == false) {
//            uniqueNIM = true;
            System.out.print("Nama          : ");
            String nama = input.nextLine();
            System.out.print("Tanggal Lahir : ");
            String tgl_lahir = input.nextLine();
            System.out.print("Tempat Lahir  : ");
            String tmpt_lahir = input.nextLine();
            System.out.print("Jenis Kelamin : ");
            String gender = input.nextLine();
            do {
                System.out.print("Username      : ");
                String username = input.nextLine();
                if (model.isUserMahasiswaExist(username) == false && model.isUserDosenExist(username) == false) {
                    System.out.print("Password      : ");
                    String password = input.nextLine();
                    model.addMahasiswa(nama, NIM, tgl_lahir, tmpt_lahir, gender, username, password);
                    //add to Database
                    System.out.println("Berhasil memasukan Data!");
                    uniqueUsername = true;
                } else {
                    System.out.println("User sudah terdaftar!");
                }
            } while (uniqueUsername == false);
        } else {
            System.out.println("NIM sudah terdaftar!");
        }
    }

    public void tambahDosen() {
        Scanner input = new Scanner(System.in);
        boolean uniqueUsername = false;

        System.out.println("Masukan Identitas Dosen: ");
        System.out.print("NIP           : ");
        String NIP = input.nextLine();

        //Searching unique attribute
        if (model.isNIPDosenExist(NIP) == false) {
            System.out.print("Nama          : ");
            String nama = input.nextLine();
            System.out.print("Tanggal Lahir : ");
            String tgl_lahir = input.nextLine();
            System.out.print("Tempat Lahir  : ");
            String tmpt_lahir = input.nextLine();
            System.out.print("Jenis Kelamin : ");
            String gender = input.nextLine();
            do {
                System.out.print("Username      : ");
                String username = input.nextLine();
                if (model.isUserDosenExist(username) == false && model.isUserMahasiswaExist(username) == false) {
                    System.out.print("Password      : ");
                    String password = input.nextLine();
                    model.addDosen(nama, NIP, tgl_lahir, tmpt_lahir, gender, username, password);
                    //add to Database
                    System.out.println("Berhasil memasukan Data!");
                    uniqueUsername = true;
                } else {
                    System.out.println("User sudah terdaftar!");
                }

            } while (uniqueUsername == false);
        } else {
            System.out.println("NIP sudah terdaftar!");
        }
    }

    public void tambahMataKuliah() {
        Scanner input = new Scanner(System.in);

        //Searching unique attribute
        System.out.println("Masukan Data Mata Kuliah: ");
        System.out.print("Kode          : ");
        String kode_mk = input.nextLine();

        if (model.isKodeMKExist(kode_mk) == false) {
            System.out.print("Nama          : ");
            String nama_mk = input.nextLine();
            model.addMataKuliah(nama_mk, kode_mk);
            //add to Database
            System.out.println("Berhasil memasukan Data!");
        } else {
            System.out.println("Kode matakuliah sudah terdaftar!");
        }
    }

    public void hapusMahasiswa() {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukan NIM     : ");
        String NIM = input.nextLine();

        if (model.isNIMMahasiswaExist(NIM) == true) {
            model.getDaftarMahasiswa().remove(model.getMahasiswa(NIM));
            db.deleteMahasiswa(NIM);
            System.out.println("Berhasil menghapus data mahasiswa");
        } else {
            System.out.println("NIM tidak terdaftar!");
        }
    }

    public void hapusDosen() {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukan NIP     : ");
        String NIP = input.nextLine();

        if (model.isNIPDosenExist(NIP) == true) {
            model.getDaftarDosen().remove(model.getDosen(NIP));
            db.deleteDosen(NIP);
            System.out.println("Berhasil manghapus dosen");
        } else {
            System.out.println("NIP tidak terdaftar");
        }
    }

    public void hapusMataKuliah() {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukan Kode MK   : ");
        String kode_mk = input.nextLine();

        if (model.isKodeMKExist(kode_mk)) {
            model.getDaftarMataKuliah().remove(model.getMataKuliah(kode_mk));
            db.deleteMataKuliah(kode_mk);
        } else {
            System.out.println("Kode matakuliah tidak terdaftar!");
        }
    }

    public void cariMahasiswa() {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukan NIM     : ");
        String NIM = input.nextLine();

        if (model.isNIMMahasiswaExist(NIM) == true) {
            System.out.println("Nama            : " + model.getDaftarMahasiswa().get(model.searchMahasiswa(NIM)).getNama() + "\n");
        } else {
            System.out.println("NIM tidak terdaftar!\n");
        }
    }

    public void cariDosen() {
        Scanner input = new Scanner(System.in);

        System.out.print("\nMasukan NIP   : ");
        String NIP = input.nextLine();

        if (model.isNIPDosenExist(NIP) == true) {
            System.out.println("Nama            : " + model.getDaftarDosen().get(model.searchDosen(NIP)).getNama() + "\n");
        } else {
            System.out.println("NIP tersebut tidak terdaftar!\n");
        }
    }

    public void cariMataKuliah() {
        Scanner input = new Scanner(System.in);

        System.out.print("\nMasukan kode matakuliah   : ");
        String kode_mk = input.nextLine();

        if (model.isKodeMKExist(kode_mk) == true) {
            System.out.println("Nama Matakuliah : " + model.getDaftarMataKuliah().get(model.searchMataKuliah(kode_mk)).getNamaMK());
        } else {
            System.out.println("Kode matakuliah tersebut tidak terdaftar!\n");
        }
    }

    public void tampilMahasiswa() {
        System.out.println("\n---Data Mahasiswa---\n");
        for (Mahasiswa m : model.getDaftarMahasiswa()) {
            System.out.println("Nama            : " + m.getNama());
            System.out.println("NIM             : " + m.getNIM());
            System.out.println("Jenis Kelamin   : " + m.getGender());
            System.out.println("Tempat Lahir    : " + m.getTmptLahir());
            System.out.println("Tanggal Lahir   : " + m.getTglLahir());
            System.out.println("");
        }
        System.out.println("--------------------\n");
    }

    public void tampilDosen() {
        System.out.println("\n---Data Dosen---\n");
        for (Dosen d : model.getDaftarDosen()) {
            System.out.println("Nama            : " + d.getNama());
            System.out.println("NIP             : " + d.getNIP());
            System.out.println("Jenis Kelamin   : " + d.getGender());
            System.out.println("Tempat Lahir    : " + d.getTmptLahir());
            System.out.println("Tanggal Lahir   : " + d.getTglLahir());
            System.out.println("");
        }
        System.out.println("----------------\n");
    }

    public void tampilMataKuliah() {
        System.out.println("\n---Data Matakuliah---\n");
        for (MataKuliah mk : model.getDaftarMataKuliah()) {
            System.out.println("Nama            : " + mk.getNamaMK());
            System.out.println("Kode            : " + mk.getKodeMK());
            System.out.println("");
        }
        System.out.println("----------------------\n");
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
                + "\n 7. Lihaat Semua Kelas"
                + "\n 8. Lihat Semua Tugas"
                + "\n 0. Logout");
    }

    public void tambahKelas() {
        Scanner input = new Scanner(System.in);

        System.out.println("Masukan data Kelas: ");
        System.out.print("Kode Kelas        : ");
        String kode_mk = input.nextLine();

        //searching unique attribute
        if (model.isKodeKelasExist(kode_mk) == false) {
            System.out.print("Nama Kelas        : ");
            String nama_mk = input.nextLine();
            System.out.print("Jurusan           : ");
            String jurusan = input.nextLine();
            currentDosen.createKelas(nama_mk, kode_mk, jurusan);
            //add to database
            System.out.println("Berhasil menambahkan kelas!");
        } else {
            System.out.println("Kode kelas sudah terdaftar!");
        }
    }

    public void tambahTugas() {
        Scanner input = new Scanner(System.in);
        Scanner inputInt = new Scanner(System.in);
        boolean success = false;

        if (currentDosen.getDaftarKelas().size() == 0) {
            System.out.println("Belum terdapat kelas!");
        } else {
            System.out.println("Masukan Kode Kelas: ");
            System.out.print("Kode Kelas        : ");
            String kode_kelas = input.nextLine();

            for (Kelas k : currentDosen.getDaftarKelas()) {
                if (k.getKode_kelas().equals(kode_kelas)) {
                    System.out.println("Masukan data tugas: ");
                    System.out.print("Judul Tugas       : ");
                    String judul = input.nextLine();
                    System.out.print("Deskripsi Tugas   : ");
                    String desc = input.nextLine();
                    System.out.print("Jumlah Soal       : ");
//                    do{
                        try {
                            int jmlh_soal = inputInt.nextInt();
                            k.createTugas(judul, jmlh_soal, desc);
                            System.out.println("Berhasil menambahkan tugas!");
                            success = true;
                        } catch (Exception e) {
                            System.out.println("Masukan angka!");
                        }
                    //add to database
                }
            }
            if (success == false) {
                System.out.println("Kelas sudah terdaftar!");
            }
        }
    }

    public void hapusKelas() {
        Scanner input = new Scanner(System.in);

        System.out.print("\nMasukan kode kelas  : ");
        String kode_kelas = input.nextLine();
        if (currentDosen.isKodeKelasExist(kode_kelas) == true) {
            currentDosen.getDaftarKelas().remove(currentDosen.searchKelas(kode_kelas));
            //remove from database
            System.out.println("Berhasil menghapus kelas!");
        } else {
            System.out.println("Kelas tidak terdaftar!");
        }
    }

    public void hapusTugas() {
        Scanner input = new Scanner(System.in);

        System.out.print("\nMasukan kode kelas  : ");
        String kode_kelas = input.nextLine();
        if (currentDosen.isKodeKelasExist(kode_kelas) == true) {
            System.out.print("Masukan judul tugas : ");
            String judul_tugas = input.nextLine();

            if (currentDosen.getDaftarKelas().get(currentDosen.searchKelas(kode_kelas)).isTugasExist(judul_tugas) == true) {
                currentDosen.getDaftarKelas().get(currentDosen.searchKelas(kode_kelas))
                        .getDaftarTugas().remove(currentDosen.getDaftarKelas().get(currentDosen.searchKelas(kode_kelas)).searchTugas(judul_tugas));
                System.out.println("Berhasil menghapus tugas!");
            } else {
                System.out.println("Tugas tidak terdaftar!");
            }
        }
    }

    public void cariKelas() {
        Scanner input = new Scanner(System.in);

        System.out.print("\nMasukan kode kelas  : ");
        String kode_kelas = input.nextLine();
        if (currentDosen.isKodeKelasExist(kode_kelas) == true) {
            System.out.println("Nama kelas      : " + currentDosen.getDaftarKelas().get(currentDosen.searchKelas(kode_kelas)) + "\n");
        } else {
            System.out.println("Kode kelas tidak terdaftar!");
        }
    }

    public void cariTugas() {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukan kode kelas  : ");
        String kode_kelas = input.nextLine();
        if (currentDosen.isKodeKelasExist(kode_kelas) == true) {
            System.out.print("Masukan judul tugas : ");
            String judul_tugas = input.nextLine();

            if(currentDosen.getDaftarKelas().get(currentDosen.searchKelas(kode_kelas)).isTugasExist(judul_tugas)==true){
                System.out.println("Judul tugas     : "+currentDosen.getDaftarKelas().get(currentDosen.searchKelas(kode_kelas))
                        .getTugas(currentDosen.getDaftarKelas().get(currentDosen.searchKelas(kode_kelas)).searchTugas(judul_tugas)).getNamaTugas());
            } else {
                System.out.println("Judul tugas tidak terdaftar!");
            }
        }
    }

    public void pilMenuMahasiswa() {
        System.out.println("Menu Mahasiswa: "
                + "\n 1. Lihat Daftar Kelas"
                + "\n 2. Mendaftar ke Kelas"
                + "\n 3. Lihat Daftar Tugas"
                + "\n 0. Logout");
    }
    
    public void lihatKelas(){
        Scanner input = new Scanner(System.in);
        for(Dosen d : model.getDaftarDosen()){
            System.out.println("----------\nDosen: "+d.getNama());
            for(Kelas k : d.getDaftarKelas()){
                System.out.println("Nama Kelas      : "+k.getNamaKelas());
                System.out.println("Kode Kelas      : "+k.getKode_kelas()+"\n");
            }
        }
    }
    
    public void lihatTugas(){
        Scanner input = new Scanner(System.in);
        
        for(Dosen d : model.getDaftarDosen()){
            System.out.println("----------\nDosen: "+d.getNama());
            for(Kelas k : d.getDaftarKelas()){
                System.out.println("Kode Kelas: "+k.getKode_kelas());
                for(Tugas t : k.getDaftarTugas()){
                    System.out.println("    Judul Tugas     : "+t.getNamaTugas());
                    System.out.println("    Deskripsi Tugas : "+t.getDesc()+"\n");
                }
            }
        }
    }
    
    public void gabungKelas(){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Masukan kode kelas: ");
        String kode_kelas = input.nextLine();
        if(model.isKodeKelasExist(kode_kelas) == true){
            model.getKelas(kode_kelas).addMahasiswa(currentMahasiswa);
        } else {
            System.out.println("Kode kelas tidak terdaftar!");
        }
    }

    public Dosen loginDosen() {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukan username    : ");
        String username = input.nextLine();
        System.out.print("Masukan password    : ");
        String password = input.nextLine();

        for (Dosen d : model.getDaftarDosen()) {
            if (d.getUsername().equals(username) && d.getPassword().equals(password)) {
                return d;
            }
        }
        System.out.println("Username/Password salah!");
        return null;
    }

    public Mahasiswa loginMahasiswa() {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukan username    : ");
        String username = input.nextLine();
        System.out.print("Masukan password    : ");
        String password = input.nextLine();

        for (Mahasiswa m : model.getDaftarMahasiswa()) {
            if (m.getUsername().equals(username) && m.getPassword().equals(password)) {
                return m;
            }
        }
        System.out.println("Username/Password salah!");
        return null;
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
                        try {
                            currentDosen = loginDosen();
                            if (currentDosen != null) {
                                aksesDosen = true;
                            }
                        } catch (Exception e) {
                            System.out.println("Terjadi kesalahan login!");
                        }
                        if (aksesDosen == true) {
                            menuDosen();
                        } else {
                            System.out.println("Login Gagal!\n");
                        }
                        break;
                    case 2:
                        try {
                            currentMahasiswa = loginMahasiswa();
                            if (currentMahasiswa != null) {
                                aksesMahasiswa = true;
                            }
                        } catch (Exception e) {
                            System.out.println("Terjadi kesalahan login!");
                        }
                        if (aksesMahasiswa == true) {
                            menuMahasiswa();
                        } else {
                            System.out.println("Login Gagal!\n");
                        }
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

    public void menuDosen() {
        boolean logout = false;

        do {
            pilMenuDosen();
            try {
                Scanner input = new Scanner(System.in);
                int opt = input.nextInt();

                switch (opt) {
                    case 1:
                        tambahKelas();
                        break;
                    case 2:
                        tambahTugas();
                        break;
                    case 3:
                        hapusKelas();
                        break;
                    case 4:
                        hapusTugas();
                        break;
                    case 5:
                        cariKelas();
                        break;
                    case 6:
                        cariTugas();
                        break;
                    case 7 :
                        lihatKelas();
                        break;
                    case 8:
                        lihatTugas();
                        break;
                    case 0:
                        currentDosen = null;
                        aksesDosen = false;
                        logout = true;
                        break;
                    default:
                        System.out.println("Mohon pilih menu yang tersedia.");
                }
            } catch (Exception e) {
                System.out.println("Terjadi error di 'menuDosen'");
            }
        } while (logout != true);
    }

    public void menuMahasiswa() {
        boolean logout = false;

        do {
            pilMenuMahasiswa();
            try {
                Scanner input = new Scanner(System.in);
                int opt = input.nextInt();

                switch (opt) {
                    case 1:
                        lihatKelas();
                        break;
                    case 2:
                        gabungKelas();
                        break;
                    case 3:
                        lihatTugas();
                        break;
                    case 0:
                        currentMahasiswa = null;
                        aksesMahasiswa = false;
                        logout = true;
                        break;
                    default:
                        System.out.println("Mohon pilih menu yang tersedia.");
                }
            } catch (Exception e) {
                System.out.println("Terjadi error di 'menuMahasiswa'");
            }
        } while (logout != true);
    }
}
