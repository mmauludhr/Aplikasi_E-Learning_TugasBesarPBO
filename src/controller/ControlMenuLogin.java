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
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

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
    public void actionPerformed(ActionEvent ae) {
        Object click = ae.getSource();
        
        if(click.equals(view.getAdmin())){
            view.dispose();
            
            try {
                view.dispose();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(view, "Error occured, restart the program");
            }
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent me){
        
    }
    
}
