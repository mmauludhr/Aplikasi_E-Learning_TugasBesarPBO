/*
 * Tugas Besar_Pemrograman Berorientasi Objek_Aplikasi E-Learning
 * Muhammad Maulud H. R.    | 1301154166
 * M. Widadio Ilham         | 1301154360
 * Afra W. D.               | 1301150432
 */
package model;

/**
 *
 * @author M Maulud H R
 */
public class Tugas {

    private String nama_tugas;
    private int jmlh_soal;
    private String desc;
    private String kode_tugas;

    public Tugas(String nama_tugas, int jmlh_soal, String desc) {
        this.nama_tugas = nama_tugas;
        this.jmlh_soal = jmlh_soal;
        this.desc = desc;
    }

    public void setNamaTugas(String nama_tugas) {
        this.nama_tugas = nama_tugas;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getJmlhSoal() {
        return jmlh_soal;
    }

    public void setJmlhSoal(int jmlh_soal) {
        this.jmlh_soal = jmlh_soal;
    }

    public String getDesc() {
        return desc;
    }

    public String getNamaTugas() {
        return nama_tugas;
    }

    public String getKode_tugas() {
        return kode_tugas;
    }

    public void setKode_tugas(String kode_tugas) {
        this.kode_tugas = kode_tugas;
    }

    
}
