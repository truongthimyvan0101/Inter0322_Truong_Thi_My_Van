package services.impl;

import l20_case_study.models.Booking;
import l20_case_study.models.Contract;
import l20_case_study.models.Customer;
import l20_case_study.services.ContractService;
import l20_case_study.utils.ReadAndWriteFile;

import java.util.*;

public class ContractServiceImpl implements ContractService {

    private static List<Contract> contractList = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        contractList = (List<Contract>) ReadAndWriteFile.read("D:\\nhat_coder\\CodeGym\\GIT_HUB\\module2\\src\\l20_case_study\\data\\contract.csv");
        if (contractList == null){
            System.out.println("There is nothing to display");
        }else {
            for (Contract contract : contractList){
                System.out.println(contract.toString());
            }
        }
    }

    @Override
    public void addNew() {
        Queue<Booking> bookingQueue = new LinkedList<>();
        Set<Booking> bookingSet = new BookingServiceImpl().sendBooking();

        for (Booking booking : bookingSet){
            bookingQueue.add(booking);
        }

        while (!bookingQueue.isEmpty()){
            Booking booking = bookingQueue.poll();
            Customer customer = booking.getCustomer();

            System.out.println("The contract is being created: " + booking.toString());
            System.out.println("The customer is being created: " + customer.toString());

            System.out.println("Enter id: ");
            int id = 0;
            try {
                id = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("You had entered the wrong number format, please enter again");
            }

            System.out.println("Prepayment amount: ");
            double prepayment = 0;
            try {
                prepayment = Double.parseDouble(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("You had entered the wrong number format, please enter again");
            }

            System.out.println("Price total: ");
            double total = 0;
            try {
                total = Double.parseDouble(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("You had entered the wrong number format, please enter again");
            }

            Contract contract = new Contract(id, booking, prepayment, total, customer);
            contractList.add(contract);
            ReadAndWriteFile.write(contractList, "D:\\nhat_coder\\CodeGym\\GIT_HUB\\module2\\src\\l20_case_study\\data\\contract.csv");

            System.out.println("Successfully: " + contract.toString());
        }
    }

    @Override
    public void edit() {
        System.out.print("Enter id contract that you want to edit");
        int id = 0;
        try {
            id = Integer.parseInt(scanner.nextLine());
        }catch (NumberFormatException e){
            System.out.println("You had entered the wrong number format, please enter again");
        }

        for (int i = 0; i < contractList.size(); i++) {
            if (contractList.get(i).getId() == id){

            }
        }
    }

    @Override
    public void delete() {

    }
}
