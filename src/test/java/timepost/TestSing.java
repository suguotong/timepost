//package timepost;
//
//import java.net.URLDecoder;
//import java.security.MessageDigest;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//
//import okhttp3.Request;
//import okhttp3.Headers;
//
//public class TestSing {
//
////    public static String a(Request paramaa, String paramString, long paramLong) {
////        StringBuilder localStringBuilder = new StringBuilder();
////        localStringBuilder.append(paramaa.url().uri().getPath());
////        HashMap localHashMap = new HashMap();
////        Object localObject1 = new ArrayList();
////        int i = 0;
////        try {
////            Object localObject2;
////            while (i < ((Headers) paramaa.headers()).size()) {
////                localObject2 = (Headers) paramaa.headers();
////                String str2 = ((Headers) localObject2).name(i);
////                localHashMap.put(str2, ((Headers) localObject2).value(i));
////                ((List) localObject1).add(str2);
////                i += 1;
////            }
////            String[] strArr = (String[]) ((List) localObject1).toArray(new String[0]);
////            Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER);
////            if (localHashMap.size() != 0) {
////                int j = ((ArrayList) localObject1).toArray().length;
////                i = 0;
////                while (i < j) {
////                    localObject2 = localObject1[i];
////                    if (!checkParm((String) localHashMap.get(localObject2))) {
////                        localStringBuilder.append((String) localObject2).append(URLDecoder.decode((String) localHashMap.get(localObject2), "Utf-8"));
////                    }
////                    i += 1;
////                }
////            }
////            return getStrSHA(localStringBuilder.toString()).toUpperCase();
////        } catch (Exception localException1) {
////            localException1.printStackTrace();
////        }
////        return null;
////    }
//
//    public static boolean checkParm(String  paramCharSequence)
//    {
//        return (paramCharSequence == null) || (paramCharSequence.length() == 0) || (paramCharSequence.equals("null"));
//    }
//
//    public static String getStrSHA(String paramString){
//        if(paramString==null){
//            return null;
//        }
//        try {
//            MessageDigest digest = MessageDigest.getInstance("SHA1");
//            digest.update(paramString.getBytes());
//            paramString = new String(byteToHexStr(digest.digest()));
//            return paramString;
//        }catch (Exception e){
//            throw new RuntimeException(paramString);
//        }
//    }
//
////    private static String byteToHexStr(byte mByte) {
////        char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
////        char[] tempArr = new char[2];
////        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
////        tempArr[1] = Digit[mByte & 0X0F];
////        String s = new String(tempArr);
////        return s;
////    }
//
//    private static char[] byteToHexStr(byte[] paramArrayOfByte){
//        char[] Digit = {48,49,50,51,52,53,54,55,56,57,97,98,99,100,101,102};
//        int j = 0;
//        int k = paramArrayOfByte.length;
//        char[] arrayOfChar = new char[k << 1];
//        int i=0;
//        while (i<k){
//            int m = j+i;
//            arrayOfChar[j] =Digit[((paramArrayOfByte[i] & 0xF0)>>>4)];
//            j = m+1;
//            arrayOfChar[m] = Digit[(paramArrayOfByte[i] & 0xF)];
//            i += 1;
//        }
//        return arrayOfChar;
//    }
//
//}
