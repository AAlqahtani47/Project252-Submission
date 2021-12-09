/*
Name: Abdulrahman Alqahtani 
ID: 1846618
 */
package hotelmanagementproject252;

import java.sql.*;
import java.util.Scanner;

public class HotelManagementProject252 {

    public static void main(String[] args) throws SQLException {
        
        Scanner sc = new Scanner(System.in);
        Connection conn = SingletonDBConn.getDBInstance();
        Statement st = conn.createStatement();
        PreparedStatement stat;
        ResultSet rs;
        int id;
        String name;
        int salary;
        String dept;
        int days;
        int quantity;
        String ch;
        int choice;

        System.out.println("************** Welcome To The Hotel Management System **************");
        System.out.println("Choose a service by pressing the corresponding number: ");
        System.out.println("1. Deleting");
        System.out.println("2. Inserting");
        System.out.println("3. Updating");
        System.out.println("4. Selecting");
        System.out.print("Choice: ");
        choice = Integer.parseInt(sc.nextLine());

        if (choice == 1) {

            System.out.println("Choose a table to delete from by pressing the corresponding number: ");
            ch = menu2(sc);

            if (ch.equalsIgnoreCase("employees")) {
                System.out.print("\nPlease enter name:");
                name = sc.next();

                stat = conn.prepareStatement("delete from `employees` where EmpName=? ");
                stat.setString(1, name);
                stat.executeUpdate();

            } else if (ch.equalsIgnoreCase("residents")) {
                System.out.print("\nPlease enter name:");
                name = sc.next();

                stat = conn.prepareStatement("delete from `residents` where Rname=? ");
                stat.setString(1, name);
                stat.executeUpdate();

            } else if (ch.equalsIgnoreCase("buffet menu")) {
                System.out.print("Please enter menu item name:");
                name = sc.next();

                stat = conn.prepareStatement("delete from `buffetmenu` where Itemname=? ");
                stat.setString(1, name);
                stat.executeUpdate();

            }

        } else if (choice == 2) {

            System.out.println("Choose a table to insert to by pressing the corresponding number: ");
            ch = menu2(sc);
            System.out.println("****************************");
            if (ch.equalsIgnoreCase("employees")) {
                System.out.print("Please enter employee ID:");
                id = sc.nextInt();

                System.out.print("\nPlease enter first name:");
                name = sc.next();

                System.out.print("\nPlease enter employee salary: ");
                salary = sc.nextInt();

                System.out.print("\nPlease enter employee department: ");
                dept = sc.next();

                stat = conn.prepareStatement("insert into `Employees` values (?, ?, ?, ?)");
                stat.setString(1, name);// name
                stat.setInt(2, salary);// salary
                stat.setString(3, dept);//department
                stat.setInt(4, id);// id
                stat.executeUpdate();

            } else if (ch.equalsIgnoreCase("residents")) {
                System.out.print("Please enter resident ID:");
                id = sc.nextInt();

                System.out.print("\nPlease enter first name:");
                name = sc.next();

                System.out.print("\nPlease enter resident days of reservation: ");
                days = sc.nextInt();

                stat = conn.prepareStatement("insert into `Residents` values (?, ?, ?)");
                stat.setString(1, name);//name
                stat.setInt(2, days);//days
                stat.setInt(3, id);//id
                stat.executeUpdate();

            } else if (ch.equalsIgnoreCase("buffet menu")) {
                System.out.print("Please enter menu item name:");
                name = sc.next();

                System.out.print("\nPlease enter quantity:");
                quantity = sc.nextInt();

                stat = conn.prepareStatement("insert into `BuffetMenu` values (?, ?)");
                stat.setString(1, name);
                stat.setInt(2, quantity);
                stat.executeUpdate();
            }

        } else if (choice == 3) {

            System.out.println("Choose a table to update by pressing the corresponding number: ");
            ch = menu2(sc);

            if (ch.equalsIgnoreCase("employees")) {
                System.out.print("\nPlease enter first name:");
                name = sc.next();

                System.out.print("\nPlease enter new employee salary: ");
                salary = sc.nextInt();

                stat = conn.prepareStatement("update `employees` set salary=? where Empname=? ");
                stat.setInt(1, salary);
                stat.setString(2, name);
                stat.executeUpdate();

            } else if (ch.equalsIgnoreCase("residents")) {
                System.out.print("\nPlease enter first name:");
                name = sc.next();

                System.out.print("\nPlease enter new resident days of reservation: ");
                days = sc.nextInt();

                stat = conn.prepareStatement("update `residents` set DaysofReserve=? where Rname=? ");
                stat.setInt(1, days);
                stat.setString(2, name);
                stat.executeUpdate();

            } else if (ch.equalsIgnoreCase("buffet menu")) {
                System.out.print("Please enter menu item name:");
                name = sc.next();

                System.out.print("\nPlease enter new quantity:");
                quantity = sc.nextInt();

                stat = conn.prepareStatement("update `buffetmenu` set quantity=? where Itemname=? ");
                stat.setInt(1, quantity);
                stat.setString(2, name);
                stat.executeUpdate();

            }

        } else if (choice == 4) {
            System.out.println("Choose a table to select by pressing the corresponding number: ");
            ch = menu2(sc);

            if (ch.equalsIgnoreCase("employees")) {
                rs = st.executeQuery("Select * from employees");
                
                while (rs.next()) {
                    System.out.println("\n" + rs.getString(4) + "\t" + rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
                }

            } else if (ch.equalsIgnoreCase("residents")) {
                rs = st.executeQuery("Select * from residents");
                
                while (rs.next()) {
                    System.out.println("\n" + rs.getString(3) + "\t" + rs.getString(1) + "\t" + rs.getString(2));
                }

            } else if (ch.equalsIgnoreCase("buffet menu")) {
                rs = st.executeQuery("Select * from buffetmenu");
                
                while (rs.next()) {
                    System.out.println("\n" + rs.getString(1) + "\t" + rs.getString(2));
                }

            }
        }

    }

    public static String menu2(Scanner sc) {
        System.out.println("****************************");
        System.out.println("1. Employees");
        System.out.println("2. Residents");
        System.out.println("3. Buffet Menu");
        System.out.print("Choice: ");
        int choice = 0;

        choice = Integer.parseInt(sc.nextLine());;
        if (choice == 1) {
            return "employees";
        } else if (choice == 2) {
            return "residents";
        } else if (choice == 3) {
            return "buffet menu";
        }
        return null;

    }
}
