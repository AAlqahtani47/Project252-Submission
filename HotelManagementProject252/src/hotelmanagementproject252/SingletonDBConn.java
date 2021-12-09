/*
Name: Abdulrahman Alqahtani 
ID: 1846618
 */
package hotelmanagementproject252;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author abdul
 */
public class SingletonDBConn {

    static Connection conn = null;

    private SingletonDBConn() {
    }

    public static Connection getDBInstance() {
        try {
            if (conn == null) {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                
                //Change Path to the place where the access file is saved
                String path = "C:\\Users\\abdul\\Documents\\HotelDB.accdb";
                String url = "jdbc:ucanaccess://" + path;
                conn = DriverManager.getConnection(url);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
}
