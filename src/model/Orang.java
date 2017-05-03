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
public abstract class Orang {
    private String nama;
    private String tgl_lahir;
    private int umur;
    private String tmpt_lahir;
    private String gender;
    private String alamat;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTglLahir() {
        return tgl_lahir;
    }

    public void setTglLahir(String tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }

    public int getUmur() {
        //Perhitungan denga tipe data "Date". Tanggal sekarang - tanggal lahir = umur.
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public String getTmptLahir() {
        return tmpt_lahir;
    }

    public void setTmptLahir(String tmpt_lahir) {
        this.tmpt_lahir = tmpt_lahir;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public abstract String pekerjaan();
    
}
