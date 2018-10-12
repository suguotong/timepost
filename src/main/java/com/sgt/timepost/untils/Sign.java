package com.sgt.timepost.untils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

public class Sign {
    public static String createSign(Map<String, String> params, boolean encode) throws UnsupportedEncodingException {
        Set<String> keysSet = params.keySet();
        Object[] keys = keysSet.toArray();
        Arrays.sort(keys);
        StringBuffer temp = new StringBuffer();
        boolean first = true;
        for (Object key : keys) {
            if (first) {
                first = false;
            } else {
                temp.append("&");
            }
            temp.append(key).append("=");
            Object value = params.get(key);
            String valueString = "";
            if (null != value) {
                valueString = String.valueOf(value);
            }
            if (encode) {
                temp.append(URLEncoder.encode(valueString, "UTF-8"));
            } else {
                temp.append(valueString);
            }
        }
        return MD5Util.md5(temp.toString()).toUpperCase();
    }

//    HttpServletRequest
    public Map<String,String> getParamsMap(HttpServletRequest request){

        //得到请求的参数Map，注意map的value是String数组类型

        Map<String ,String> params = new HashMap<String, String>();
        Map<String, String[]> map = request.getParameterMap();
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            String[] values = (String[]) map.get(key);
            for (String value : values) {
                //System.out.println(key+"="+value);
            }
        }
        //System.out.println("--------request.getParameter()--------");
        //得到请求头的name集合
        Enumeration<String> em = request.getParameterNames();
        System.out.println(em);
        while (em.hasMoreElements()) {
            String name = (String) em.nextElement();
            String value = request.getParameter(name);
            System.out.println(name+"="+value);
            params.put(name,value);
        }
        return params;
    }
}
