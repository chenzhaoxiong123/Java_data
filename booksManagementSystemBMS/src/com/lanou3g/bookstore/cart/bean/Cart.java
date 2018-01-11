package com.lanou3g.bookstore.cart.bean;

public class Cart {
    private int cid;
    private String cname;

    public Cart() {
        super();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                '}';
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
