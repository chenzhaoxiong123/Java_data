package com.lanou3g.daomain;

public class Book {
    private String bkname;
    private String author;
    private Double price;

    public Book() {
        
    }

    @Override
    public String toString() {
        return "Book{" +
                "bkname='" + bkname + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }

    public String getBkname() {
        return bkname;
    }

    public void setBkname(String bkname) {
        this.bkname = bkname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
