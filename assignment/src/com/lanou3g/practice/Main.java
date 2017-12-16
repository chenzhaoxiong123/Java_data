package com.lanou3g.practice;

import com.lanou3g.api.Phone;
import com.lanou3g.api.Weather;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException, DocumentException {
        Scanner input = new Scanner(System.in);
        boolean flg = true;
        boolean flg2 = true;
        boolean flg3 = true;
        boolean flg4 = true;
        UserData ud = new UserData();
        while (true){
            System.out.println("1-注册 2-登录");
            int a = input.nextInt();
            c:switch (a){
                case 1:
                    System.out.println("欢迎进入注册页面");
                    input.nextLine();
                    System.out.println("请输入姓名:");
                    String s2 = input.nextLine();
                    Pattern p3 = Pattern.compile("[a-zA-Z]{1}[a-zA-Z0-9_]{1,15}");
                    Matcher m3 = p3.matcher(s2);
                    flg4 = m3.matches();
                    if(flg4 == true){
                        System.out.println("昵称正确");
                    }else {
                        System.out.println("格式错误,由字母数字下划线组成且开头必须是字母，不能超过16位");
                        break;
                    }
                    System.out.println("请输入用户名或邮箱:");
                    String s = input.nextLine();
                    Pattern p = Pattern.compile("^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
                    Pattern p1 = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
                    Matcher m = p.matcher(s);
                    Matcher m1 = p1.matcher(s);
                    flg = m.matches();
                    flg2 = m1.matches();
//                    System.out.println(flg);
                    if (flg == true|flg2 == true){
                        System.out.println("用户名格式正确,请输入密码:");
                    }else {
                        System.out.println("注册失败,确认格式后重新输入");
                        break;
                    }
//                    System.out.println("请输入密码:");
                    String s1 = input.nextLine();
                    Pattern p2 = Pattern.compile("[a-zA-Z0-9]{1,16}");
                    Matcher m2 = p2.matcher(s1);
                    flg3 = m2.matches();
                    if(flg3 == true){
                        System.out.println("注册成功");
                    }else {
                        System.out.println("密码格式不正确,密码由字母和数字组成1-16位");
                    }

                    User u = new Users(s,s1,s2);
                    ud.register(u);
                    break;
                case 2:
                    input.nextLine();
                    System.out.println("请输入用户名:");
                    String un = input.next();
                    System.out.println("请输入密码:");
                    String pw = input.next();
                    Detection.login(un,pw);
                    System.out.println("登录成功");
                    System.out.println("1-查询天气 2-查询手机号归属地 3-手速游戏 4-查询手速游戏前十用户");
                    switch (input.nextInt()){
                        case 1:
                            System.out.println("请输入要查询的城市:");
                            input.nextLine();
                            Weather.tq(input.nextLine());
//                            System.out.println("tq");
                            break c;
                        case 2:
                            System.out.println("请输入手机号码");
                            input.nextLine();
                            Phone.sj(input.nextLine());
//                            System.out.println("sjhm");
                            break;
                        case 3:
                            PlayGame pg = new PlayGame();
                            pg.play();
//                            System.out.println("yx");
                            break;
                        case 4:
                            System.out.println("cx");
                            break;
                    }

                    break;
                default:
                    System.out.println("输入有误");
            }
        }
    }
}
