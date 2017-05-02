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

    public Aplikasi(){
        daftarMatakuliah = new ArrayList<>();
        daftarDosen = new ArrayList<>();
        daftarMahasiswa = new ArrayList<>();
    }
    
    public void load(ArrayList<MataKuliah> daftarMataKuliah, ArrayList<Dosen> daftarDosen, ArrayList<Mahasiswa> daftarMahasiswa){
        this.daftarMatakuliah = daftarMatakuliah;
        this.daftarDosen = daftarDosen;
        this.daftarMahasiswa = daftarMahasiswa;
    }
    
    //add by Object
    public void addMataKuliah(MataKuliah mk) {
        daftarMatakuliah.add(mk);
    }

    public void addDosen(Dosen d) {
        daftarDosen.add(d);
    }

    public void addMahasiswa(Mahasiswa m) {
        daftarMahasiswa.add(m);
    }

    //add by Constructor
    public void addMataKuliah(String nama_mk, String kode_mk) {
        daftarMatakuliah.add(new MataKuliah(nama_mk, kode_mk));
    }

    public void addDosen(String nama, String tgl_lahir, String tmpt_lahir, char gender, String NIP) {
        daftarDosen.add(new Dosen(nama, tgl_lahir, tmpt_lahir, gender, NIP));
    }

    public void addMahasiswa(String nama, String tgl_lahir, String tmpt_lahir, char gender, String NIM) {
        daftarMahasiswa.add(new Mahasiswa(nama, tgl_lahir, tmpt_lahir, gender, NIM));
    }

    //searching by index
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

    //getter Object by parameter
    public MataKuliah getMataKuliah(String kode_mk) {
        for (int i = 0; i < daftarMatakuliah.size(); i++) {
            if (daftarMatakuliah.get(i).getKodeMK().equals(kode_mk)) {
                return daftarMatakuliah.get(i);
            }
        }
        return null;
    }

    public Dosen getDosen(String NIP) {
        for (int i = 0; i < daftarDosen.size(); i++) {
            if (daftarDosen.get(i).getNIP().equals(NIP)) {
                return daftarDosen.get(i);
            }
        }
        return null;
    }

    public Mahasiswa getMahasiswa(String NIM) {
        for (int i = 0; i < daftarMahasiswa.size(); i++) {
            if (daftarMahasiswa.get(i).getNIM().equals(NIM)) {
                return daftarMahasiswa.get(i);
            }
        }
        return null;
    }

    //delete Object by Index
    public void deleteMataKuliah(int index) {
        daftarMatakuliah.remove(index);
    }

    public void deleteDosen(int index) {
        daftarDosen.remove(index);
    }

    public void deleteMahasiswa(int index) {
        daftarMahasiswa.remove(index);
    }

    //getter List
    public ArrayList<MataKuliah> getDaftarMataKuliah() {
        return daftarMatakuliah;
    }

    public ArrayList<Dosen> getDaftarDosen() {
        return daftarDosen;
    }

    public ArrayList<Mahasiswa> getDaftarMahasiswa() {
        return daftarMahasiswa;
    }

}
