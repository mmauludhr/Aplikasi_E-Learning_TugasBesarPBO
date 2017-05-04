/*
 * Tugas Besar - Pemrograman Berorientasi Objek
 * Muhammad Maulud H. R. | 1301154166
 * M. Widadio Ilham	  | 1301154360
 * Afra W. D.	  | 1301150432
 */
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import view.MenuLogin;
import model.Aplikasi;
import database.Database;

/**
 *
 * @author Muhammad Maulud H R
 */
public class ControlMenuLogin extends MouseAdapter implements ActionListener{

    private Aplikasi model;
    private MenuLogin view;
    private Database d;
    
    public ControlMenuLogin(Aplikasi model, Database d){
        this.model = model;
        this.d = d;
        view = new MenuLogin();
        view.setActionListener(this);
        view.addMouseAdapter(this);
        view.setVisible(true);
        
        //run the app
        loadAkun();
    }
    
    public void loadAkun(){
        

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
