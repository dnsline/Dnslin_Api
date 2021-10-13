### 此项目为一些实用的Api

目前已经支持的有

- [x] ICP备案信息查询
- [x] IDEA激活码获取
- [x] IP查询
- [ ] 国内IP定位查询
- [ ] 和风天气API查询
- [ ] 随机壁纸
- [ ] 二维码生成
- [ ] Bing图片
- [ ] 随机古诗词
- [ ] hitokoto一言
- [ ] 获取QQ头像
- [ ] 历史上的今天
- [ ] 获取QQ头像
- [ ] 手机号归属地查询
- [ ] 网易云歌曲热评
- [ ] 腾讯天气API

+ ICP备案信息查询
```url
例：
    methods: GET
    参数:String domain
    请求地址: url/api/icp?domain="domain" 
    domain[baidu.com]
```

+ IDEA激活码获取
```url
 例：
    methods: GET
    参数:None
    请求地址: url/api/cdkey
 ```
+ IP查询
```url
 例：
    methods: GET
    请求地址: url/api/IPPosition
    http://127.0.0.1:5678/api/IPPosition/?format=json&ipaddress=66.249.64.247&lang=zh-CN
```
参数:
|  format                          |  formats                  |  ipaddress |  lang |  fields |
| -------------------------------------- | ------------------------------- | ---------------- | ----------- | ------------- |
| String                                 | String                          | String           | String      | String        |
| `json` `jsonp` `xml` `csv` `yaml` | `json` `xml ` `csv` `newline` `php` | IPV4/IPV6 | `en` `de` `es` `pt-BR` `ja` `fr` `zh-CN` `ru` | Null |


**TODO: 国内IP定位查询查询**

> 目前大多数未实现  
by [林祈](https://dnslin.com)
