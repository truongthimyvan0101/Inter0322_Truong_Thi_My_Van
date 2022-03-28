package models;

import java.io.Serializable;

public class Booking implements Serializable {
    private int id;
    private String startDate;
    private String endDate;
    private Customer customer;
    private Facility facility;

    public Booking() {
    }

    public Booking(int idCustomer, String startDate, String endDate, Customer customer, Facility facility) {
        this.id = idCustomer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customer = customer;
        this.facility = facility;
    }

    public int getIdCustomer() {
        return id;
    }

    public void setIdCustomer(int idCustomer) {
        this.id = idCustomer;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "idCustomer='" + id + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", customer=" + customer.getId() +
                ", facility=" + facility.getIdFacility() +
                '}';
    }
}
