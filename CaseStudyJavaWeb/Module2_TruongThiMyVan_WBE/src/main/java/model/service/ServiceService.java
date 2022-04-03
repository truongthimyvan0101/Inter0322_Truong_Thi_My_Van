package model.service;

import model.bean.Service;

import java.util.List;

public interface ServiceService {
    List<Service> findAll();

    boolean save(Service service);

    Service findById(int id);

    boolean update(Service service, int service_id);

    boolean delete(int service_id);

    List<Service> search(String service_name);
}