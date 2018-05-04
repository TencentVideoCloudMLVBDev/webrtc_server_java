package com.tencent.qcloud.roomservice.webrtc.pojo.Response;

public class BaseRsp {
    private int code = 0;
    private String message = "请求成功";

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
