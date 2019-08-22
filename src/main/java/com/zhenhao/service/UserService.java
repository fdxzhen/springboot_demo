package com.zhenhao.service;

import com.zhenhao.bean.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUser();
    public User getUserById(int id);
    public void insertUser(User user);
    public void deleteById(int id);
    public void editByUser(User user);
}
