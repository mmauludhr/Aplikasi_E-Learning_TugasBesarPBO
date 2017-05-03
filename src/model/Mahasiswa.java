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
public class Mahasiswa extends Orang implements Akun {

    private String NIM;
    private String username;
    private String password;

    //Parameter tambahkan username
    public Mahasiswa(String nama, String tgl_lahir, String tmpt_lahir, String jenis_k, String NIM) {
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

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

}
