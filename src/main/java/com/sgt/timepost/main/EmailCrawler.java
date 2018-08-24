package com.sgt.timepost.main;

import com.sgt.timepost.bean.MailComment;
import com.sgt.timepost.service.PageUrlQueueService;
import com.sgt.timepost.untils.Constants;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by sgt on 2018/8/24 0024.
 */
public class EmailCrawler implements Runnable {

    private static Logger logger = Logger.getLogger(EmailCrawler.class);
    private int urlListCount = Constants.URL_LIST_COUNT;
    private int limitPage = Constants.PER_PAGE;
    private int offset = Constants.OFFSET;
    private List<MailComment> mc = null;

    @Override
    public void run() {
        try {
            //初始化待爬的url队列
            initUncrawledEmailUrlQueue();

            //开始根据url爬去mail
            while (!PageUrlQueueService.isUncrawledMusicListEmpty()){

                //取出待爬取的url
                String url = PageUrlQueueService.takeUrl();




            }


        } catch (InterruptedException e) {
            logger.error(e.getMessage(),e);
        }
    }

    //填充要爬取的歌曲队列
    public void initUncrawledEmailUrlQueue() throws InterruptedException{
        for (int i = 0; i < 2810; i++) {
            PageUrlQueueService.putUrl("http://hi2future.com/Mail/showlist2/page/" + i + ".html");
        }
    }

    public MailComment getComment(String url){

    }
}
