package com.lanou3g.bookstore.user.service.exception;

public class CodeException extends UserException {
    @Override
    public String getMessage() {
        return "验证码未激活";
    }
}
