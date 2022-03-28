package models;

import java.io.Serializable;

public class Contract implements Serializable {
    private int id;
    private Booking booking;
    private double prepayment;
    private double total;
    private Customer customer;

    public Contract() {
    }

    public Contract(int id, Booking booking, double prepayment, double total, Customer customer) {
        this.id = id;
        this.booking = booking;
        this.prepayment = prepayment;
        this.total = total;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public double getPrepayment() {
        return prepayment;
    }

    public void setPrepayment(double prepayment) {
        this.prepayment = prepayment;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id='" + id + '\'' +
                ", booking=" + booking +
                ", prepayment='" + prepayment + '\'' +
                ", total='" + total + '\'' +
                ", customer=" + customer +
                '}';
    }
}
