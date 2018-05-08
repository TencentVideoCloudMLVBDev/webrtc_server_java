## 项目结构
```
roomserver
├── README.md
├── pom.xml
└── src/main
    ├── java/com/tencent/qcloud/roomservice/webrtc
    │   ├── common
    │   │   └── Config.java
    │   ├── controller
    │   │   └── WebRTCRoom.java
    │   ├── logic
    │   │   ├── IMMgr.java
    │   │   └── WebRTCRoomMgr.java
    │   ├── pojo
    │   │   ├── Audience.java
    │   │   ├── Pusher.java
    │   │   ├── Request
    │   │   │   ├── CreateRoomReq.java
    │   │   │   ├── EnterRoomReq.java
    │   │   │   ├── GetLoginInfoReq.java
    │   │   │   ├── GetRoomListReq.java
    │   │   │   ├── HeartBeatReq.java
    │   │   │   └── QuitRoomReq.java
    │   │   ├── Response
    │   │   │   ├── BaseRsp.java
    │   │   │   ├── CreateRoomRsp.java
    │   │   │   ├── EnterRoomRsp.java
    │   │   │   ├── GetLoginInfoRsp.java
    │   │   │   └── GetRoomListRsp.java
    │   │   └── WebRTCRoom.java
    │   ├── service
    │   │   ├── impl
    │   │   │   └── WebRTCRoomServiceImpl.java
    │   │   └── WebRTCRoomService.java
    │   ├── utils
    │   │   ├── RestTemplateConfig.java
    │   │   └──  Utils.java
    ├── java/com/tls
    │   ├── base64_url
    │   │   └── base64_url.java
    │   ├── tls_sigature
    │   │   └── tls_sigature.java
    ├── resources
    │   ├── applicationContext.xml
    │   └── logback.xml
    └── webapp/WEB-INF
        ├── dispatcher-servlet.xml
        ├── web.xml
        └── lib
```
后台使用spring框架搭建，开发环境是IntelliJ IDEA，java需要使用1.8

`pom.xml` 是 maven 依赖配置文件。

`WebRTCRoom.java` 是 服务器端 房间业务逻辑。

`Config.java` 主要的配置如下：

`logic/IMMgr.java` 云通信相关的处理，主要功能有：
```
getLoginInfo,                // 获取sdkAppID、accountType、userSig票据等信息
getPrivMapEncrypt,           // 获取视频权限位
```

`logic/WebRTCRoomMgr.java` 实时音视频房间管理模块，负责视频房间的创建，进房，退房，获取房间列表功能函数；另外也负责房间成员的心跳检查，对超时的成员进行删除处理。
