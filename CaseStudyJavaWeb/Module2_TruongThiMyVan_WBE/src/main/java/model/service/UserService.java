package model.service;

import model.bean.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    boolean isUser(User user);
}