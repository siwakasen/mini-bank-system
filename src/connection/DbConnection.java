package connection;

<<<<<<< HEAD
=======
/*
    Nama  : Ryan Pratama Wijaya
    Kelas : C
    NPM   : 210711008
*/
>>>>>>> 1c9772d291950661846c7bf7d869a1a7d7b0dc39
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection CON;
    public static final String URL = "jdbc:mysql://";
    public static final String PATH = "localhost:3306/tubes";
    
    public Connection makeConnection (){
        System.out.println("Opening database...");
        try {
            CON = DriverManager.getConnection(URL+PATH,"root","");
            System.out.println("Success!");
        } catch (Exception e) {
            System.out.println("Error opening database...");
            System.out.println(e);
        }
        return CON;
    }
    
    public void closeConnection (){
        System.out.println("Closing Database...");
        try {
            CON.close();
            System.out.println("Success!");
        } catch (Exception e) {
            System.out.println("Error closing database...");
            System.out.println(e);
        }
    }
}