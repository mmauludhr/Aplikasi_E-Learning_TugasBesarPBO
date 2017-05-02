/*
 * Tugas Besar_Pemrograman Berorientasi Objek_Aplikasi E-Learning
 * Muhammad Maulud H. R.    | 1301154166
 * M. Widadio Ilham         | 1301154360
 * Afra W. D.               | 1301150432
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

    public void addMataKuliah(MataKuliah mk) {
        daftarMatakuliah.add(mk);
    }

    public void addDosen(Dosen d) {
        daftarDosen.add(d);
    }

    public void addMahasiswa(Mahasiswa m) {
        daftarMahasiswa.add(m);
    }

    public int searchDosen(String NIP) {
        for (int i = 0; i < daftarDosen.size(); i++) {
            if (daftarDosen.get(i).getNIP().equals(NIP)) {
                return i;
            }
        }
        return -1;
    }

    public int searchMahasiswa(String NIM) {
        for (int i = 0; i < daftarMahasiswa.size(); i++) {
            if (daftarMahasiswa.get(i).getNIM().equals(NIM)) {
                return i;
            }
        }
        return -1;
    }

    public int searchMataKuliah(String kode_mk) {
        for (int i = 0; i < daftarMatakuliah.size(); i++) {
            if (daftarMatakuliah.get(i).getKodeMK().equals(kode_mk)) {
                return i;
            }
        }
        return -1;
    }

}
