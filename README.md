# 腾讯云音视频webrtc解决方案服务端

在构建webrtc业务场景下，都需要后台配合完成诸如：

- 管理房间列表和视频位
- 生成userSig和privateMapKey，用于进入webrtc房间

以上这些都有一定的学习成本，为了**降低学习成本**，我们将后台封装了一套接口，来解决以上问题。再配合IOS，Android，小程序和Win PC端的后台调用封装。对应用开发者提供一套友好的接口，方便您实现webrtc多人实时音视频业务场景。

**特别说明：**

- [1] 后台没有对接口的调用做安全校验，这需要您结合您自己的账号和鉴权体系，诸如在请求接口上加一个Sig参数，内容是您账号鉴权体系派发的一个字符串，用于校验请求者的身份。
- [2] 房间管理采用 java对象直接在内存中进行管理。房间信息动态和实效性，因此没有采用数据库做持久存储，而是在内存中动态管理。

## 云服务开通

### 开通实时音视频服务

#### 申请开通实时音视频服务
进入 [实时音视频管理控制台](https://console.qcloud.com/rav)，如果服务还没有开通，则会有如下提示:
![](https://main.qcloudimg.com/raw/989a89e702858048b5b6c945a371f75c.png)
点击申请开通，之后会进入腾讯云人工审核阶段，审核通过后即可开通。

#### 创建实时音视频应用
实时音视频开通后，进入[【实时音视频管理控制台】](https://console.qcloud.com/rav) 创建实时音视频应用 ：
![](https://main.qcloudimg.com/raw/20d0adeadf23251f857571a65a8dd569.png)
点击【确定】按钮即可。

#### 获取实时音视频配置信息
从实时音视频控制台获取`sdkAppID、accountType、privateKey`，后面配置服务器会用到：
![](https://main.qcloudimg.com/raw/9a5f341883f911cf9b65b9b5487f2f75.png)


## 修改配置信息
后台使用spring框架搭建，开发环境是IntelliJ IDEA，java需要使用1.8。用IntelliJ IDEA导入工程源码，修改Config.java 中`sdkAppID、accountType、privateKey`等配置项。

```java
public class Config {

    /**
     * 需要开通 实时音视频 服务
     * 有介绍appid 和 accType的获取方法。以及私钥文件的下载方法。
     */
    public class iLive {
        public final static long sdkAppID = 0;

        public final static String accountType = "0";

        /**
         * 派发userSig 和 privateMapKey 采用非对称加密算法RSA，用私钥生成签名。privateKey就是用于生成签名的私钥，私钥文件可以在互动直播控制台获取
         * 配置privateKey
         * 将private_key文件的内容按下面的方式填写到 privateKey字段。
         */
        public final static String privateKey = "-----BEGIN PRIVATE KEY-----\n" +
                "xxxx\n" +
                "xxxx\n" +
                "xxxx\n" +
                "-----END PRIVATE KEY-----";
    }


    /**
     * webrtc房间相关参数
     */
    public class WebRTCRoom {
        // 房间容量上限
        public final static int maxMembers = 4;

        // 心跳超时 单位秒
        public final static int heartBeatTimeout = 20;
    }

}
```

## 服务器部署

以CentOS 系统为例，描述部署过程。采用CentOS + nginx + Apache Tomcat + java 的 环境。小程序和IOS都要求服务器支持HTTPS请求。和远程服务器通讯一般走ssh连接，可以用工具Xshell，secureCRT连接服务器。对于小文件（小于100kB）可以用rz 命令从本机传送文件至服务器，以及sz命令从远程服务器下载文件。非常方便。

### 准备发布包
Config.java中的配置修改好之后打成war包。

### war包部署到服务器
将打包好的roomservice.war包通过rz命令上传到服务器 tomcat 的 webapps 目录下。通过 tomcat/bin 目录下的 startup.sh 脚本启动 tomcat。 

### nginx 配置
如果您已经有**域名**以及域名对应的**SSL证书**存放在`/data/release/nginx/`目录下，请将下面配置内容中的
- [1] 替换成您自己的域名
- [2-1] 替换成SSL证书的crt文件名
- [2-2] 替换成SSL证书的key文件名

```
upstream app_weapp {
    server localhost:5757;
    keepalive 8;
}

#http请求转为 https请求
server {
    listen      80;
    server_name [1]; 

    rewrite ^(.*)$ https://$server_name$1 permanent;
}

#https请求
server {
    listen      443;
    server_name [1];

    ssl on;

    ssl_certificate           /data/release/nginx/[2-1];
    ssl_certificate_key       /data/release/nginx/[2-2];
    ssl_session_timeout       5m;
    ssl_protocols             TLSv1 TLSv1.1 TLSv1.2;
    ssl_ciphers               ECDHE-RSA-AES256-GCM-SHA384:ECDHE-RSA-AES128-GCM-SHA256:DHE-RSA-AES256-GCM-SHA384:ECDHE-RSA-AES256-SHA384:ECDHE-RSA-AES128-SHA256:ECDHE-RSA-AES256-SHA:ECDHE-RSA-AES128-SHA:DHE-RSA-AES256-SHA:DHE-RSA-AES128-SHA;
    ssl_session_cache         shared:SSL:50m;
    ssl_prefer_server_ciphers on;

    # tomcat默认端口是8080，转发给tomcat处理
    location / {
        proxy_pass   http://127.0.0.1:8080;
        proxy_redirect  off;
        proxy_set_header  X-Real-IP $remote_addr;
        proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
    }
}
```

### 运行服务
输入命令，启动Nginx服务。
```
nginx -s reload
```
通过Postman访问接口，就可以看到返回的json数据了。注意要按照接口定义正确填写body。
建房为例，请求地址格式 https://您自己的域名/roomservice/weapp/webrtc_room/create_room

## 小程序和web端部署

下载[小程序](http://liteavsdk-1252463788.cosgz.myqcloud.com/xiaochengxu/RTCRoomRelease1.2.693.zip)和[web端](http://liteavsdk-1252463788.cosgz.myqcloud.com/windows/webRTCForChrome/WebRTC_20180428_093242.zip)的源码，分别修改代码中的后台地址

小程序wxlite/config.js文件中的`webrtcServerUrl`修改成 *https://您自己的域名/webrtc/weapp/webrtc_room*

web端component/WebRTCRoom.js文件中的`serverDomain`修改成 *https://您自己的域名/webrtc/weapp/webrtc_room*


## 开发者资源
* [项目结构](https://github.com/TencentVideoCloudMLVBDev/RTCRoomDemo/blob/master/doc/%E5%B0%8F%E7%A8%8B%E5%BA%8F%E9%A1%B9%E7%9B%AE%E7%BB%93%E6%9E%84.md) - 后台源码结构
* [协议文档](https://cloud.tencent.com/document/product/454/15364) - 后台协议文档
