package model.service;

import model.bean.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerService {
    List<Customer> findAll();
    Map<String, String> save(Customer customer);

    Customer findById(int id);

    boolean update(Customer customer, int id);

    boolean delete(int id);

    List<Customer> search(String customer_name, String customer_address);
}
