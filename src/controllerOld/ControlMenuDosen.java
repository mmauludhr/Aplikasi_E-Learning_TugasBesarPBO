/*
 * Tugas Besar - Pemrograman Berorientasi Objek
 * Muhammad Maulud H. R. | 1301154166
 * M. Widadio Ilham	  | 1301154360
 * Afra W. D.	  | 1301150432
 */
package controllerOld;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Aplikasi;
import viewOld.MenuDosen;

/**
 *
 * @author Muhammad Maulud H R
 */
public class ControlMenuDosen implements ActionListener {
    private MenuDosen tampilan;
    private Aplikasi model;

    public ControlMenuDosen(Aplikasi model) {
        this.model = model;
        tampilan = new MenuDosen();
        tampilan.setVisible(true);
        tampilan.tambahAksi(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(tampilan.getCreateKelas())) {
            
        } else if (o.equals(tampilan.getCreateTugas())) {
            
        } else if (o.equals(tampilan.getDeleteKelas())) {
            
        } else if (o.equals(tampilan.getDeleteTugas())) {
            
        } else if (o.equals(tampilan.getUpDataTugas())) {
            
        } else if (o.equals(tampilan.getViewKelas())) {
            
        } else if (o.equals(tampilan.getViewTugas())) {
            
        }
    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        
//    }
}
