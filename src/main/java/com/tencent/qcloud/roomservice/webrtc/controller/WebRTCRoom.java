package com.tencent.qcloud.roomservice.webrtc.controller;

import com.tencent.qcloud.roomservice.webrtc.pojo.Request.*;
import com.tencent.qcloud.roomservice.webrtc.pojo.Response.*;
import com.tencent.qcloud.roomservice.webrtc.service.WebRTCRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * webrtc房间接口
 */
@Controller
@ResponseBody
@RequestMapping("/weapp/webrtc_room")
public class WebRTCRoom {
    @Autowired
    WebRTCRoomService webRTCRoomService;

    @ResponseBody
    @RequestMapping("get_login_info")
    public GetLoginInfoRsp get_login_info(@RequestBody GetLoginInfoReq req){
        return webRTCRoomService.getLoginInfo(req.getUserID());
    }

    @ResponseBody
    @RequestMapping("create_room")
    public CreateRoomRsp create_room(@RequestBody CreateRoomReq req){
        return webRTCRoomService.createRoom(req);
    }

    @ResponseBody
    @RequestMapping("enter_room")
    public EnterRoomRsp enter_room(@RequestBody EnterRoomReq req){
        return webRTCRoomService.enterRoom(req);
    }

    @ResponseBody
    @RequestMapping("quit_room")
    public BaseRsp quit_room(@RequestBody QuitRoomReq req){
        return webRTCRoomService.quitRoom(req);
    }

    @ResponseBody
    @RequestMapping("heartbeat")
    public BaseRsp heartbeat(@RequestBody HeartBeatReq req) {
        return webRTCRoomService.heartbeat(req);
    }

    @ResponseBody
    @RequestMapping("get_room_list")
    public GetRoomListRsp get_room_list(@RequestBody GetRoomListReq req) {
        return webRTCRoomService.getRoomList(req);
    }

    @ResponseBody
    @RequestMapping("get_room_members")
    public GetRoomMembersRsp get_room_members(@RequestBody GetRoomMembersReq req){
        return webRTCRoomService.getRoomMembers(req);
    }
}