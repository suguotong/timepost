package timepost;

import com.sgt.timepost.untils.Sign;
import okhttp3.Headers;
import okhttp3.Request;

import java.net.URLDecoder;
import java.security.MessageDigest;
import java.util.*;

public class Test3 {
    //    public static String a(Request paramaa, String paramString, long paramLong) {
//        StringBuilder localStringBuilder = new StringBuilder();
//        localStringBuilder.append(paramaa.url().uri().getPath());
//        HashMap localHashMap = new HashMap();
//        Object localObject1 = new ArrayList();
//        int i = 0;
//        try {
//            Object localObject2;
//            while (i < ((Headers) paramaa.headers()).size()) {
//                localObject2 = (Headers) paramaa.headers();
//                String str2 = ((Headers) localObject2).name(i);
//                localHashMap.put(str2, ((Headers) localObject2).value(i));
//                ((List) localObject1).add(str2);
//                i += 1;
//            }
//            String[] strArr = (String[]) ((List) localObject1).toArray(new String[0]);
//            Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER);
//            if (localHashMap.size() != 0) {
//                int j = ((ArrayList) localObject1).toArray().length;
//                i = 0;
//                while (i < j) {
//                    localObject2 = localObject1[i];
//                    if (!checkParm((String) localHashMap.get(localObject2))) {
//                        localStringBuilder.append((String) localObject2).append(URLDecoder.decode((String) localHashMap.get(localObject2), "Utf-8"));
//                    }
//                    i += 1;
//                }
//            }
//            return getStrSHA(localStringBuilder.toString()).toUpperCase();
//        } catch (Exception localException1) {
//            localException1.printStackTrace();
//        }
//        return null;
//    }
    private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
    public static void main(String[] args) {
        Map<String, String> mapSign = new HashMap<>();

        mapSign.put("device-id", "CA865ACF-C8DD-437E-9B4C-058EE3CA8BF2");
        mapSign.put("os", "ios");
        mapSign.put("app-time", "1538229685466");
//        mapSign.put("api-sign", "DF24AC3F45EFC439F1197C76818E73CD3A69F6B4");
        mapSign.put("api-sign-version", "v4");
        mapSign.put("X-Auth-UserId", "7402159");
        mapSign.put("request-nonce", "27707397883526080988299069858251");
        mapSign.put("User-Agent", "[WIFI;iPhone 6s;iOS;12.0;375*667;100001;zh_CN]");
        mapSign.put("X-Auth-Token", "UxgK5BrDJZL9FLlG74Sy1Q==");
        mapSign.put("Accept-Language", "zh-Hans-CN;q=1");
        mapSign.put("Accept-Encoding", "br, gzip, deflate");
        mapSign.put("Connection", "keep-alive");
        mapSign.put("app-id", "10000001");
        String str1=UUID.randomUUID().toString().replaceAll("-", "");
        String encryptionURL = signPara(mapSign, "https://api.soulapp.cn/v3/post/detail?platform=IOS&postId=280018229&sourceType=squareRecommend ",1);
        System.out.println("加密后的URL:" + encryptionURL);
    }

    public static String signPara(Map<String, String> params, String url, long paramLong) {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(url);
        try {
            if (params.size() != 0) {
                String[] keyArr = params.keySet().toArray(new String[0]);
                for (int i = 0; i < params.size(); i++) {
                    if (!checkParm(keyArr[i])) {
                        localStringBuilder.append(keyArr[i]).append(URLDecoder.decode(params.get(keyArr[i]), "Utf-8"));
                    }
                }
            }
        } catch (Exception e) {

        }
        return getStrSHA(localStringBuilder.toString()).toUpperCase();
    }

    public static boolean checkParm(String paramCharSequence) {
        return (paramCharSequence == null) || (paramCharSequence.length() == 0) || (paramCharSequence.equals("null"));
    }

    public static String getStrSHA(String paramString)
    {
        if (paramString == null) {
            return null;
        }
        try
        {
            MessageDigest localMessageDigest = MessageDigest.getInstance("SHA1");
            localMessageDigest.update(paramString.getBytes());
            paramString = new String(byteToHexStr(localMessageDigest.digest()));
            return paramString;
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    protected static char[] byteToHexStr(byte[] paramArrayOfByte)
    {
        int j = 0;
        int k = paramArrayOfByte.length;
        char[] arrayOfChar = new char[k << 1];
        int i = 0;
        while (i < k)
        {
            int m = j + 1;
            arrayOfChar[j] = a[((paramArrayOfByte[i] & 0xF0) >>> 4)];
            j = m + 1;
            arrayOfChar[m] = a[(paramArrayOfByte[i] & 0xF)];
            i += 1;
        }
        return arrayOfChar;
    }

}
