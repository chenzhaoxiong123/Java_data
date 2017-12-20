package com.lanou3g.mysql;


import java.sql.*;


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

    public static void login(String s,String s1) throws ClassNotFoundException, SQLException {
      JdbcUtil.execute(conn -> {
          Statement state = conn.createStatement();
          state.execute("SELECT * FROM user WHERE (userName='"+s+"' AND password='"+s1+"')");
          return state;
      });
    }

    public static void modification(String s,String s1,String s2){
        JdbcUtil.execute(conn -> {
            Statement state = conn.createStatement();
            state.execute("SELECT * FROM user ");
            String update = "update user set name='"+s+"' where name='");
        });
    }
}
