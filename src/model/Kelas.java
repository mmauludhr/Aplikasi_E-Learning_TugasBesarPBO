/*
 * Tugas Besar_Pemrograman Berorientasi Objek_Aplikasi E-Learning
 * Muhammad Maulud H. R.    | 1301154166
 * M. Widadio Ilham         | 1301154360
 * Afra W. D.               | 1301150432
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author M Maulud H R
 */
public class Kelas {

    private String kode_kelas;
    private String nama_kelas;
    private String jurusan;
    private int jmlh_mahasiswa;
    private MataKuliah mata_kuliah;
    private Dosen dosen_pengajar;
    private Tugas tugas;
    private ArrayList<Mahasiswa> anggota;
    private ArrayList<Tugas> daftar_tugas;

    public Kelas(String nama_kelas, String kode_kelas, String jurusan) {
        this.nama_kelas = nama_kelas;
        this.kode_kelas = kode_kelas;
        this.jurusan = jurusan;
        this.daftar_tugas = new ArrayList<Tugas>();
    }

    public String getNamaKelas() {
        return nama_kelas;
    }

    public int getJmlh_mahasiswa() {
        return jmlh_mahasiswa;
    }

    public void setMataKuliah(MataKuliah mata_kuliah) {
        this.mata_kuliah = mata_kuliah;
    }

    public MataKuliah getMata_kuliah() {
        return mata_kuliah;
    }

    public String getKode_kelas() {
        return kode_kelas;
    }

    public void setKode_kelas(String kode_kelas) {
        this.kode_kelas = kode_kelas;
    }

    public void setDosenPengajar(Dosen dosen_pengajar) {
        this.dosen_pengajar = dosen_pengajar;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public Tugas getTugas() {
        return tugas;
    }
    
    public Tugas getTugas(int index){
        return daftar_tugas.get(index);
    }

    public void setTugas(Tugas tugas) {
        this.tugas = tugas;
    }

    public void addMahasiswa(Mahasiswa mhs) {
        if (isAnggotaFull() == false) {
            anggota.add(mhs);
        } else {
            System.out.println("Anggot kelas penuh!");
        }
    }

    public int searchAnggota(String NIM) {
        for (int i = 0; i <= anggota.size(); i++) {
            if (anggota.get(i).getNIM() == NIM) {
                return i;
            }
        }
        return -1;
    }

    public void removeAnggota(int index) {
        if (index == -1) {
            System.out.println("Anggota tidak terdaftar!");
        } else {
            anggota.remove(index);
        }
    }

    public void createTugas(String nama_tugas, int jmlh_soal, String desc) {
        tugas = new Tugas(nama_tugas, jmlh_soal, desc);
        daftar_tugas.add(tugas);
    }

    public int searchTugas(String nama_tugas) {
        for (int i = 0; i < daftar_tugas.size(); i++) {
            if (daftar_tugas.get(i).getNamaTugas() == nama_tugas) {
                return i;
            }
        }
        return -1;
    }
    
    public boolean isTugasExist(String judul_tugas){
        for(Tugas t : daftar_tugas){
            if(t.getNamaTugas().equals(judul_tugas)){
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Tugas> getDaftarTugas(){
        return daftar_tugas;
    }
    
//    public Tugas getTugas(){
//        return null;
//    }

    public void deleteTugas(int index) {
        if (index == -1) {
            System.out.println("Tugas tidak terdaftar!");
        } else {
            daftar_tugas.remove(index);
        }
    }

    public boolean isAnggotaFull() {
        if (anggota.size() == 30) {
            return true;
        }
        return false;
    }

}
