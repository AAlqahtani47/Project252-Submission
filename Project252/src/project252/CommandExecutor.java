/*
Name: Abdulrahman Alqahtani 
ID: 1846618
 */
package project252;

public class CommandExecutor {
    private Commands buffetMenu;
    private Commands resident;
    private Commands employee;
    
    public CommandExecutor() {
        buffetMenu = new BuffetMenu();
        resident = new Residents();
        employee = new Employees();
    }
   
    
    public void deleteEmployee(){
        employee.delete();
    }
    
    public void insertEmployee(){
        employee.insert();
    }
    
    public void updateEmployee(){
        employee.update();
    }
    
    
    public void deleteResidents(){
        resident.delete();
    }
    
    public void insertResidents(){
        resident.insert();
    }
    
    public void updateResidents(){
        resident.update();
    }
    
    
    public void deleteMenuItem(){
        buffetMenu.delete();
    }   
    
    public void insertMenuItem(){
        buffetMenu.insert();
    }
    
    public void updateMenuItem(){
        buffetMenu.update();
    }
        
}
    
