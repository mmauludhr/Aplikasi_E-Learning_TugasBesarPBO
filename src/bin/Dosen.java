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
public class Dosen extends Orang{
    private String NIP;
    private ArrayList<Kelas> daftarKelas;
    
    public Dosen(String nama, String tgl_lahir, String tmpt_lahir, String NIP){
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
    
    public void createKelas(String nama_kelas){
        if(daftarKelas.size() == 2){
            System.out.println("Sudah tidak bisa menambah kelas lagi.");
        } else {
            
        }
    }
    
    //Not Done Yet
}
