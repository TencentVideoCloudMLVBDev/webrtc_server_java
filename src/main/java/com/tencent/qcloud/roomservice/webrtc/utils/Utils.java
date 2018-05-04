package com.tencent.qcloud.roomservice.webrtc.utils;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class Utils {
    public static String getMD5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String S4 () {
        return UUID.randomUUID().toString().substring(9, 13);
    }

    /**
     * 随机生成user_id
     */
    public static String genUserIdByRandom () {
        return "user_" + (S4() + S4() + "_" + S4());
    }

    /**
     * 随机生成room_id
     */
    public static String genRoomIdByRandom () {
        return "room_" + (S4() + S4() + "_" + S4());
    }

    public static String objectToString(Object obj){
        ObjectMapper mapper = new ObjectMapper();
        StringWriter writer = new StringWriter();

        try {
            mapper.writeValue(writer, obj);
            return writer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "{}";
    }
}
