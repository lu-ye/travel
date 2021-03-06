package com.igeek.travel.service;

import com.igeek.travel.dao.UserDao;
import com.igeek.travel.entity.User;

import java.sql.SQLException;

/**
 * @Description TODO
 * @Author yl
 * @Date 2021/1/29 10:24
 */
public class    UserService {
    private UserDao dao =new UserDao();


    //注册
    public boolean register(User user){
        try {
            return dao.insert(user)>0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //激活
    public boolean active(String code){
        try {
            return dao.updateState(code)>0 ? true :false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //登录
    public User login(String name , String password){
        User user = null;

        try {
             user = dao.selectOne(name, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}