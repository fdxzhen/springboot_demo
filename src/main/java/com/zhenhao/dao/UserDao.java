package com.zhenhao.dao;

import com.zhenhao.bean.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    @Select("select * from user")
    public List<User> getAllUser();
    @Select("select * from user where id=#{id}")
    public User getUserById(int id);
    @Insert("insert into user(name,age) values(#{name},#{age})")
    public void insertUser(User user);
    @Delete("delete from user where id=#{id}")
    public void deleteById(int id);

    @Update("update user set name='${name}',age = ${age} where id=${id}")
    public void editByUser(User user);
}
