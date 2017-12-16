package com.lanou3g.dao;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Upload {
    public void transmit(String u,Long t) throws IOException {
        URL url = new URL("http://192.168.20.194:8080/day16/insert?"+"username="+u+"&score="+t);
        URLConnection uc = url.openConnection();
        byte[] buff = new byte[1024];
        InputStream is = uc.getInputStream();
        int len = 0;
        StringBuffer sb = new StringBuffer();
        while((len = is.read(buff))!= -1){
            sb.append(new String(buff,0,len));
            System.out.println(sb);
            sb.setLength(0);
        }
    }
}
