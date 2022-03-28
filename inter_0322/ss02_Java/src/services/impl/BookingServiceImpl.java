package services.impl;

import l20_case_study.models.Booking;
import l20_case_study.models.Customer;
import l20_case_study.models.Facility;
import l20_case_study.models.Villa;
import l20_case_study.services.BookingService;
import l20_case_study.utils.BookingComparator;
import l20_case_study.utils.ReadAndWriteFile;

import java.util.*;

public class BookingServiceImpl implements BookingService {
    private static Set<Booking> bookingTreeSet = new TreeSet<>(new BookingComparator());

    private static List<Customer> customerList = new ArrayList<>();

    private static Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();

    public Set<Booking> sendBooking(){
        return bookingTreeSet;
    }

    private static Scanner scanner = new Scanner(System.in);



    @Override
    public void display() {
        bookingTreeSet = (Set<Booking>) ReadAndWriteFile.read("D:\\nhat_coder\\CodeGym\\GIT_HUB\\module2\\src\\l20_case_study\\data\\booking.csv");
        if (bookingTreeSet == null){
            System.out.println("There is nothing to display");
        }else {
            for (Booking booking : bookingTreeSet){
                System.out.println(booking.toString());
            }
        }
    }

    @Override
    public void addNew() {
        int id = 1;
        if (!bookingTreeSet.isEmpty()){
            id = bookingTreeSet.size();
        }

        Customer customer = chooseCustomer();
        Facility facility = chooseFacility();

        System.out.print("Start time: ");
        String startDate = scanner.nextLine();
        System.out.print("End time: ");
        String endDate = scanner.nextLine();

        Booking booking = new Booking(id, startDate, endDate, customer, facility);

        bookingTreeSet.add(booking);

        ReadAndWriteFile.write(bookingTreeSet, "D:\\nhat_coder\\CodeGym\\GIT_HUB\\module2\\src\\l20_case_study\\data\\booking.csv");
        System.out.println("Successfully");
    }

    public static Customer chooseCustomer(){
        System.out.println("List customer: ");
        for (Customer customer : customerList){
            System.out.println(customer.toString());
        }

        System.out.print("Enter id customer: ");
        int id;
        while (true){
            try {
                id = Integer.parseInt(scanner.nextLine());
                break;
            }catch (NumberFormatException e){
                System.out.println("You had entered the wrong number format, please enter again");
            }
        }


        boolean check = true;
        while (check){
            for (Customer customer : customerList){
                if (customer.getId().equals(id)){
                    check = false;
                    return customer;
                }
            }

            if (check){
                System.out.println("Error id, please enter id customer again: ");
                id = Integer.parseInt(scanner.nextLine());
            }
        }
        return null;
    }

    public static Facility chooseFacility(){
        System.out.println("List facility: ");

        for (Map.Entry<Facility, Integer> entry : facilityIntegerMap.entrySet()){
            System.out.println(entry.getKey().toString());
        }

        System.out.print("Enter id facility: ");
        int id;
        while (true){
            try {
                id = Integer.parseInt(scanner.nextLine());
                break;
            }catch (NumberFormatException e){
                System.out.println("You had entered the wrong number format, please enter again");
            }
        }
        boolean check = true;

        while (check){
            for (Map.Entry<Facility, Integer> entry : facilityIntegerMap.entrySet()){
                if (entry.getKey().getIdFacility().equals(id)){
                    check = false;
                    return entry.getKey();
                }
            }

            if (check){
                System.out.println("Error id, please enter id facility again: ");
                id = Integer.parseInt(scanner.nextLine());
            }
        }
        return null;
    }

    @Override
    public void edit() {

    }

    @Override
    public void delete() {

    }
}
