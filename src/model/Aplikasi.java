/*
 * Tugas Besar_Pemrograman Berorientasi Objek_Aplikasi E-Learning
 * Muhammad Maulud H. R.    | 1301154166
 * M. Widadio Ilham         | 1301154360
 * Afra W. D.               | 1301150432
 */
package model;

import database.Database;
import java.util.ArrayList;

/**
 *
 * @author Muhammad Maulud H R
 */
public class Aplikasi {

    private ArrayList<MataKuliah> daftarMatakuliah;
    private ArrayList<Dosen> daftarDosen;
    private ArrayList<Mahasiswa> daftarMahasiswa;
    private Database db;

    
    
    public Aplikasi(Database db){
        daftarMatakuliah = new ArrayList<>();
        daftarDosen = new ArrayList<>();
        daftarMahasiswa = new ArrayList<>();
        this.db = db;
        
        load(db.loadMatakuliah(), db.loadAkunDosen(), db.loadMahasiswa());
//        this.daftarMahasiswa = d.loadAkunMahasiswa();
    }
    
    public void load(ArrayList<MataKuliah> daftarMatakuliah, ArrayList<Dosen> daftarDosen, ArrayList<Mahasiswa> daftarMahasiswa){
        this.daftarMatakuliah = daftarMatakuliah;
        this.daftarDosen = daftarDosen;
        this.daftarMahasiswa = daftarMahasiswa;
    }
    
    //add by Object
    public void addMataKuliah(MataKuliah mk) {
        daftarMatakuliah.add(mk);
        db.insertMataKuliah(mk);
        
    }

    public void addDosen(Dosen d) {
        daftarDosen.add(d);
        db.insertDosen(d);
    }

    public void addMahasiswa(Mahasiswa m) {
        daftarMahasiswa.add(m);
        db.insertMahasiswa(m);
    }

    //add by Constructor
    public void addMataKuliah(String nama_mk, String kode_mk) {
        daftarMatakuliah.add(new MataKuliah(nama_mk, kode_mk));
        
    }

    public void addDosen(String nama, String NIP, String tgl_lahir, String tmpt_lahir, String gender, String username, String password) {
        daftarDosen.add(new Dosen(nama, NIP, tgl_lahir, tmpt_lahir, gender, username, password));
    }

    public void addMahasiswa(String nama, String NIM, String tgl_lahir, String tmpt_lahir, String gender, String username, String password) {
        daftarMahasiswa.add(new Mahasiswa(nama, NIM, tgl_lahir, tmpt_lahir, gender, username, password));
    }

    //searching return index
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
    
    //searching unique kode_kelas
    public boolean isKodeKelasExist(String kode_kelas){
        for(Dosen d : daftarDosen){
            for(Kelas k : d.getDaftarKelas()){
                if(k.getKode_kelas().equals(kode_kelas)){
                    return true;
                }
            }
        }
        return false;
    }
    
    //searching unique username
    public boolean isUserMahasiswaExist(String username){
        for(Mahasiswa m : daftarMahasiswa){
            if(m.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }
    
    public boolean isUserDosenExist(String username){
        for(Dosen d : daftarDosen){
            if(d.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }
    
    //searching unique NIM for Mahasiswa
    public boolean isNIMMahasiswaExist(String NIM){
        for(Mahasiswa m : daftarMahasiswa){
            if(m.getNIM().equals(NIM)){
                return true;
            }
        }
        return false;
    }
    
    //searching unique NIP for Dosen
    public boolean isNIPDosenExist(String NIP){
        for(Dosen d : daftarDosen){
            if(d.getNIP().equals(NIP)){
                return true;
            }
        }
        return false;
    }
    
    //searching unique kode_mk for Matakuliah
    public boolean isKodeMKExist(String kode_mk){
        for(MataKuliah mk : daftarMatakuliah){
            if(mk.getKodeMK().equals(kode_mk)){
                return true;
            }
        }
        return false;
    }

    //getter Object by index
    public MataKuliah getMatakuliah(int index){
        return daftarMatakuliah.get(index);
    }
    
    public Dosen getDosen(int index){
        return daftarDosen.get(index);
    }
    
    public Mahasiswa getMahasiswa(int index){
        return daftarMahasiswa.get(index);
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
    
    public Kelas getKelas(String kode_kelas){
        for(Dosen d : daftarDosen){
            for(Kelas k : d.getDaftarKelas()){
                if(k.getKode_kelas().equals(kode_kelas)){
                    return k;
                }
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
