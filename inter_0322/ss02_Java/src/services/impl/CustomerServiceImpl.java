package services.impl;



import models.Customer;
import services.CustomerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {

    private static List<Customer> customerList = new ArrayList<>();// Tạo 1 arraylist có kiểu dl là employee để lưu trữ employee
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        for (Customer customer:customerList){
            System.out.println(customer.toString());
        }

    }

    @Override
    public void addNew() {
        System.out.println("Nhập id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên");
        String name = scanner.nextLine();
        System.out.println("Nhập tuổi");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập giới tính");
        String gender = scanner.nextLine();
        System.out.println("Nhập chứng minh");
        String idCard = scanner.nextLine();
        System.out.println("Nhập Email");
        String email = scanner.nextLine();
        System.out.println("Nhập loại khách hàng");
        String typeCustomer = scanner.nextLine();
        System.out.println("Nhập địa chỉ");
        String address = scanner.nextLine();;
        Customer customer = new Customer(id, name, age, gender, idCard, email, typeCustomer,address);
        customerList.add(customer);// đưa vào employeeList để lưu trữ
        System.out.println("Đã thêm mới khách hàng thành công");


    }

    @Override
    public void edit() {

    }

    @Override
    public void delete() {

    }
}