package model.repository;

import model.bean.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();
}
