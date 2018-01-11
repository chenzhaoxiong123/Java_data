package com.lanou3g.bookstore.user.service;

import com.lanou3g.bookstore.user.bean.User;
import com.lanou3g.bookstore.user.dao.UserDao;
import com.lanou3g.bookstore.user.service.exception.PasswordException;
import com.lanou3g.bookstore.user.service.exception.UserException;
import com.lanou3g.bookstore.user.service.exception.UsernameException;

import java.sql.SQLException;
import java.util.regex.Pattern;

public class UserService {
    private UserDao userDao = new UserDao();
    public User login(User user) throws UserException, SQLException {
        User db = userDao.findByName(user.getUsername());
        System.out.println(db + "-----");
        if (db == null){
            System.out.println(db);
            throw new UsernameException();
        }

//        if (user.getState() == 0){
//            throw new CodeException();
//        }

        if(!db.getPassword().equals(user.getPassword())){
            System.out.println(user.getPassword());
            throw new PasswordException();
        }
        return db;
    }

    public void register(User user) throws SQLException {
        Pattern p = Pattern.compile("^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
        if (userDao.findByName(user.getUsername()) == null){
            if (userDao.findByName(user.getPassword()).equals(p)){
                if (userDao.findByName(user.getEmail()) == null){
                    userDao.inserts(user);
                }else {
                    System.out.println("邮箱有误");
                }
            }else {
                System.out.println("密码格式不正确");
            }
        }else {
            System.out.println("用户名有误");
        }

    }
}
