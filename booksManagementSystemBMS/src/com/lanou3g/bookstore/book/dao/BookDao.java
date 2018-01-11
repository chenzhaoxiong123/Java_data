package com.lanou3g.bookstore.book.dao;

import com.lanou3g.bookstore.book.bean.Book;
import com.lanou3g.bookstore.cart.bean.Cart;
import com.lanou3g.bookstore.cart.bean.CartItem;
import com.lanou3g.bookstore.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

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
            System.out.println(books+"asdfgg");
            return books;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Book> findBookCid(String cid){
        String sql = "select * from book where cid = ?";
        Connection conn = JdbcUtil.getConnection();
        try {
            List<Book> books = qr.query(conn, sql, new BeanListHandler<Book>(Book.class),cid);
            System.out.println(books);
            return books;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public CartItem findBookBid(String bid){
        String sql = "select * from book where bid = ?";
        Connection conn = JdbcUtil.getConnection();
        try {
            CartItem book = qr.query(conn, sql, new BeanHandler<CartItem>(CartItem.class),bid);
            return book;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Cart findBookCname(String cname){
        String sql = "select * from category where cname = ?";
        Connection conn = JdbcUtil.getConnection();
        try {
            Cart book = qr.query(conn, sql, new BeanHandler<Cart>(Cart.class),cname);
            System.out.println(book);
            return book;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Book> b(int id) throws SQLException {
        String sql = "select * from book where cid=?";
        Connection conn = null;
        conn = JdbcUtil.getConnection();
        try {
            List<Book> user = qr.query(conn, sql, new BeanListHandler<Book>(Book.class), id);
            return (List<Book>) user;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
        return null;
    }
}
