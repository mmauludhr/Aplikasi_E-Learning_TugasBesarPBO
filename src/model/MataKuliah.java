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
public class MataKuliah {

    private String nama_mk;
    private String kode_mk;

    public MataKuliah(String nama_mk, String kode_mk) {
        this.kode_mk = kode_mk;
        this.nama_mk = nama_mk;
    }

    public String getNamaMK() {
        return nama_mk;
    }

    public void setNamaMK(String nama_mk) {
        this.nama_mk = nama_mk;
    }

    public String getKodeMK() {
        return kode_mk;
    }

    public void setKodeMK(String kode_mk) {
        this.kode_mk = kode_mk;
    }

}
