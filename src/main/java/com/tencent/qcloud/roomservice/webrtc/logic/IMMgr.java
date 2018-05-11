package com.tencent.qcloud.roomservice.webrtc.logic;

import com.tencent.qcloud.roomservice.webrtc.common.Config;
import com.tencent.qcloud.roomservice.webrtc.pojo.Response.GetLoginInfoRsp;
import com.tencent.qcloud.roomservice.webrtc.utils.Utils;
import com.tls.WebRTCSigApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class IMMgr {
    private static Logger log= LoggerFactory.getLogger(IMMgr.class);

    public GetLoginInfoRsp getLoginInfo(String userID) {
        GetLoginInfoRsp rsp = new GetLoginInfoRsp();

        String pattern = "^[a-zA-Z][a-zA-Z0-9_]{3,23}$";
        if (userID.length() == 0) {
            userID = Utils.genUserIdByRandom();
        } else if (!Pattern.matches(pattern, userID)) {
            rsp.setCode(7);
            rsp.setMessage("请求失败，userID含有非法字符或者不符合规范");
            return rsp;
        }

        WebRTCSigApi api = new WebRTCSigApi();
        api.setSdkAppid((int) Config.iLive.sdkAppID);
        api.setPrivateKey(Config.iLive.privateKey);
        String userSig = api.genUserSig(userID, 60 * 60);

        rsp.setCode(0);
        rsp.setMessage("请求成功");
        rsp.setSdkAppID(Config.iLive.sdkAppID);
        rsp.setAccountType(Config.iLive.accountType);
        rsp.setUserID(userID);
        rsp.setUserSig(userSig);

        log.info("getLoginInfo, userID:" + userID);

        return rsp;
    }

    /**
     * 获取webrtcroom的权限位
     * @param userID
     * @return 权限位
     */
    public String getPrivMapEncrypt(String userID, String roomID) {
        WebRTCSigApi api = new WebRTCSigApi();
        api.setSdkAppid((int) Config.iLive.sdkAppID);
        api.setPrivateKey(Config.iLive.privateKey);

        String privMapEncrypt = api.genPrivMapEncrypt(userID, Integer.parseInt(roomID), 60 * 60);

        return privMapEncrypt;
    }
}
