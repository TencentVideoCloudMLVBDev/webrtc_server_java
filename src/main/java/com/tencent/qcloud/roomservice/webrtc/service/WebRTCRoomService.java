package com.tencent.qcloud.roomservice.webrtc.service;

import com.tencent.qcloud.roomservice.webrtc.pojo.Request.*;
import com.tencent.qcloud.roomservice.webrtc.pojo.Response.*;

public interface WebRTCRoomService {
    GetLoginInfoRsp getLoginInfo(String userID);
    CreateRoomRsp createRoom(CreateRoomReq req);
    EnterRoomRsp enterRoom(EnterRoomReq req);
    BaseRsp quitRoom(QuitRoomReq req);
    BaseRsp heartbeat(HeartBeatReq req);
    GetRoomListRsp getRoomList(GetRoomListReq req);
    GetRoomMembersRsp getRoomMembers(GetRoomMembersReq roomID);
}