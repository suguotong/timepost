package com.sgt.timepost.service;

import com.sgt.timepost.bean.MailComment;
import com.sgt.timepost.untils.HttpClientUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sgt on 2018/8/24 0024.
 */
public class HtmlParserService {

    //通过url获取email
     public  static List<MailComment> parseComment(String emailUrl) throws Exception{
//         System.getProperties().setProperty("proxySet", "true");
//         //用的代理服务器
//         System.getProperties().setProperty("http.proxyHost", "121.232.194.119");
//         //代理端口
//         System.getProperties().setProperty("http.proxyPort", "9000");
//         String  agent="Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:57.0) Gecko/20100101 Firefox/57.0";

//         URL uri = new URL(emailUrl);
//         Document document = Jsoup.parse(uri,10000);
//         Document document = Jsoup.connect(emailUrl).userAgent(agent).timeout(10000).ignoreHttpErrors(true).get();

         String html = HttpClientUtil.sendGetRequest(emailUrl,null);
         Document document = Jsoup.parse(html);
         MailComment mailComment = null;
         List<MailComment> mailCommentList = new ArrayList<>();
         Elements emailInfos = document.getElementsByClass("mail-item");
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
         for(Element emailInfo : emailInfos){
             mailComment = new MailComment();
             mailComment.setEmail(emailInfo.child(0).child(0).text());
             String[] timeArr=emailInfo.child(1).text().split("寄往");
             mailComment.setTimeStart(sdf.parse(timeArr[0]));
             mailComment.setTimeEnd(sdf.parse(timeArr[1]));
             mailComment.setContent(emailInfo.child(2).html());
             mailCommentList.add(mailComment);
         }
         return mailCommentList;
     }
}

