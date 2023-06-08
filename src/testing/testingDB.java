
package testing;
import model.*;
import dao.*;
import control.*;
import connection.DbConnection;
import java.util.List;


public class testingDB {
    
    public static void main(String[] args) {
        Customers c = new Customers("bastian","steal", "bastiansteal@gmail.com", "bst", "bstl", "12345678910", "jl raya");
        CustomersControl cc = new CustomersControl();
        cc.insertCustomer(c);
        Accounts a =  new Accounts(1,"sjgakj", 3000000.00, 1);
        AccountsControl ac = new AccountsControl();
        ac.insertAccounts(a);

        //Di sini nanti buat cek database pake class controlnya
        //kelar class control baru cek
        
    }
    
    
}
