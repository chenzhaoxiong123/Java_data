package com.lanou3g.bookstore.util;

public class UUID {
    public static String uuid(){
        String uuids = java.util.UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println(uuids);
        return uuids;
    }
}
