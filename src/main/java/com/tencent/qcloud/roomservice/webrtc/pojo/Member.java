package com.tencent.qcloud.roomservice.webrtc.pojo;

import org.codehaus.jackson.annotate.JsonIgnore;

public class Member {
    private String userID = "";
    private String nickName = "";
    private long timeStamp = 0;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @JsonIgnore
    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "userID=" + userID + ", nickName=" + nickName + ", timeStamp=" + timeStamp;
    }
}
