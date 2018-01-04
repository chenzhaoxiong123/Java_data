package com.lanou3g.dao;

import com.lanou3g.bean.User;
import com.lanou3g.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDao {
    private QueryRunner qr = new QueryRunner();

   public int inserts(User user) throws SQLException {
       String sql = "insert into user values(null,?,?)";
       Connection conn = JdbcUtil.getConnection();
       try {
           int i = qr.update(conn, sql, user.getUsername(), user.getPassword());
           return i;
       } catch (SQLException e) {
           e.printStackTrace();
       }finally {
           conn.close();
       }
       return 0;
   }

    public User findByName(String username) throws SQLException {
        String sql = "select * from user where username=?";
        Connection conn = null;
        conn = JdbcUtil.getConnection();
        try {
            User user = qr.query(conn, sql, new BeanHandler<User>(User.class),username);
            System.out.println(user);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conn.close();
        }
        return null;
    }
}
