package com.tencent.qcloud.roomservice.webrtc.pojo;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class WebRTCRoom {
    private String roomID = "";
    private String roomInfo = "";
    private ConcurrentHashMap<String, Member> membersMap = new ConcurrentHashMap<>();

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


    @JsonIgnore
    public int getMembersCnt() {
        return membersMap.size();
    }

    @JsonIgnore
    public ConcurrentHashMap<String, Member> getMembersMap() {
        return this.membersMap;
    }

    @JsonIgnore
    public ArrayList<Member> getMembers() {
        ArrayList<Member> members = new ArrayList<>();
        for (Member member : this.membersMap.values()) {
            members.add(member);
        }
        return members;
    }

    public void addMember(String userID, String nickName) {
        Member member = new Member();
        member.setUserID(userID);
        member.setNickName(nickName);
        member.setTimeStamp(System.currentTimeMillis()/1000);
        this.membersMap.put(userID, member);
    }

    public void updateMember(String userID) {
        Member member = this.membersMap.get(userID);
        if (member != null) {
            member.setTimeStamp(System.currentTimeMillis()/1000);
        }
    }

    @JsonIgnore
    public boolean isMember(String userID) {
        return this.membersMap.containsKey(userID);
    }

    public void delMember(String userID) {
        this.membersMap.remove(userID);
    }
}
