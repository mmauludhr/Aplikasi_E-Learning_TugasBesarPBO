/*
 * Tugas Besar - Pemrograman Berorientasi Objek
 * Muhammad Maulud H. R. | 1301154166
 * M. Widadio Ilham	  | 1301154360
 * Afra W. D.	  | 1301150432
 */
package driver;
import model.*;
/**
 *
 * @author Muhammad Maulud H R
 */
public class Driver {
    public static void main(String[] args) {
        Dosen d = new Dosen("Andit", "110", "1 Januari 1990", "Bandung", "Pria", "andit", "123");
        d.createKelas("PBO", "2CS3S", "Informatika");
    }
}
