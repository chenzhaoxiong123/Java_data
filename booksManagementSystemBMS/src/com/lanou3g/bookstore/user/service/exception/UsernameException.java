package com.lanou3g.bookstore.user.service.exception;

public class UsernameException extends UserException {
    @Override
    public String getMessage() {
        return "用户名错误";
    }
}
