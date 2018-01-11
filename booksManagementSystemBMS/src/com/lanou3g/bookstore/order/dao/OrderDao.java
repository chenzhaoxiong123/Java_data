package com.lanou3g.bookstore.order.dao;

import com.lanou3g.bookstore.order.bean.Order;
import com.lanou3g.bookstore.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

public class OrderDao {
    private QueryRunner qr = new QueryRunner();
    public int insertOrder(Order order) throws SQLException {
        String sql = "insert into orders values(?,?,?,?,?,?)";
        Connection conn = JdbcUtil.getConnection();
        try {
            int update = qr.update(conn, sql,order.getOid(),order.getOrdertime(),order.getPrice(),order.getState(),
                    order.getUid(),order.getAddress());
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conn.close();
        }
        return 0;
    }
}
