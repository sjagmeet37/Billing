package bill;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db_Connection 
{
    private static final String username="jagmeet";
    private static final String password="1234";
    private static final String connection_string="jdbc:mysql://127.0.0.1:3306/bill";
    public  static Connection getconnectiom() throws SQLException
    {
        return DriverManager.getConnection(connection_string, username, password);
    }
}
