/*
 * Tugas Besar - Pemrograman Berorientasi Objek
 * Muhammad Maulud H. R. | 1301154166
 * M. Widadio Ilham	  | 1301154360
 * Afra W. D.	  | 1301150432
 */
package database;

import model.Akun;
import model.Dosen;
import model.Kelas;
import model.Mahasiswa;
import model.MataKuliah;

/**
 *
 * @author Dio Ilham
 */
public class DummyDrive {
    public static void main(String[] args) {
        Database d = new Database();
        d.connect();
        
        Mahasiswa m1 = new Mahasiswa("Dio", "1301154306", "21-07-1998", "Jakarta", "L", "dioilhm", "pass");
        Mahasiswa m2 = new Mahasiswa("Maulud", "1111", "11-07-1997", "Papua", "L", "mmaulud", "pass");
       //d.saveAkunMahasiswa(m1);
       //d.saveMahasiswa(m1);
       //d.saveAkunMahasiswa(m2);
       //d.saveMahasiswa(m2);
        //String nama, String NIM, String tgl_lahir,
        //String tmpt_lahir, String jenis_k, String username, String password
        d.deleteMahasiswa("1111");
        
        Dosen dosen1 = new Dosen("Rita", "1301154278", "01-02-1960", "Bandung", "P", "11", "pass");
        Dosen dosen2 = new Dosen("Bimo","11111111", "05-04-1975", "Surabaya", "L", "22", "pass" );
        //d.saveAkunDosen(dosen2);
        //d.saveDosen(dosen2);
        //d.saveAkunDosen(dosen1);
        //d.saveDosen(dosen1);
        d.deleteDosen("1301154278");
        //String nama, String NIP, String tgl_lahir, String tmpt_lahir, 
        //String jenis_k, String username, String password
        MataKuliah mk1 = new MataKuliah("Matakuliah 1", "01");
        MataKuliah mk2 = new MataKuliah("Matakuliah 2","02");
        //d.saveMatakuliah(mk);
        //d.saveMataKuliah(mk2);
        //d.saveMataKuliah(mk1);
        d.deleteMataKuliah("Matakuliah 1");
        
        Kelas k1 = new Kelas("Kelas 1", "001", "FIF");
        Kelas k2 = new Kelas("Kelas 2", "002", "FIT");
        //d.saveKelas(k2, dosen1);
        //d.saveKelas(k1, dosen2);
        d.deleteKelas("Kelas 1");
        //String nama_kelas, String kode_kelas, String jurusan pada constructnya
    
        

        
//        System.out.println(d.loadMahasiswa());
//        System.out.println(d.loadDosen());
//        System.out.println(d.loadMatakuliah());
//        System.out.println(d.loadKelas());
          System.out.println(d.loadAkunMahasiswa());
          System.out.println(d.loadAkunDosen());
 
       
    }
    
}
