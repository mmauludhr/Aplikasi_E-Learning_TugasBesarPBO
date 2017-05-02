/*
 * Tugas Besar_Pemrograman Berorientasi Objek_Aplikasi E-Learning
 * Muhammad Maulud H. R.    | 1301154166
 * M. Widadio Ilham         | 1301154360
 * Afra W. D.               | 1301150432
 */
package bin;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author M Maulud H R
 */
public class Dosen extends Orang {

    private String NIP;
    private ArrayList<Kelas> daftar_kelas;
    private Kelas kelas;

    public Dosen(String nama, String tgl_lahir, String tmpt_lahir, String NIP) {
        super.setNama(nama);
        super.setTgl_lahir(tgl_lahir);
        super.setTmpt_lahir(tmpt_lahir);
        this.NIP = NIP;
    }

    public String getNIP() {
        return NIP;
    }

    @Override
    public String pekerjaan() {
        return "Dosen";
    }

    public void createKelas(String nama_kelas, String jurusan) {
        if (isDaftarKelasFull() == false) {
            kelas = new Kelas(nama_kelas, jurusan);
            for (int i = 0; i <= daftar_kelas.size(); i++) {
                if (daftar_kelas.get(i) == null) {
                    daftar_kelas.set(i, kelas);
                }
            }
        }
    }

    public Kelas getKelas(int index) {
        if (index == -1) {
            System.out.println("Kelas tidak terdaftar!");
        } else {
            return daftar_kelas.get(index);
        }
        return null;
    }

    public int searchKelas(String nama_kelas) {
        for (int i = 0; i <= daftar_kelas.size(); i++) {
            if (daftar_kelas.get(i).getNamaKelas() == nama_kelas) {
                return i;
            }
        }
        return -1;
    }

    public void deleteKelas(int index) {
        if (index == -1) {
            System.out.println("Kelas tersebut tidak terdaftar!");
        } else {
            daftar_kelas.remove(index);
        }
    }

    public boolean isDaftarKelasFull() {
        if (daftar_kelas.size() == 2) {
            return true;
        }
        return false;
    }
}
