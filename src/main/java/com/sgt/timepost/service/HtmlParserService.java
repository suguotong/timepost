package com.sgt.timepost.service;

import com.google.common.collect.ImmutableMap;
import com.sgt.timepost.bean.MailComment;
import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.util.List;

/**
 * Created by sgt on 2018/8/24 0024.
 */
public class HtmlParserService {

    //通过url获取email
     public  static List<MailComment> parseComment(String emailUrl) throws Exception{
         URL uri = new URL(emailUrl);
         Document document = Jsoup.parse(uri,3000);
         Elements emailInfos = document.getElementsByClass("showlist_open");
         for(Element emailInfo : emailInfos){
             String email=emailInfo.child(0).getAllElements().get(0).html();
         }







         return null;

     }
}

