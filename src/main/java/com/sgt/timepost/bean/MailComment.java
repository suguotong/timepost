package com.sgt.timepost.bean;

import java.util.Date;

/**
 * Created by sgt on 2018/8/22 0022.
 */
public class MailComment {
    //投递人
    private String name;
    //投递人邮箱
    private String email;
    //邮件内容
    private String content;
    //写信时间
    private Date timeStart;
    //邮寄时间
    private Date timeEnd;
    //邮件类型
    private String Type;

    public MailComment(String name, String email, Date timeStart, Date timeEnd, String type) {
        this.name = name;
        this.email=email;
        this.timeStart=timeStart;
        this.timeEnd=timeEnd;
        this.Type=type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }


    public String toString() {
        return "[name：" + name + ",email:" + email + ",content:" + content + "]";
    }

}
