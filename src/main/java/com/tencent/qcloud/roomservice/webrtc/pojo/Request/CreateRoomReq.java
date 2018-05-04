package com.tencent.qcloud.roomservice.webrtc.pojo.Request;

public class CreateRoomReq {
    private String userID = "";
    private String nickName = ""; //用户昵称
    private String roomInfo = "";

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getRoomInfo() {
        return roomInfo;
    }

    public void setRoomInfo(String roomInfo) {
        this.roomInfo = roomInfo;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
