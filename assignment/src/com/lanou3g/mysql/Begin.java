package com.lanou3g.mysql;


import com.lanou3g.execuption.LoginExecuption;
import com.lanou3g.practice.User;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.*;
import java.util.List;


public class Begin {

    public static void register(String s,String s1,String s2) throws ClassNotFoundException, SQLException {
        JdbcUtil.execute(conn -> {
            Statement state = conn.createStatement();
            state.execute("INSERT INTO user VALUES ('"+s+"','"+s1+"','"+s2+"')");
            return state;
        });
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/home", "root", "123");

    }
    static boolean a = true;
    public static boolean login(String s,String s1) throws SQLException {
        List<User> users = new QueryRun().query(
                JdbcUtil.getConnection(),
                "select userName,password from user",
                new BeanListHandler<>(User.class)
        );
        for (User user : users) {
            if(user.getUserName().equals(s)&&user.getPassword().equals(s1)){
                System.out.println("登录成功");
                a=true;
            }else {
                a=false;
//                System.out.println("34");
            }
        }
    return a;
    }

    public static void modification(String s,String s1,String s2){
        JdbcUtil.execute(conn -> {
            Statement state = conn.createStatement();
            state.execute("SELECT name,userName,password FROM user ");

            state.execute("update user set (name='"+s+"'and userName='"+s1+"+' and password='"+s2+"')");
            return state;
        });
    }
}
