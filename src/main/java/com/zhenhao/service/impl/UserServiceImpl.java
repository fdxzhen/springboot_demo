package com.zhenhao.service.impl;

import com.zhenhao.bean.User;
import com.zhenhao.dao.UserDao;
import com.zhenhao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public List<User> getAllUser() {
        return  userDao.getAllUser();
    }

    public User getUserById(int id){
        return userDao.getUserById(id);
    }

    public void insertUser(User user){
        userDao.insertUser(user);
    }

    public  void deleteById(int id){
        userDao.deleteById(id);
    }
    public void editByUser(User user){
        userDao.editByUser(user);
    }
}

