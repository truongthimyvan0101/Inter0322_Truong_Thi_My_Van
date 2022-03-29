package services.impl;


import models.Facility;
import services.FacilityService;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements FacilityService {
    private static Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    private Facility villa;

    @Override
    public void display() {
        for (Map.Entry<Facility, Integer> element : facilityIntegerMap.entrySet()){
            System.out.println("Service" + element.getKey() + "số lần đã thuê: " + element.getValue());
        }

    }

    @Override
    public void addNew() {

    }

    @Override
    public void edit() {

    }

    @Override
    public void delete() {


    }

    @Override
    public void displayMaintenance() {

    }

    //    int floor;
    @Override
    public void addNewVilla() {
        System.out.println("Nhập id: ");
        String id = scanner.nextLine();
        System.out.println("Nhập tên");
        String name = scanner.nextLine();
        System.out.println("Nhập diện tích");
        double area = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập giá tiền");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập số lượng người");
        int people = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập kiểu thuê");
        String rentType = scanner.nextLine();
        System.out.println("Nhập tiêu chuẩn");
        String standard = scanner.nextLine();
        System.out.println("Nhập diện tích hồ bơi");
        Double areaPool = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập số tầng");
        int floor = Integer.parseInt(scanner.nextLine());
        Facility facility = new Facility(id, name, area, price, people, rentType, standard, areaPool, floor) ;
        facilityIntegerMap.put(villa, 0);
        System.out.println("Đã thêm mới villa thành công");
    }

    @Override
    public void addNewHouse() {

    }

    ;





    @Override
    public void addNewRoom() {

    }
}
