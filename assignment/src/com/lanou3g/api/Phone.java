package com.lanou3g.api;

import net.sf.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Phone {
    public static void sj(String s1)throws IOException {

        URL url =new URL( "http://api.k780.com/?app=phone.get&phone= "+s1+"&appkey=30522&sign=23e66de6ea94d0ac260642a9b714bffe&format=json");
        InputStream in=url.openStream();
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        try {
            byte buf[]=new byte[1024];
            int read = 0;
            while ((read = in.read(buf)) > 0) {
                out.write(buf, 0, read);
            }
        }  finally {
            if (in != null) {
                in.close();
            }
        }
        byte b[]=out.toByteArray( );

        String result = new String(String.valueOf(out));

        JSONObject jsonObject = JSONObject.fromObject(result);
        SJapi phone = (SJapi) JSONObject.toBean(jsonObject,SJapi.class);
        System.out.println(phone.getResult().getStyle_simcall());

    }

}
