package com.lanou3g.practice;

import org.dom4j.DocumentException;

import java.io.FileNotFoundException;
import java.util.List;

public class Detection {
    public static User login(String userName,String password) throws FileNotFoundException, DocumentException {
        List<User> list = UserData.login();
        User user = null;
//        System.out.println("4");
        for (int i = 0; i < list.size(); i++) {
//            System.out.println("5");
            System.out.println(list.get(i));
        }
        for (Object o:list) {
//            System.out.println("3");
            User user1 = (User) o;
            if(userName.equals(user1.getUserName()) && password.equals(user1.getPassword())){
                System.out.println("登录成功");
            }else {
                break;
            }
        }
        return null;
    }

}
