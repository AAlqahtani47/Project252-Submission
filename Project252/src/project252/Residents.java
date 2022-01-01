/*
Name: Abdulrahman Alqahtani 
ID: 1846618
 */
package project252;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Residents implements Commands {
    Connection conn = DBConnection.getDBInstance();
    PreparedStatement stat;
    
    int id;
    String name;
    int daysOfReservation;
    
    @Override
    public void insert() {
        try {
            
            stat = conn.prepareStatement("insert into residents values (?, ?, ?)");
            stat.setInt(1, id);
            stat.setString(2, name);
            stat.setInt(3, daysOfReservation);
            stat.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update() {
        try {
            
            stat = conn.prepareStatement("update residents set DaysofReservation=? where name= ? ");
            stat.setInt(1, daysOfReservation);
            stat.setString(2, name);
            stat.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete() {
        try {
            
            stat = conn.prepareStatement("delete from residents where name=? ");
            stat.setString(1, name);
            stat.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDaysOfReservation(int daysOfReservation) {
        this.daysOfReservation = daysOfReservation;
    }
    
    
}
