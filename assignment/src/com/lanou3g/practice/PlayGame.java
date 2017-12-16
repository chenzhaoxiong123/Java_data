package com.lanou3g.practice;

import com.lanou3g.dao.Upload;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class PlayGame {
    // 手速小游戏
    public static void play() throws IOException {
        String val = "";
        Random random = new Random();

        Scanner index = new Scanner(System.in);
        System.out.println("请选择难度 1-困难 2-一般 3-简单");

        // 计时开始
        long time1 = System.currentTimeMillis();

        switch (index.nextInt()) {
            case 1:
                StringBuffer sb = new StringBuffer();
                for (int i = 33; i <= 126 ; i++) {
                    char ran = (char) ( Math.random()*33);
                    char i1 = (char)random.nextInt((126 - 33 + 1) + 33);
                    System.out.print(i1);
                }
//                System.out.println("困难");
                break;
            case 2:
               sj();

                for (int i = 0; i < 20; i++) {
                    String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
                    //输出字母还是数字
                    if ("char".equalsIgnoreCase(charOrNum)) {
                        //输出是大写字母还是小写字母
                        int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                        val += (char) (random.nextInt(26) + temp);
                    } else if ("num".equalsIgnoreCase(charOrNum)) {
                        val += String.valueOf(random.nextInt(20));
                    }
                }
                System.out.println(val);
                System.out.println("请输入:");
                index.nextLine();
                String s = index.next();
                if (s.equals(val)) {
                    System.out.println("你很牛批哦");

                } else {
                    System.out.println("输入的有误");
                }
                // 计时结束

                break;
            case 3:
                sj();
                for (int i = 0; i < 10; i++) {
                    String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
                    //输出字母还是数字
                    if ("char".equals(charOrNum)) {
                        //输出是大写字母还是小写字母
                        int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                        val += (char) (random.nextInt(26) + temp);
                    } else if ("num".equals(charOrNum)) {
                        val += String.valueOf(random.nextInt(10));
                    }
                }

                    System.out.println(val);
                    System.out.println("请输入:");
                    index.nextLine();
                    String s1 = index.next();
                    if (s1.equals(val)) {
                        System.out.println("你还不错哦");
                    } else {
                        System.out.println("输入的有误");
                    }
                    break;
                }

        long time2 = System.currentTimeMillis();
        long interval = (time2 - time1 -4);
        System.out.println("总共消耗:"+ interval + "毫秒");
//        User user = new User();
        String name = "chenzhaoxiong";
        Upload upload = new Upload();
        upload.transmit(name,interval);
//        System.out.println(name);
    }
        public static void sj(){
            for (int j = 3; j >= 1; j--) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("距离游戏开始还有:" + j + "秒");
            }
        }
    }
