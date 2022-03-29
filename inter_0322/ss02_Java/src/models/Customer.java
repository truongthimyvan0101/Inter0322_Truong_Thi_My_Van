package models;

public class Customer extends Person {
    private String typeCustomer;

    public Customer(int id, String name, int age, String gender, String idCard, String email, String typeCustomer, String address) {
    }

    public Customer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public Customer(String id, String name, String age, String sex, String idCard, String email, String address, String typeCustomer) {
        super(id, name, age, sex, idCard, email, address);
        this.typeCustomer = typeCustomer;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "typeCustomer='" + typeCustomer + '\'' +
                '}';
    }
}
