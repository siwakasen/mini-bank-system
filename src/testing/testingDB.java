
package testing;
import model.*;
import dao.*;
import control.*;
import connection.DbConnection;
import java.text.SimpleDateFormat;
import java.util.Date;  
import java.util.List;


public class testingDB {
    
    public static void main(String[] args) throws Exception{
        //Di sini nanti buat cek database pake class controlnya
        //kelar class control baru cek
        String sqlDate = "2023-10-01";
        
        String convDate = sqlDate.substring(8, 10)+sqlDate.substring(4, 8)+sqlDate.substring(0, 4);
        
        System.out.println(convDate);
        
    }
    
    
}
