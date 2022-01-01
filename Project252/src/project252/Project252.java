/*
Name: Abdulrahman Alqahtani 
ID: 1846618
 */
package project252;

import java.sql.*;
import java.util.Scanner;

public class Project252 {

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);

        Connection conn = DBConnection.getDBInstance();
        CommandExecutor cExecutor = new CommandExecutor();
        Statement stat = conn.createStatement();

        String choice = menu1(sc, cExecutor);

    }

    
    
    
    public static String menu1(Scanner sc, CommandExecutor cExecutor) {
        Employees emp = new Employees();
        BuffetMenu bm = new BuffetMenu();
        Residents rsd = new Residents();

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
        System.out.println("4. Exit");
        System.out.print("Choice: ");
        choice = Integer.parseInt(sc.nextLine());

        if (choice == 1) {

            System.out.println("Choose a table to delete from by pressing the corresponding number: ");
            ch = menu2(sc);

            if (ch.equalsIgnoreCase("employees")) {
                System.out.print("\nPlease enter name:");
                name = sc.next();
                emp.setName(name);
                cExecutor.deleteEmployee();
            
            } else if (ch.equalsIgnoreCase("residents")) {
                System.out.print("\nPlease enter name:");
                name = sc.next();
                rsd.setName(name);
                cExecutor.deleteResidents();
           
            } else if (ch.equalsIgnoreCase("buffet menu")) {
                System.out.print("Please enter menu item name:");
                name = sc.next();
                bm.setName(name);
                cExecutor.deleteMenuItem();
            }

        } else if (choice == 2) {

            System.out.println("Choose a table to insert to by pressing the corresponding number: ");
            ch = menu2(sc);
            System.out.println("****************************");
            if (ch.equalsIgnoreCase("employees")) {
                System.out.print("Please enter 7-digit employee ID:");
                id = sc.nextInt();
                emp.setId(id);
                
                System.out.print("\nPlease enter first and last name:");
                name = sc.next();
                emp.setName(name);
                System.out.print("\nPlease enter employee salary: ");
                salary = sc.nextInt();
                emp.setSalary(salary);
                System.out.print("\nPlease enter employee department: ");
                dept = sc.next();
                emp.setDepartment(dept);
                cExecutor.insertEmployee();
                
            } else if (ch.equalsIgnoreCase("residents")) {
                System.out.print("Please enter resident ID:");
                id = sc.nextInt();
                rsd.setId(id);
                System.out.print("\nPlease enter first and last name:");
                name = sc.next();
                rsd.setName(name);
                System.out.print("\nPlease enter resident days of reservation: ");
                days = sc.nextInt();
                rsd.setDaysOfReservation(days);
                cExecutor.insertResidents();
                
            } else if (ch.equalsIgnoreCase("buffet menu")) {
                System.out.print("Please enter menu item name:");
                name = sc.next();
                bm.setName(name);
                System.out.print("\nPlease enter quantity:");
                quantity = sc.nextInt();
                bm.setQuantity(quantity);
                cExecutor.insertMenuItem();
            }

        } else if (choice == 3) {
 
            System.out.println("Choose a table to update by pressing the corresponding number: ");
            ch = menu2(sc);

            if (ch.equalsIgnoreCase("employees")) {
                System.out.print("\nPlease enter first and last name:");
                name = sc.next();
                emp.setName(name);
                System.out.print("\nPlease enter new employee salary: ");
                salary = sc.nextInt();
                emp.setSalary(salary);
                cExecutor.updateEmployee();
            
            } else if (ch.equalsIgnoreCase("residents")) {
                System.out.print("\nPlease enter new resident days of reservation: ");
                days = sc.nextInt();
                rsd.setDaysOfReservation(days);
                System.out.print("\nPlease enter first and last name:");
                name = sc.next();
                emp.setName(name);
                cExecutor.updateResidents();
                
            } else if (ch.equalsIgnoreCase("buffet menu")) {
                System.out.print("\nPlease enter new quantity:");
                quantity = sc.nextInt();
                bm.setQuantity(quantity);
                System.out.print("Please enter menu item name:");
                name = sc.next();
                bm.setName(name);
                cExecutor.updateMenuItem();
            }

        } else if (choice == 4) {
            System.out.println("************** Thank You For Using Hotel Management System **************");
            System.exit(0);
        }
        return null;
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
