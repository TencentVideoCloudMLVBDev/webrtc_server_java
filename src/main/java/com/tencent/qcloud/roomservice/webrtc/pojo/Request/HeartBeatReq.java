package com.tencent.qcloud.roomservice.webrtc.pojo.Request;

public class HeartBeatReq {
    private String userID = "";
    private String roomID = "";

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }
}
