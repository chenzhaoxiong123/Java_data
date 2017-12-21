package com.lanou3g.execuption;

public class LoginExecuption extends Exception{
    @Override
    public String getMessage() {
        return "信息验证失败";
    }
}
