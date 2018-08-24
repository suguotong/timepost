package timepost;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ${sgt} on 2018/8/21 0021.
 */
public class Test {
    public static void main(String[] args) throws Exception{
        URL uri = new URL("http://hi2future.com/Mail/showlist2/page/5.html");
        Document document = Jsoup.parse(uri,3000);
        Elements emailInfos = document.getElementsByClass("mail-item");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        for(Element emailInfo : emailInfos){
            String email=emailInfo.child(0).child(0).text();
            String[] timeArr=emailInfo.child(1).text().split("寄往");
            Date timeStart= sdf.parse(timeArr[0]) ;
            Date timeEnd = sdf.parse(timeArr[1]);
            String content=emailInfo.child(2).html();
            String ss="";
        }
    }
}
