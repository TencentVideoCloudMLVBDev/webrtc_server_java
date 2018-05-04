package com.tencent.qcloud.roomservice.webrtc.pojo.Response;

public class EnterRoomRsp extends BaseRsp {
    private String userID = ""; //用户id
    private String roomID  = ""; // 房间id
    private String privateMapKey = ""; // 权限位

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

    public String getPrivateMapKey() {
        return privateMapKey;
    }

    public void setPrivateMapKey(String privateMapKey) {
        this.privateMapKey = privateMapKey;
    }
}
