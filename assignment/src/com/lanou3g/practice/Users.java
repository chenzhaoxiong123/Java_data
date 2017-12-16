package com.lanou3g.practice;

public class Users extends User {
    public Users() {
    }

    public Users(String userName,String password){
        super(userName,password);
    }
    public Users(String name, String password, String userName) {
        super(name, password, userName);
    }
}
