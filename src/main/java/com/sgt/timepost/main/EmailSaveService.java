package com.sgt.timepost.main;

import com.sgt.timepost.bean.MailComment;
import com.sgt.timepost.service.EmailQueueService;
import com.sgt.timepost.untils.MysqlConnPool;
import com.sgt.timepost.untils.MysqlHelper;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

/**
 * Created by sgt on 2018/9/4 0004.
 */
public class EmailSaveService implements Runnable {
    private static Logger logger = Logger.getLogger(EmailSaveService.class);

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //数据库线程启动
        System.out.println("数据库线程启动");
        while (!EmailQueueService.isUncrawledMusicListEmpty()) {
            try {
                if (EmailQueueService.getEmailQueueSize() > 30) {
                    MailComment mailComment = EmailQueueService.pollMail();
                    if (mailComment != null) {
                        save(mailComment);
                        logger.info("存入数据库1条");
                    }
                } else {
                    System.out.println("存入数据库线程休眠");
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                logger.info(e.getMessage(), e);
            }
        }
    }

    public void save(MailComment mailComment) {
        Connection connection1 = MysqlConnPool.getInstance().getConnection();
        int exeCount = 0;
        try {
            String name = mailComment.getName() == null ? "" : mailComment.getName();
            String type = mailComment.getType() == null ? "" : mailComment.getType();
            String email = mailComment.getEmail() == null ? "" : mailComment.getEmail();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String timeStart = sdf.format(mailComment.getTimeStart());
            String timeEnd = sdf.format(mailComment.getTimeEnd());
            String sql = "INSERT INTO EmailInfo(`name`, `email`, `content`, `time_start`, `timeEnd`, `Type`) VALUES ('" + name + "','" + email + "','" + mailComment.getContent() + "','" + timeStart + "','" + timeEnd + "','" + type + "')";
            System.out.println(sql);
            exeCount = MysqlHelper.executeUpdate(connection1, sql);
            connection1.close();
        } catch (SQLException e) {
            logger.info(e.getMessage(), e);
        }
    }
}
