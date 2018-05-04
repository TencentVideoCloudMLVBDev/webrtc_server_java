package com.tencent.qcloud.roomservice.webrtc.pojo.Response;

public class GetLoginInfoRsp extends BaseRsp {
    private long sdkAppID = 0;
    private String accountType = "";
    private String userID = "";
    private String userSig = "";

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserSig() {
        return userSig;
    }

    public void setUserSig(String userSig) {
        this.userSig = userSig;
    }


    public long getSdkAppID() {
        return sdkAppID;
    }

    public void setSdkAppID(long sdkAppID) {
        this.sdkAppID = sdkAppID;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
