## 项目结构
```
roomserver
├── README.md                 //项目总体说明文档
├── doc
│   ├── codeStructure.md     //项目结构文档
│   └── protocol.md          //后台协议文档
├── pom.xml                  //maven 依赖配置文件
├── src                      //java源代码目录
│   └── main
│       ├── java
│       │   └── com
│       │       ├── tencent
│       │       │   └── qcloud
│       │       │       └── roomservice
│       │       │           └── webrtc
│       │       │               ├── common
│       │       │               │   ├── CORSFilter.java               //跨域设置类
│       │       │               │   └── Config.java                   //后台配置，需要修改这里
│       │       │               ├── controller
│       │       │               │   └── WebRTCRoom.java               //后台协议总入口
│       │       │               ├── logic
│       │       │               │   ├── IMMgr.java                    //云通信逻辑实现
│       │       │               │   └── WebRTCRoomMgr.java            //房间管理实现
│       │       │               ├── pojo
│       │       │               │   ├── Member.java                   //成员结构定义
│       │       │               │   ├── Request
│       │       │               │   │   ├── CreateRoomReq.java        //建房请求定义
│       │       │               │   │   ├── EnterRoomReq.java         //进房请求定义
│       │       │               │   │   ├── GetLoginInfoReq.java      //getLoginInfo请求定义
│       │       │               │   │   ├── GetRoomListReq.java       //获取房间列表请求定义
│       │       │               │   │   ├── GetRoomMembersReq.java    //获取房间内成员请求定义
│       │       │               │   │   ├── HeartBeatReq.java         //心跳请求定义
│       │       │               │   │   └── QuitRoomReq.java          //退房请求定义
│       │       │               │   ├── Response
│       │       │               │   │   ├── BaseRsp.java              //回包通用定义
│       │       │               │   │   ├── CreateRoomRsp.java        //建房回包定义
│       │       │               │   │   ├── EnterRoomRsp.java         //进房回包定义
│       │       │               │   │   ├── GetLoginInfoRsp.java      //getLoginInfo回包定义
│       │       │               │   │   ├── GetRoomListRsp.java       //获取房间列表回包定义
│       │       │               │   │   └── GetRoomMembersRsp.java    //获取房间成员回包定义
│       │       │               │   └── WebRTCRoom.java               //房间结构定义
│       │       │               ├── service
│       │       │               │   ├── WebRTCRoomService.java        //房间管理服务service实现
│       │       │               │   └── impl
│       │       │               │       └── WebRTCRoomServiceImpl.java //房间管理服务service接口
│       │       │               └── utils
│       │       │                   ├── RestTemplateConfig.java       //http请求配置
│       │       │                   └── Utils.java                    //通用类
│       │       └── tls
│       │           └── WebRTCSigApi.java                             //计算UserSig和视频权限位的类
│       ├── resources
│       │   ├── applicationContext.xml                                //spring配置文件
│       │   └── logback.xml                                           //log配置文件
│       └── webapp
│           ├── WEB-INF
│           │   ├── dispatcher-servlet.xml                            //spring配置文件
│           │   └── web.xml                                           //后台配置文件
│           └── index.jsp
└── webrtc.iml
```
后台使用spring框架搭建，开发环境是IntelliJ IDEA，java需要使用1.8

`pom.xml` 是 maven 依赖配置文件。

`WebRTCRoom.java` 是 服务器端 房间业务逻辑。

`logic/IMMgr.java` 云通信相关的处理，主要功能有：
```
getLoginInfo,                // 获取sdkAppID、accountType、userSig票据等信息
getPrivMapEncrypt,           // 获取视频权限位
```

`logic/WebRTCRoomMgr.java` 实时音视频房间管理模块，负责视频房间的创建，进房，退房，获取房间列表功能函数；另外也负责房间成员的心跳检查，对超时的成员进行删除处理。
