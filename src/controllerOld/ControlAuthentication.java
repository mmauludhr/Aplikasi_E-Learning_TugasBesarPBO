/*
 * Tugas Besar_Pemrograman Berorientasi Objek_Aplikasi E-Learning
 * Muhammad Maulud H. R.    | 1301154166
 * M. Widadio Ilham         | 1301154360
 * Afra W. D.               | 1301150432
 */
package controllerOld;

import model.Aplikasi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import viewOld.Authentication;

/**
 *
 * @author Muhammad Maulud H R
 */
public class ControlAuthentication implements ActionListener{
    private Authentication tampilan;
    private Aplikasi model;

    public ControlAuthentication(Aplikasi model) {
        this.model = model;
        tampilan = new Authentication();
        tampilan.setVisible(true);
        tampilan.tambahAksi(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(tampilan.getBtnLogin())) {
            
        }
    }
    
}
