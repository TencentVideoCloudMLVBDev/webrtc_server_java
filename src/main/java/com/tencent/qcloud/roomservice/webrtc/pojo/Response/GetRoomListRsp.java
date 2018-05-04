package com.tencent.qcloud.roomservice.webrtc.pojo.Response;

import com.tencent.qcloud.roomservice.webrtc.pojo.WebRTCRoom;

import java.util.ArrayList;

public class GetRoomListRsp extends BaseRsp {
    private ArrayList<WebRTCRoom> rooms;

    public ArrayList<WebRTCRoom> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<WebRTCRoom> rooms) {
        this.rooms = rooms;
    }
}
