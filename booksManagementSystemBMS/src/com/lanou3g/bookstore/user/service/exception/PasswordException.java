package com.lanou3g.bookstore.user.service.exception;

public class PasswordException extends UserException{
    @Override
    public String getMessage() {
        return "密码错误";
    }
}
