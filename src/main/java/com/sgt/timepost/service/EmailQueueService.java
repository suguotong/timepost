package com.sgt.timepost.service;

import com.sgt.timepost.bean.MailComment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by sgt on 2018/8/24 0024.
 */
public class EmailQueueService {
    //mail队列
    private static BlockingQueue<MailComment> emailInfoQueue = new LinkedBlockingQueue<>();

    public static void putMail(MailComment mailComment) throws InterruptedException {
        emailInfoQueue.put(mailComment);
    }

    public static void addAllMials(List<MailComment> mailCommentList){
        emailInfoQueue.addAll(mailCommentList);
    }

    public static MailComment takeMail() throws InterruptedException {
        return emailInfoQueue.take();
    }

    public static MailComment pollMail() throws InterruptedException {
        return emailInfoQueue.poll();
    }

    public static boolean isUncrawledMusicListEmpty() {
        return emailInfoQueue.isEmpty();
    }

    public static int getEmailQueueSize(){
       return emailInfoQueue.size();
    }

    public static void printEmailQueueSize(){
            System.out.println("email 队列 size:"+ emailInfoQueue.size());
    }
}
