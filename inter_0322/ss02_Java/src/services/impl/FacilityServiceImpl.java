package services.impl;

import l20_case_study.models.*;
import l20_case_study.services.FacilityService;
import l20_case_study.utils.ReadAndWriteFile;
import l20_case_study.utils.RegexData;

import java.util.*;

public class FacilityServiceImpl implements FacilityService {

    public static final String REGEX_ID = "1";
    public static final String REGEX_NAME = "1";
    public static final String REGEX_PRICE = "1";
    public static final String REGEX_AREA = "1";
    public static final String REGEX_RENTAL_PEOPLE_MAX = "1";
    public static final String REGEX_STYLE_RENTAL = "1";
    public static final String REGEX_STANDARD_VILLA = "1";
    public static final String REGEX_AREA_POOL =  "1";
    public static final String REGEX_NUMBER_FLOOR = "1";
    public static final String REGEX_DIRECTION = "1";
    public static final String REGEX_FURNITURE = "1";



    private static Map<Facility, Integer> facilityList = new LinkedHashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    private String inputId(){
        System.out.println("Enter id facility: ");
        return RegexData.regexStr(scanner.nextLine(), REGEX_ID, "You had entered wrong format, id facility is as SVL-xxxx");
    }

    private String inputName(){
        System.out.println("Enter name facility: ");
        return RegexData.regexStr(scanner.nextLine(), REGEX_NAME, "You had entered wrong format, name facility has to have the upper word in the first");
    }

    private String inputArea(){
        System.out.println("Enter area facility: ");
        return RegexData.regexStr(scanner.nextLine(), REGEX_AREA, "You had entered wrong format, area facility has to be more than 30");
    }

    private String inputPrice(){
        System.out.println("Enter price facility: ");
        return RegexData.regexStr(scanner.nextLine(), REGEX_PRICE, "You had entered wrong format, price facility has to be more than 0");
    }

    private String inputRentalPeopleMax(){
        System.out.println("Enter rental people max: ");
        return RegexData.regexStr(scanner.nextLine(),REGEX_RENTAL_PEOPLE_MAX, "You had entered wrong format, rental people max should be more than 0");
    }

    private String inputStyleRental(){
        System.out.println("Enter style rental: ");
        return RegexData.regexStr(scanner.nextLine(), REGEX_STYLE_RENTAL, "You had entered wrong format");
    }

    private String inputStandardVilla(){
        System.out.println("Enter the standard villa: ");
        return RegexData.regexStr(scanner.nextLine(), REGEX_STANDARD_VILLA, "You had entered wrong format");
    }

    private String inputAreaPool(){
        System.out.println("Enter the area pool: ");
        return RegexData.regexStr(scanner.nextLine(), REGEX_AREA_POOL, "You had entered wrong format");
    }

    private String inputNumberOfFloor(){
        System.out.println("Enter number of floor: ");
        return RegexData.regexStr(scanner.nextLine(), REGEX_NUMBER_FLOOR, "You had entered wrong format");
    }

    private String inputDirection(){
        System.out.println("Enter direction: ");
        return RegexData.regexStr(scanner.nextLine(), REGEX_DIRECTION, "You had entered wrong format");
    }

    private String inputFurniture(){
        System.out.println("Enter furniture: ");
        return RegexData.regexStr(scanner.nextLine(), REGEX_FURNITURE, "You had entered wrong format");
    }


    @Override
    public void display() {
        for (Map.Entry<Facility, Integer> element : facilityList.entrySet()){
            System.out.println("service: " + element.getKey() + " number of rent: " + element.getValue());
        }
    }


    @Override
    public void addNewVilla() {
        String id = inputId();

        String name = inputName();

        Double area =Double.parseDouble(inputArea());

        int price = Integer.parseInt(inputPrice());

        int rentalPeopleMax = Integer.parseInt(inputRentalPeopleMax());

        String styleRental = inputStyleRental();

        String standardVilla = inputStandardVilla();

        double areaPool = Double.parseDouble(inputAreaPool());

        int floor = Integer.parseInt(inputNumberOfFloor());

        Villa villa = new Villa(id, name, area, price, rentalPeopleMax, styleRental, standardVilla, areaPool, floor);

        if (facilityList.containsKey(villa)){
            facilityList.put(villa, facilityList.get(villa) + 1);
        }else {
            facilityList.put(villa, 1);
        }

        ReadAndWriteFile.write((Collection) facilityList, "D:\\nhat_coder\\CodeGym\\GIT_HUB\\module2\\src\\l20_case_study\\data\\facility\\villa.csv");

        System.out.println("Successfully");
    }


    @Override
    public void addNewHouse() {
        String id = inputId();
        String name = inputName();

        Double area =Double.parseDouble(inputArea());

        int price = Integer.parseInt(inputPrice());

        int rentalPeopleMax = Integer.parseInt(inputRentalPeopleMax());

        String styleRental = inputStyleRental();

        String direction = inputDirection();

        int floor = Integer.parseInt(inputNumberOfFloor());

        House house = new House(id, name, area, price, rentalPeopleMax, styleRental, direction, floor);

        if (facilityList.containsKey(house)){
            facilityList.put(house, facilityList.get(house) + 1);
        }else {
            facilityList.put(house, 1);
        }

        ReadAndWriteFile.write((Collection) facilityList, "D:\\nhat_coder\\CodeGym\\GIT_HUB\\module2\\src\\l20_case_study\\data\\facility\\house.csv");

        System.out.println("Successfully");
    }

    @Override
    public void addNewRoom() {
        String id = inputId();
        String name = inputName();

        Double area =Double.parseDouble(inputArea());

        int price = Integer.parseInt(inputPrice());

        int rentalPeopleMax = Integer.parseInt(inputRentalPeopleMax());

        String styleRental = inputStyleRental();

        String furniture = inputFurniture();

        Room room = new Room(id, name, area, price, rentalPeopleMax, styleRental, furniture);
        if (facilityList.containsKey(room)){
            facilityList.put(room, facilityList.get(room) + 1);
        }else {
            facilityList.put(room, 1);
        }

        ReadAndWriteFile.write((Collection) facilityList, "D:\\nhat_coder\\CodeGym\\GIT_HUB\\module2\\src\\l20_case_study\\data\\facility\\room.csv");
        System.out.println("Successfully");
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
}
