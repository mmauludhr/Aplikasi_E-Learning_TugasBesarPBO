/*
 * Tugas Besar - Pemrograman Berorientasi Objek
 * Muhammad Maulud H. R. | 1301154166
 * M. Widadio Ilham	  | 1301154360
 * Afra W. D.	  | 1301150432
 */
package driver;

import database.Database;
import java.util.Scanner;
import model.Console;

/**
 *
 * @author Muhammad Maulud H R
 */
public class DriverConsole {

    public static void main(String[] args) {
        boolean exit = false;
        Database d = new Database();
        Console csl = new Console(d);
        
        
        
        

        do {
            csl.menuUtama();
            try {
                Scanner input = new Scanner(System.in);
                int opt = input.nextInt();

                switch (opt) {
                    case 1:
                        csl.menuAdmin();
                        break;
                    case 2:
                        csl.menuUser();
                        break;
                    case 0:
                        System.out.println("Exit Console Driver..");
                        exit = true;
                        break;
                    default:
                        System.out.println("Tolong masukan menu yang tersedia!");
                }

            } catch (Exception e) {
                System.out.println("Input Error!");
            }

        } while (exit != true);

    }
}
