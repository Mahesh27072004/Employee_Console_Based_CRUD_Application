package com.controller;

import com.dao.CrudEmployeeRepository;
import com.dao.CrudEmployeeRepositoryImpl;
import com.dto.EmployeeDTO;
import com.service.EmployeeService;
import com.service.EmployeeServiceImpl;

import java.util.ArrayList;
import java.util.Scanner;

public class Launch {
    static Scanner scanner = new Scanner(System.in);
    private static EmployeeService employeeService;
    private static String result;
    public static void main(String[] args) {
        while (true){
            System.out.println("\n 1.Insert \n 2.Read \n 3.Update \n 4.Delete \n 5.Exit \n");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if(choice==5){
                System.out.println("thanks for using our app");
                break;
            }
            switch(choice){
                case 1:
                    insert();
                    break;
                case 2:
                    System.out.println("\n 1.Read Specific Data \n 2.Read All Data \n ");
                    System.out.println("Enter your Choice:");
                    int ch = scanner.nextInt();
                    switch (ch){
                        case 1:
                            read();
                            break;
                        case 2:
                            readAll();
                            break;
                        default:
                            System.out.println("Invalid choice");
                            break;
                    }
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    delete();
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
    public static void insert(){
        try{
            System.out.println("enter username: ");
            String username = scanner.nextLine();

            System.out.println("enter Password: ");
            String password = scanner.nextLine();

            System.out.println("enter emp id: ");
            int Eid = scanner.nextInt();

            System.out.println("Enter emp name: ");
            String Ename = scanner.next();

            scanner.nextLine();
            System.out.println("Enter emp address: ");
            String Eaddress = scanner.nextLine();

            System.out.println("Enter emp salary: ");
            int Esalary = scanner.nextInt();

            EmployeeDTO emp = new EmployeeDTO(username,password,Eid, Ename, Eaddress, Esalary);
            EmployeeService empService = new EmployeeServiceImpl();

            String result = empService.insertService(emp);
            System.out.println(result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void read(){
       try{
           scanner.nextLine();
            System.out.println("enter username: ");
            String username = scanner.nextLine();

            System.out.println("enter Password: ");
            String password = scanner.nextLine();

            EmployeeService employeeService = new EmployeeServiceImpl();
            String result = employeeService.readService(username, password);
            System.out.println(result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void readAll(){
        try{
            EmployeeService employeeService = new EmployeeServiceImpl();
            ArrayList<EmployeeDTO> emp= employeeService.readAllService();
            for(EmployeeDTO dto:emp){
                System.out.println(dto);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void update(){
        try{

            System.out.println("\n 1.Employee name \n 2.Employee address\n 3.Employee salary \n 4.username \n 5.password \n");
            System.out.print("Choose What you want to update(between 1 to 5): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            int eid;
            String ename;
            String eaddress;
            String username;
            String password;
            int esalary;

            switch(choice){
                case 1:
                    System.out.println("Enter eid: ");
                    eid = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter New Employee name: ");
                    ename = scanner.nextLine();
                    System.out.println("Enter your password: ");
                    password = scanner.nextLine();
                    employeeService= new EmployeeServiceImpl();
                    result = employeeService.updateENameService(eid, ename, password);
                    System.out.println(result);
                    break;
                case 2:
                    System.out.println("Enter eid: ");
                     eid = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter New Employee Address: ");
                    eaddress = scanner.nextLine();
                    System.out.println("Enter your password: ");
                    password = scanner.nextLine();
                    employeeService= new EmployeeServiceImpl();
                    result = employeeService.updateEaddressService(eid, eaddress, password);
                    System.out.println(result);
                    break;
                case 3:
                    System.out.println("Enter emp id: ");
                    eid = scanner.nextInt();

                    System.out.println("Enter new salary: ");
                    esalary = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter your password: ");
                    password = scanner.nextLine();
                    employeeService = new EmployeeServiceImpl();
                    result = employeeService.updateEsalaryService(eid, esalary, password);
                    System.out.println(result);
                    break;

                case 4:
                    System.out.println("Enter emp id: ");
                    eid = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter new username: ");
                    username = scanner.nextLine();
                    System.out.println("Enter your password: ");
                    password = scanner.nextLine();

                    employeeService = new EmployeeServiceImpl();
                    result = employeeService.updateUsernameService(eid, username, password);
                    System.out.println(result);
                    break;
                case 5:
                    System.out.println("Enter emp id: ");
                    eid = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter new password: ");
                    String newPassword = scanner.nextLine();
                    System.out.println("Enter your password: ");
                    password = scanner.nextLine();
                    employeeService = new EmployeeServiceImpl();
                    result = employeeService.updatePasswordService(eid, newPassword, password);
                    System.out.println(result);
                    break;
                default:
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void delete(){
        try{
            System.out.println("enter emp id: ");
            int eid = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter new password: ");
            String password = scanner.nextLine();
            employeeService = new EmployeeServiceImpl();
            result = employeeService.deleteService(eid,password);
            System.out.println(result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

