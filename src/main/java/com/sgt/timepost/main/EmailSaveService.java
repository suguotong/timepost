package com.sgt.timepost.main;

import com.sgt.timepost.bean.MailComment;
import com.sgt.timepost.service.EmailQueueService;
import com.sgt.timepost.untils.MysqlConnPool;
import com.sgt.timepost.untils.MysqlHelper;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by sgt on 2018/9/4 0004.
 */
public class EmailSaveService implements Runnable{
    private static Logger logger = Logger.getLogger(EmailSaveService.class);
    @Override
    public void run() {
        while (!EmailQueueService.isUncrawledMusicListEmpty()){
            try {
                MailComment mailComment = EmailQueueService.pollMail();
                if(mailComment!=null){
                    save(mailComment);
                    logger.info("存入数据库1条");
                }else {
                    logger.info("存入数据库线程休眠");
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                logger.info(e.getMessage(),e);
            }
        }
    }

    public void save(MailComment mailComment){
        Connection connection1 = MysqlConnPool.getInstance().getConnection();
        int exeCount = 0;
        try {
            String sql="INSERT INTO EmailInfo(`name`, `email`, `content`, `time_start`, `timeEnd`, `Type`) VALUES ("+mailComment.getName()+","+mailComment.getContent()+","+mailComment.getTimeStart()+","+mailComment.getTimeEnd()+","+mailComment.getType()+");";
            exeCount = MysqlHelper.executeUpdate(connection1, sql);
            connection1.close();
        } catch (SQLException e) {
            logger.info(e.getMessage(),e);
        }
    }
}
