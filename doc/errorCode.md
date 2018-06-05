## 常见错误码含义

| 错误码 | 具体含义 |
|---------|---------|
| 415 | Unsupported Media Type。请求包体不是json格式 |
| 400 | Bad Request。请求包体是json格式，但是字段不符合协议。在用postman调试后台接口的时候，body至少要填一对花括号**{}** |
| 500 | Internal Server Error 服务器内部错误，根据具体的错误信息分析。一般是Config.java配置有问题或者java版本不合要求导致 |

