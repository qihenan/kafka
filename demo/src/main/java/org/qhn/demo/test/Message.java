package org.qhn.demo.test;

import java.util.Date;

/**
 * @Auther: qihenan
 * @Date: 2019/12/25 16:06
 * @Description:
 */
public class Message {

    private Long id;    //id

    private String msg; //消息

    private Date sendTime;  //时间戳

    public void setId(Long id) {
        this.id = id;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Long getId() {
        return id;
    }

    public String getMsg() {
        return msg;
    }

    public Date getSendTime() {
        return sendTime;
    }
}
