package com.tencent.qcloud.roomservice.webrtc.pojo.Request;

public class GetRoomListReq {
    private int index = 0; // 起始位置
    private int count = 10; // 需要获取的记录条数
    private String roomType = ""; //房间类型，可以为空

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
}
