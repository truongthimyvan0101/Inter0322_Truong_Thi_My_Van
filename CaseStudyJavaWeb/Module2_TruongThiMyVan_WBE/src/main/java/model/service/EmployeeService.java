package model.service;

import model.bean.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    boolean save(Employee employee);

    Employee findById(int id);

    boolean update(Employee employee, int employee_id);

    boolean delete(int employee_id);

    List<Employee> search(String employee_name, String employee_address);
}