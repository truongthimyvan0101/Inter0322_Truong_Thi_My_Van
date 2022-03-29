package controllers;


import services.impl.CustomerServiceImpl;
import services.impl.EmployeeServiceImpl;
import services.impl.FacilityServiceImpl;

import java.util.Scanner;

public class FuramaController {
    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        boolean check = true;
        int choice = 0;
        while (check) {
            System.out.println("1.Employee Management");
            System.out.println("2.Customer Management");
            System.out.println("3.Facility Management");
            System.out.println("4.Booking Management");
            System.out.println("5.Promotion Management");
            System.out.println("6.Exits");
            Scanner scanner = new Scanner(System.in);//cho người dùng nhập vào
            try {
                choice = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Bạn đã nhập sai, xin vui lòng nhập lại");
            }

            switch (choice) {
                case 1: {
                    displayEmployeeMenu();
                    break;
                }
                case 2:{
                    displayCustomerMenu();
                    break;
                }
            }
        }

    }

    private static void displayEmployeeMenu() {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        boolean check = true;
        int employeeOption = 0;
        while (check){
            System.out.println("1.Display list employee");
            System.out.println("2.Add New employees");
            System.out.println("3.Edit employees");
            System.out.println("4.Back to menu");
            Scanner scanner = new Scanner(System.in);
            try {
                employeeOption = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Bạn đã nhập sai, vui lòng nhập lại");
            }
            switch (employeeOption){
                case 1: {
                    employeeService.display();// gọi phuong thức display ra để hiển thị list employee
                    break;
                }
                case 2:{
                    employeeService.addNew();
                    break;
                }
                case 3:{
                    employeeService.edit();
                    break;
                }
            }

        }

    }
    private static void displayCustomerMenu() {
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        boolean check = true;
        int customerOption = 0;
        while (check) {
            System.out.println("1.Display list customer");
            System.out.println("2.Add New customer");
            System.out.println("3.Edit customer");
            System.out.println("4.Back to menu");
            Scanner scanner = new Scanner(System.in);
            try {
                customerOption = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Bạn đã nhập sai, xin vui lòng nhập lại");
            }
            switch (customerOption){
                case 1: {
                    customerService.display();// gọi phuong thức display ra để hiển thị list employee
                    break;
                }
                case 2:{
                    customerService.addNew();
                    break;
                }
                case 3:{
                    customerService.edit();
                    break;
                }
            }

        }

    }

    public static void addNewServies() {
        boolean check = true;
        while (check) {
            System.out.println("1.Add New Villa");
            System.out.println("2.Add New House");
            System.out.println("3.Add New Room");
            System.out.println("4.Back to menu");
            System.out.println("5.Exit");
            Scanner scanner = new Scanner(System.in);//cho người dùng nhập vào
            switch (scanner.nextInt()) {
                case 1:
            }
        }
    }


    public static void showServices() {
        boolean check = true;
        while (check) {
            System.out.println("1.Show all Villa");
            System.out.println("2.Show all House");
            System.out.println("3.Show all Room");
            System.out.println("4.Show All Name Villa Not Duplicate");
            System.out.println("5.Show All Name House Not Duplicate");
            System.out.println("6.Show All Name Name Not Duplicate");
            System.out.println("7.Back to menu");
            System.out.println("8.Exit");
            Scanner scanner = new Scanner(System.in);//cho người dùng nhập vào
            switch (scanner.nextInt()) {
                case 1:

            }
        }
    }
    public static void addNewCustomer() {
        boolean check = true;
        while (check) {
            System.out.println("1.Show all Villa");
            System.out.println("2.Show all House");
            System.out.println("3.Show all Room");
            System.out.println("4.Show All Name Villa Not Duplicate");
            System.out.println("5.Show All Name House Not Duplicate");
            System.out.println("6.Show All Name Name Not Duplicate");
            System.out.println("7.Back to menu");
            System.out.println("8.Exit");
            Scanner scanner = new Scanner(System.in);//cho người dùng nhập vào
            switch (scanner.nextInt()) {
                case 1:
            }
        }
    }
}

