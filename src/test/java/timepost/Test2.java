package timepost;

import com.sgt.timepost.untils.HttpClientUtil;
import com.sgt.timepost.untils.Sign;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Test2 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String url = "https://api.soulapp.cn/v3/post/detail?platform=IOS&postId=279010204&sourceType=squareRecommend";
        Map<String, String> map = new HashMap<>();
        map.put("content-type", "text/css; charset=utf-8");
        map.put("User-Agent", "[WIFI;iPhone 6s;iOS;12.0;375*667;100001;zh_CN]");
        map.put("app-id", "10000001");
        map.put("X-Auth-Token", "UxgK5BrDJZL9FLlG74Sy1Q==");
        map.put("request-nonce", UUID.randomUUID().toString().replaceAll("-", ""));
        map.put("X-Auth-UserId", "7402159");
        map.put("api-sign-version", "v4");
        map.put("api-sign", "E5E7BAC8D72FAFEA056B03DDF8A581ED10F705DC");
        map.put("os", "ios");
        map.put("device-id", "CA865ACF-C8DD-437E-9B4C-058EE3CA8BF2");
        map.put("app-version", "3.7.30");
        map.put("app-time", Long.toString(System.currentTimeMillis()));
        String html = HttpClientUtil.sendGetRequestWithHeader(url,null,map);
        String ss="";
        Map<String, String> mapSign = new HashMap<>();
        mapSign.put("app-time", "1538135343811");
        mapSign.put("api-sign-version", "v4");
        mapSign.put("X-Auth-UserId", "7402159");
        mapSign.put("request-nonce", "28410137483622911877000918462207");
//        mapSign.put("X-Auth-Token", "UxgK5BrDJZL9FLlG74Sy1Q==");

//        mapSign.put("content-type", "text/css; charset=utf-8");
//        mapSign.put("User-Agent", "[WIFI;iPhone 6s;iOS;12.0;375*667;100001;zh_CN]");
//        mapSign.put("app-id", "10000001");
//        mapSign.put("api-sign", "E5E7BAC8D72FAFEA056B03DDF8A581ED10F705DC");
//        mapSign.put("os", "ios");
//        mapSign.put("device-id", "CA865ACF-C8DD-437E-9B4C-058EE3CA8BF2");
//        mapSign.put("app-version", "3.7.30");
        String encryptionURL = Sign.createSign(mapSign, true);
        System.out.println("加密后的URL:" + encryptionURL);
    }

}
