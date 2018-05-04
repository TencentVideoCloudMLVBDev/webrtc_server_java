package com.tencent.qcloud.roomservice.webrtc.pojo.Response;

public class CreateRoomRsp extends BaseRsp {
    private String userID = ""; //用户id
    private String roomID  = ""; // 房间id
    private String roomInfo = ""; //  房间名
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

    public String getRoomInfo() {
        return roomInfo;
    }

    public void setRoomInfo(String roomInfo) {
        this.roomInfo = roomInfo;
    }

    public String getPrivateMapKey() {
        return privateMapKey;
    }

    public void setPrivateMapKey(String privateMapKey) {
        this.privateMapKey = privateMapKey;
    }
}
