/*
Name: Abdulrahman Alqahtani 
ID: 1846618
 */
package project252;

import java.sql.Connection;
import java.sql.*;

public class Employees implements Commands {

    Connection conn = DBConnection.getDBInstance();
    PreparedStatement stat;

     int id;
     String name;
     int salary;
     String dept;
    String ins;
    public void insert() {
        try {
            stat = conn.prepareStatement("insert into `Employees` values (?, ?, ?, ?)");
                stat.setString(1, name);// name
                stat.setInt(2, salary);// salary
                stat.setString(3, dept);//department
                stat.setInt(4, id);// id
                stat.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }

    public void update() {
       try {
            
            stat = conn.prepareStatement("update employees set salary=? where name=? ");
            stat.setDouble(1, salary);
            stat.setString(2, name);
            stat.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void delete() {
      try {
            
            stat = conn.prepareStatement("delete from employees where name=? ");
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

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDepartment(String department) {
        this.dept = department;
    }

}
