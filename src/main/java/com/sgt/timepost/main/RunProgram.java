package com.sgt.timepost.main;

/**
 * Created by sgt on 2018/8/24 0024.
 */
public class RunProgram {
    public static void main(String[] args) {
       Thread thread = new Thread(new EmailCrawler(),"EmailCrawler");
       thread.start();
       Thread thread1 = new Thread(new EmailSaveService(),"EmailSaveService");
       thread1.start();
    }
}
