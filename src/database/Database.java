/*
 * Tugas Besar_Pemrograman Berorientasi Objek_Aplikasi E-Learning
 * Muhammad Maulud H. R.    | 1301154166
 * M. Widadio Ilham         | 1301154360
 * Afra W. D.               | 1301150432
 */
package database;

import model.Mahasiswa;
import model.Kelas;
import model.Dosen;
import model.MataKuliah;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
    
    /**public void saveMahasiswa(Mahasiswa m){       
        try{
            Statement s = connection.createStatement();
            String query = "INSERT INTO `mahasiswa` "
                    + "(`id`, `nama`, `umur`, `nim`, `fakultas`, `semester`, `sks`) "
                    + "VALUES (NULL, '"+ m.getNama()+"', '"+m.getUmur()+"', '"+m.getNim()+"',"
                    + " '"+m.getFakultas()+"', '"+m.getSemester()+"', '"+m.getSks()+"');";
            
            //System.out.println(query);
            
            s.execute(query);
            connection.commit();
            s.close();           
        } catch(SQLException e){
            System.out.println("Error occured");
            e.printStackTrace();
        }
    }*/
    
    public void saveMahasiswa (Mahasiswa m){
        try{
        Statement s = connection.createStatement();
        String query = "INSERT INTO 'mahasiswa' " + "('username', 'password', 'nim', 'Nama_m', 'gender_m', 'tgl_lahir_m', 'tmpt_lahir_m', 'alamat_m')"
                + "VALUES('"+m.getUsername()+"','" + m.getPassword()
                +"','"+m.getNIM()+"','"+m.getNama()+"','"+m.getGender()+"','"+m.getTglLahir()+"','"+m.getTmptLahir()+"','"+m.getAlamat()+"')";
        s.execute(query);
        connection.commit();
        s.close();
    }
        catch (SQLException e){
            System.out.println("Data mahasiswa gagal di input");
            e.printStackTrace();
    }
    }
    
    public void saveAkunMahasiswa (Mahasiswa m){
        try{
        Statement s = connection.createStatement();
        String query = "INSERT INTO 'akun' " + "('username', 'password','acc_type')"
                + "VALUES('"+m.getUsername()+"','" + m.getPassword() +"','" + "Mahasiswa)";
        s.execute(query);
        connection.commit();
        s.close();
    }
        catch (SQLException e){
            System.out.println("Data Akun Mahasiswa gagal di input");
            e.printStackTrace();
    }
    }
    
    public void saveDosen (Dosen d){
        try{
        Statement s = connection.createStatement();
        String query = "INSERT INTO 'dosen' " + "('username', 'password', 'nip', 'Nama_d', 'gender_d', 'tgl_lahir_d', 'Tmpt_lahir_d', 'alamat_d')"
                + "VALUES('"+d.getUsername()+"','" + d.getPassword()
                +"','"+d.getNIP()+"','"+d.getNama()+"','"+d.getGender()+"','"+d.getTglLahir()+"','"+d.getTmptLahir()+"','"+d.getAlamat()+"')";
        s.execute(query);
        connection.commit();
        s.close();
    }
        catch (SQLException e){
            System.out.println("Data Dosen gagal di input");
            e.printStackTrace();
    }
    }
    
     public void saveAkunDosen (Dosen d){
        try{
        Statement s = connection.createStatement();
        String query = "INSERT INTO 'akun' " + "('username', 'password','acc_type')"
                + "VALUES('"+d.getUsername()+"','" + d.getPassword() +"','" + "Dosen"+"')";
        s.execute(query);
        connection.commit();
        s.close();
    }
        catch (SQLException e){
            System.out.println("Data Akun Dosen gagal di input");
            e.printStackTrace();
    }
    }
    public void saveKelas (Kelas k){
        try{
        Statement s = connection.createStatement();
        String query = "INSERT INTO 'kelas' " + "('nama_kelas', 'kode_kls', 'jurusan', 'mata_kuliah', 'tugas', 'kode_mk')"
                + "VALUES('"+k.getNamaKelas()+",'"+k.getKode_kelas()+"','"+k.getJurusan()+"','"
                +k.getMata_kuliah().getNamaMK()+"','"+k.getTugas().getNamaTugas()+",'"+k.getMata_kuliah().getKodeMK()+"')";
        s.execute(query);
        connection.commit();
        s.close();
    }
        catch (SQLException e){
            System.out.println("Data Kelas gagal di input");
            e.printStackTrace();
    }
    }
    
    public void saveMataKuliah (MataKuliah mk){
        try{
        Statement s = connection.createStatement();
        String query = "INSERT INTO 'MataKuliah' " + "('nama_mk', 'kode_mk')"
                + "VALUES('"+mk.getNamaMK()+"','"+mk.getKodeMK()+"')";
        s.execute(query);
        connection.commit();
        s.close();
    }
        catch (SQLException e){
            System.out.println("Data MataKuliah gagal di input");
            e.printStackTrace();
    }
    }
    
    public void saveTugas (Kelas k){
        try{
        Statement s = connection.createStatement();
        String query = "INSERT INTO 'Tugas' " + "('nama_tugas', 'jmlh_soal', 'desc', 'kode_kls', 'kode_tugas')"
                + "VALUES('"+k.getTugas().getNamaTugas()+","
                +k.getTugas().getJmlhSoal()+","+k.getTugas().getDesc()+","+k.getKode_kelas()+","+k.getTugas().getKode_tugas()+"')";
                
        s.execute(query);
        connection.commit();
        s.close();
    }
        catch (SQLException e){
            System.out.println("Data Tugas gagal di input");
            e.printStackTrace();
    }
    }
    
    public void deleteMahasiswa(String nim){
        try{
            Statement s = connection.createStatement();
            String query = "DELETE FROM `mahasiswa` WHERE nim='"+nim+"'";
                      
            s.execute(query);
            connection.commit();
            s.close();
        } catch(SQLException e){
            System.out.println("Data Mahasiswa gagal dihapus");
            e.printStackTrace();
        }
    }
    
    public void deleteDosen(String nip){
        try{
            Statement s = connection.createStatement();
            String query = "DELETE FROM `dosen` WHERE nip='"+nip+"'";

            s.execute(query);
            connection.commit();
            s.close();
        } catch(SQLException e){
            System.out.println("Data Dosen gagal dihapus");
            e.printStackTrace();
        }
    }
    
    public void deleteAkun(String username){
        try{
            Statement s = connection.createStatement();
            String query = "DELETE FROM `akun` WHERE username='"+username+"'";

            s.execute(query);
            connection.commit();
            s.close();
        } catch(SQLException e){
            System.out.println("Data akun gagal dihapus");
            e.printStackTrace();
        }
    }
    public void deleteKelas(String kode_kls){
        try{
            Statement s = connection.createStatement();
            String query = "DELETE FROM `kelas` WHERE kode_kls='"+kode_kls+"'";

            s.execute(query);
            connection.commit();
            s.close();
        } catch(SQLException e){
            System.out.println("Data kelas gagal dihapus");
            e.printStackTrace();
        }
    }
    public void deleteMataKuliah(String kode_mk){
        try{
            Statement s = connection.createStatement();
            String query = "DELETE FROM `matakuliah` WHERE kode_mk='"+kode_mk+"'";

            s.execute(query);
            connection.commit();
            s.close();
        } catch(SQLException e){
            System.out.println("Data kelas gagal dihapus");
            e.printStackTrace();
        }
    }
    
    public void deleteTugas(String kode_tugas){
        try{
            Statement s = connection.createStatement();
            String query = "DELETE FROM `tugas` WHERE kode_tugas='"+kode_tugas+"'";

            s.execute(query);
            connection.commit();
            s.close();
        } catch(SQLException e){
            System.out.println("Data kelas gagal dihapus");
            e.printStackTrace();
        }
    }
    
    public ArrayList<Mahasiswa> loadMahasiswa(){
        try{
            ArrayList<Mahasiswa> listmhs = new ArrayList();
            
            Statement s = connection.createStatement();
            String query = "SELECT * FROM mahasiswa";
            ResultSet r = s.executeQuery(query);
            
            while(r.next()){
                Mahasiswa m = new Mahasiswa (r.getString("Nama_m"), r.getString("nim"), 
                        r.getString("tgl_lahir_m"), r.getString("tmpt_lahir_m"), r.getString("gender_m"),
                        r.getString("username"), r.getString("password"));
                listmhs.add(m);
            }
            //String nama, String NIM, String tgl_lahir,
            //String tmpt_lahir, String jenis_k, String username, String password)
            //'username', 'password', 'nim', 'Nama_m', 'gender_m', 'tgl_lahir_m'
            //, 'tmpt_lahir_m', 'alamat_m
            
            
            return listmhs;  
        } catch(SQLException e){
            System.out.println("terjadi error dalam pemrosesan data mahasiswa");
            e.printStackTrace();
        }
        
        return null;
    }
    
    
    public ArrayList<Dosen> loadDosen(){
        try{
            ArrayList<Dosen> listdosen = new ArrayList();
            
            Statement s = connection.createStatement();
            String query = "SELECT * FROM dosen";
            ResultSet r = s.executeQuery(query);
            
            while(r.next()){
                Dosen d = new Dosen(r.getString("Nama_d"), r.getString("nip"), r.getString("tgl_lahir_d")
                , r.getString("tmpt_lahir_d"), r.getString("gender_d"), r.getString("username"), r.getString("password"));
                listdosen.add(d);
            }
            //String nama, String NIP, String tgl_lahir, String tmpt_lahir, 
            //String jenis_k, String username, String password
            //'username', 'password', 'nip', 'Nama_d', 'gender_d', 'tgl_lahir_d', 'Tmpt_lahir_d', 'alamat_d'
            
            return listdosen;  
        } catch(SQLException e){
            System.out.println("terjadi error dalam pemrosesan data Dosen");
            e.printStackTrace();
        }
        
        return null;
    }
    
    public ArrayList<MataKuliah> loadMatakuliah(){
        try{
            ArrayList<MataKuliah> listmatkul = new ArrayList();
            
            Statement s = connection.createStatement();
            String query = "SELECT * FROM matakuliah";
            ResultSet r = s.executeQuery(query);
            
            while(r.next()){
                MataKuliah matkul = new MataKuliah(r.getString("nama_mk"), r.getString("kode_mk"));
                listmatkul.add(matkul);
            }
            
            return listmatkul;  
        } catch(SQLException e){
            System.out.println("Error occured");
            e.printStackTrace();
        }
        
        return null;
    }
    public ArrayList<Kelas> loadKelas(){
        try{
            ArrayList<Kelas> listkls = new ArrayList();
            
            Statement s = connection.createStatement();
            String query = "SELECT * FROM kelas";
            ResultSet r = s.executeQuery(query);
            
            while(r.next()){
                Kelas kls = new Kelas(r.getString("nama_kelas"), r.getString("kode_kls"), r.getString("jurusan"));
                listkls.add(kls);
            }
            
            return listkls;  
        } catch(SQLException e){
            System.out.println("Error occured");
            e.printStackTrace();
        }
        
        return null;
    }
    //String nama_kelas, String kode_kelas, String jurusan pada construct nya
    //nama_kelas', 'kode_kls', 'jurusan', 'mata_kuliah', 'tugas', 'kode_mk' pada table di database
}
    
    
    
