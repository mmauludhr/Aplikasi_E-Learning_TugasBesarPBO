/*
 * Tugas Besar_Pemrograman Berorientasi Objek_Aplikasi E-Learning
 * Muhammad Maulud H. R.    | 1301154166
 * M. Widadio Ilham         | 1301154360
 * Afra W. D.               | 1301150432
 */
package database;

import java.sql.Connection;
import bin.*;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Muhammad Maulud H R
 */
public class Database {
    private Connection connection;
    private String address;
    private String username;
    private String password;
    
    public Database(){
        connect();
    }
    public void setProperties(String address, String username, String password){
        this.address = address;
        this.username = username;
        this.password = password;
    }

    private void connect() {
        this.address = "jdbc:mysql://localhost/elearning";
        this.username = "";
        this.password = "";
        
        
        try{
            connection = DriverManager.getConnection(address, username, password);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            System.out.println("Succesfully Connected");
        }
        catch(SQLException e){
            System.out.println("Failed to connect");
        }
    }
    
    
    
}