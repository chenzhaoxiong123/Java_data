package com.lanou3g.api;

import net.sf.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Weather {


    public static void tq(String s) throws IOException {

//        s = "1";
        URL url = new URL("http://api.k780.com/?app=weather.future&weaid="+s+"&&appkey=30514&sign=4774b193caa6837532310bea8cd7972f&format=json");
        InputStream in = url.openStream();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
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
//        System.out.println(new String(b,"utf-8"));
        String str = new String(b,"utf-8");
        Map map = new HashMap();
        map.put("result",TQapi.ResultBean.class);
//        System.out.println(str);
        JSONObject joss = JSONObject.fromObject(str);
        TQapi tQapi=(TQapi) JSONObject.toBean(joss, TQapi.class, map);
        List<TQapi.ResultBean> result = tQapi.getResult();
//        System.out.println(result);
        for (TQapi.ResultBean resultBean : result) {
            System.out.println(resultBean.getDays());
            System.out.println("城市:"+resultBean.getCitynm() + '\n'+"天气:" +resultBean.getWeather());
        }
//        System.out.println(tQapi.getResult().toString());


    }
}
