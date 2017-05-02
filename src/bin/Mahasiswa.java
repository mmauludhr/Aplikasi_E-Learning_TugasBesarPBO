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
public class Mahasiswa extends Orang{
    private String NIM;

    public Mahasiswa(String nama, String tgl_lahir, String tmpt_lahir, char jenis_k, String NIM){
        super.setNama(nama);
        super.setTglLahir(tgl_lahir);
        super.setTmptLahir(tmpt_lahir);
        super.setGender(jenis_k);
        this.NIM = NIM;
    }
    
    public String getNIM() {
        return NIM;
    }

    @Override
    public String pekerjaan() {
        return "Mahasiswa";
    }
    
    
}
