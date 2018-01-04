package com.lanou3g.dao;

import com.lanou3g.bean.Book;
import com.lanou3g.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BookDao {
    private QueryRunner qr = new QueryRunner();
    public List<Book> findBook(){
        String sql = "select * from book";
        Connection conn = JdbcUtil.getConnection();
        try {
            List<Book> books = qr.query(conn, sql, new BeanListHandler<Book>(Book.class));
            System.out.println(books);
            return books;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
