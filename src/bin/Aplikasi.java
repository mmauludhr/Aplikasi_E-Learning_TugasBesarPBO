/*
 * Tugas Besar - Pemrograman Berorientasi Objek
 * Muhammad Maulud H. R. | 1301154166
 * M. Widadio Ilham	  | 1301154360
 * Afra W. D.	  | 1301150432
 */
package bin;

import java.util.ArrayList;

/**
 *
 * @author Muhammad Maulud H R
 */
public class Aplikasi {
    private ArrayList<MataKuliah> daftarMatakuliah;
    private ArrayList<Dosen> daftarDosen;
    private ArrayList<Mahasiswa> daftarMahasiswa;
    
    public void addMataKuliah(MataKuliah mk){
        daftarMatakuliah.add(mk);
    }
    
    public void addDosen(Dosen d){
        daftarDosen.add(d);
    }
    
    public void addMahasiswa(Mahasiswa m){
        daftarMahasiswa.add(m);
    }
    
}
