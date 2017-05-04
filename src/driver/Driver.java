/*
 * Tugas Besar - Pemrograman Berorientasi Objek
 * Muhammad Maulud H. R. | 1301154166
 * M. Widadio Ilham	  | 1301154360
 * Afra W. D.	  | 1301150432
 */
package driver;
import database.Database;
import model.*;
import view.*;
import controller.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Muhammad Maulud H R
 */
public class Driver {
    public static void main(String[] args) {
        try {
            Database d = new Database();
            Aplikasi app = new Aplikasi();
            
            app.load(d.loadMatakuliah(), d.loadDosen(), d.loadMahasiswa());
            
             ControlMenuLogin view = new ControlMenuLogin(app, d);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to connect to Database!",
                    "Exception", JOptionPane.ERROR_MESSAGE);
        }
    }
}
