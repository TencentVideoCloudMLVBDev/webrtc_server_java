package com.tencent.qcloud.roomservice.webrtc.pojo.Request;

public class EnterRoomReq {
    private String userID = "";
    private String nickName = ""; //用户昵称
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
