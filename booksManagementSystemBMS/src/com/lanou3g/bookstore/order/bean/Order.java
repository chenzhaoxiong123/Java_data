package com.lanou3g.bookstore.order.bean;

import java.util.Date;

public class Order {
    private String oid;
    private Date ordertime;
    private double price;
    private int state;
    private String uid;
    private String address;

    @Override
    public String toString() {
        return "Order{" +
                "oid='" + oid + '\'' +
                ", ordertime=" + ordertime +
                ", price=" + price +
                ", state=" + state +
                ", uid='" + uid + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Order() {
        super();
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
