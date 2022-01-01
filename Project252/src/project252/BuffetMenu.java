/*
Name: Abdulrahman Alqahtani 
ID: 1846618
 */
package project252;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BuffetMenu implements Commands {
    
    Connection conn = DBConnection.getDBInstance();
    PreparedStatement stat;
    
    int quantity;
    String name="";
    
    @Override
    public void insert() {
        try {
            
            stat = conn.prepareStatement("insert into `buffetmenu` values (?, ?)");
            stat.setString(1, name);
            stat.setInt(2, quantity);
            stat.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update() {
        try {
            
            stat = conn.prepareStatement("update `buffetmenu` set quantity=? where name=? ");
            stat.setInt(1, quantity);
            stat.setString(2, name);
            stat.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete() {
        try {
            
            stat = conn.prepareStatement("delete from `buffetmenu` where name=? ");
            stat.setString(1, this.name);
            stat.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
