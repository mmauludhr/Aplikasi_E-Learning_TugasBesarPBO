/*
 * Tugas Besar_Pemrograman Berorientasi Objek_Aplikasi E-Learning
 * Muhammad Maulud H. R.    | 1301154166
 * M. Widadio Ilham         | 1301154360
 * Afra W. D.               | 1301150432
 */
package bin;

/**
 *
 * @author M Maulud H R
 */
public class Kelas {
    private String nama_Kelas;
    private int jmlh_mahasiswa;
    private String jurusan;
    private int max_mahasiswa;
    private Mahasiswa [] anggota;
    private Tugas[] tugas;
    private MataKuliah mata_kuliah;
    
    public void Kelas(String nama_kelas){
        this.nama_Kelas = nama_Kelas;
    }
    
    
    
    //Not Done Yet

    public String getNama_Kelas() {
        return nama_Kelas;
    }

    public int getJmlh_mahasiswa() {
        return jmlh_mahasiswa;
    }

    public int getMax_mahasiswa() {
        return max_mahasiswa;
    }

    public void setMax_mahasiswa(int max_mahasiswa) {
        this.max_mahasiswa = max_mahasiswa;
    }

    public void setMata_kuliah(MataKuliah mata_kuliah) {
        this.mata_kuliah = mata_kuliah;
    }
    
    
}
