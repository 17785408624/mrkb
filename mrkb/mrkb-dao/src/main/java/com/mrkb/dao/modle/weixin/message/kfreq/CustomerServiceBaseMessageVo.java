package com.mrkb.dao.modle.weixin.message.kfreq;
/**
 * Created by Administrator on 2017/3/20.
 */
public class CustomerServiceBaseMessageVo {
    private String touser;

    private String msgtype;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }
}