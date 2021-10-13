### 此项目为一些实用的Api

目前已经支持的有

- [x] ICP备案信息查询
- [x] IDEA激活码获取
- [x] IP查询
- [ ] IP批量查询
- [ ] DNS查询
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
```json
{
  "code": "200",
  "message": "成功003",
  "data": {
    "unitName": "北京百度网讯科技有限公司",
    "limitAccess": "否",
    "natureName": "企业",
    "serviceName": "百度",
    "updateRecordTime": "2021-08-30 13:10:24",
    "domainId": "10000245113",
    "homeUrl": "www.baidu.com",
    "serviceLicence": "京ICP证030173号-1",
    "leaderName": "",
    "domain": "baidu.com",
    "mainLicence": "京ICP证030173号",
    "mainId": "282751",
    "serviceId": "282911",
    "contentTypeName": ""
  }
}
```

+ IDEA激活码获取
```url
 例：
    methods: GET
    参数:None
    请求地址: url/api/cdkey
 ```
响应:
```json
{
  "code": "200",
  "message": "成功003",
  "data": [
    {
      "id": 1,
      "date": "2021-10-13",
      "remark": "MS4S2AUY9Y - for 2018.1 or earlier.txt",
      "key": "MS4S2AUY9Y-eyJsaWNlbnNlSWQiOiJNUzRTMkFVWTlZIiwibGljZW5zZWVOYW1lIjoi5rC45LmF5r+A5rS7IHd3d8K3YWppaHVvwrdjb20iLCJhc3NpZ25lZU5hbWUiOiIiLCJhc3NpZ25lZUVtYWlsIjoiIiwibGljZW5zZVJlc3RyaWN0aW9uIjoiIiwiY2hlY2tDb25jdXJyZW50VXNlIjpmYWxzZSwicHJvZHVjdHMiOlt7ImNvZGUiOiJJSSIsInBhaWRVcFRvIjoiMjAyMS0xMS0xMiJ9LHsiY29kZSI6IlBEQiIsInBhaWRVcFRvIjoiMjAyMS0xMS0xMiJ9LHsiY29kZSI6IlBXUyIsInBhaWRVcFRvIjoiMjAyMS0xMS0xMiJ9LHsiY29kZSI6IlBHTyIsInBhaWRVcFRvIjoiMjAyMS0xMS0xMiJ9LHsiY29kZSI6IlBQUyIsInBhaWRVcFRvIjoiMjAyMS0xMS0xMiJ9LHsiY29kZSI6IlBQQyIsInBhaWRVcFRvIjoiMjAyMS0xMS0xMiJ9LHsiY29kZSI6IlBSQiIsInBhaWRVcFRvIjoiMjAyMS0xMS0xMiJ9LHsiY29kZSI6IlBTVyIsInBhaWRVcFRvIjoiMjAyMS0xMS0xMiJ9LHsiY29kZSI6IlBTSSIsInBhaWRVcFRvIjoiMjAyMS0xMS0xMiJ9LHsiY29kZSI6IlBDV01QIiwicGFpZFVwVG8iOiIyMDIxLTExLTEyIn1dLCJoYXNoIjoiMjY5NTczNTkvMDotMjI5NDI0NTE2IiwiZ3JhY2VQZXJpb2REYXlzIjo3LCJhdXRvUHJvbG9uZ2F0ZWQiOmZhbHNlLCJpc0F1dG9Qcm9sb25nYXRlZCI6ZmFsc2V9-uGR6CH3Fii0jitJNQfjQHfrYw4eJxP1zNwOgeHfX/5azBw3V9v0bCWpoATy5NVAIx/KFnKoykg63aFwOn1OyluWfvLyygjBM3K3h+EldFEcVXKoQen6ayVAHs6aRf19BI03MVuSx17y09cnaVjh0/UEgYNoBcybVHwKVcA51LW0vpMa57WcgHvgGMsp6w16wu+gWKhoqdKYYG9fMlBZICXg5bJGpen3LwGjdOXNUT3U/NqD1nKV+Q6tc0xB8GyPgufz5SUBNv1rSdK+29uq8mFyyYq44WSU9NmPRO1iHendryNZduha9gPsdWAq5jGiIh/4Nrev2uDdOh//bzVVRHg==-MIIETDCCAjSgAwIBAgIBDTANBgkqhkiG9w0BAQsFADAYMRYwFAYDVQQDDA1KZXRQcm9maWxlIENBMB4XDTIwMTAxOTA5MDU1M1oXDTIyMTAyMTA5MDU1M1owHzEdMBsGA1UEAwwUcHJvZDJ5LWZyb20tMjAyMDEwMTkwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQDCP4uk4SlVdA5nuA3DQC+NsEnZS9npFnO0zrmMWcz1++q2UWJNuGTh0rwi+3fUJIArfvVh7gNtIp93rxjtrQAuf4/Fa6sySp4c32MeFACfC0q+oUoWebhOIaYTYUxm4LAZ355vzt8YeDPmvWKxA81udqEk4gU9NNAOz1Um5/8LyR8SGsSc4EDBRSjcMWMwMkYSauGqGcEUK8WhfplsyF61lKSOFA6VmfUmeDK15rUWWLbOMKgn2cxFA98A+s74T9Oo96CU7rp/umDXvhnyhAXSukw/qCGOVhwKR8B6aeDtoBWQgjnvMtPgOUPRTPkPGbwPwwDkvAHYiuKJ7Bd2wH7rAgMBAAGjgZkwgZYwCQYDVR0TBAIwADAdBgNVHQ4EFgQUJNoRIpb1hUHAk0foMSNM9MCEAv8wSAYDVR0jBEEwP4AUo562SGdCEjZBvW3gubSgUouX8bOhHKQaMBgxFjAUBgNVBAMMDUpldFByb2ZpbGUgQ0GCCQDSbLGDsoN54TATBgNVHSUEDDAKBggrBgEFBQcDATALBgNVHQ8EBAMCBaAwDQYJKoZIhvcNAQELBQADggIBAB2J1ysRudbkqmkUFK8xqhiZaYPd30TlmCmSAaGJ0eBpvkVeqA2jGYhAQRqFiAlFC63JKvWvRZO1iRuWCEfUMkdqQ9VQPXziE/BlsOIgrL6RlJfuFcEZ8TK3syIfIGQZNCxYhLLUuet2HE6LJYPQ5c0jH4kDooRpcVZ4rBxNwddpctUO2te9UU5/FjhioZQsPvd92qOTsV+8Cyl2fvNhNKD1Uu9ff5AkVIQn4JU23ozdB/R5oUlebwaTE6WZNBs+TA/qPj+5/wi9NH71WRB0hqUoLI2AKKyiPw++FtN4Su1vsdDlrAzDj9ILjpjJKA1ImuVcG329/WTYIKysZ1CWK3zATg9BeCUPAV1pQy8ToXOq+RSYen6winZ2OO93eyHv2Iw5kbn1dqfBw1BuTE29V2FJKicJSu8iEOpfoafwJISXmz1wnnWL3V/0NxTulfWsXugOoLfv0ZIBP1xH9kmf22jjQ2JiHhQZP7ZDsreRrOeIQ/c4yR8IQvMLfC0WKQqrHu5ZzXTH4NO3CwGWSlTY74kE91zXB5mwWAx1jig+UXYc2w4RkVhy0//lOmVya/PEepuuTTI4+UJwC7qbVlh5zfhj8oTNUXgN0AOc+Q0/WFPl1aw5VV/VrO8FCoB15lFVlpKaQ1Yh+DVU8ke+rt9Th0BCHXe0uZOEmH0nOnH/0onD"
    },
    {
      "id": 2,
      "date": "2021-10-13",
      "remark": "MS4S2AUY9Y - for 2018.2 or later.txt",
      "key": "MS4S2AUY9Y-eyJsaWNlbnNlSWQiOiJNUzRTMkFVWTlZIiwibGljZW5zZWVOYW1lIjoi5rC45LmF5r+A5rS7IHd3d8K3YWppaHVvwrdjb20iLCJhc3NpZ25lZU5hbWUiOiIiLCJhc3NpZ25lZUVtYWlsIjoiIiwibGljZW5zZVJlc3RyaWN0aW9uIjoiIiwiY2hlY2tDb25jdXJyZW50VXNlIjpmYWxzZSwicHJvZHVjdHMiOlt7ImNvZGUiOiJJSSIsInBhaWRVcFRvIjoiMjAyMS0xMS0xMiIsImV4dGVuZGVkIjpmYWxzZX0seyJjb2RlIjoiUERCIiwicGFpZFVwVG8iOiIyMDIxLTExLTEyIiwiZXh0ZW5kZWQiOnRydWV9LHsiY29kZSI6IlBXUyIsInBhaWRVcFRvIjoiMjAyMS0xMS0xMiIsImV4dGVuZGVkIjp0cnVlfSx7ImNvZGUiOiJQR08iLCJwYWlkVXBUbyI6IjIwMjEtMTEtMTIiLCJleHRlbmRlZCI6dHJ1ZX0seyJjb2RlIjoiUFBTIiwicGFpZFVwVG8iOiIyMDIxLTExLTEyIiwiZXh0ZW5kZWQiOnRydWV9LHsiY29kZSI6IlBQQyIsInBhaWRVcFRvIjoiMjAyMS0xMS0xMiIsImV4dGVuZGVkIjp0cnVlfSx7ImNvZGUiOiJQUkIiLCJwYWlkVXBUbyI6IjIwMjEtMTEtMTIiLCJleHRlbmRlZCI6dHJ1ZX0seyJjb2RlIjoiUFNXIiwicGFpZFVwVG8iOiIyMDIxLTExLTEyIiwiZXh0ZW5kZWQiOnRydWV9LHsiY29kZSI6IlBTSSIsInBhaWRVcFRvIjoiMjAyMS0xMS0xMiIsImV4dGVuZGVkIjp0cnVlfSx7ImNvZGUiOiJQQ1dNUCIsInBhaWRVcFRvIjoiMjAyMS0xMS0xMiIsImV4dGVuZGVkIjp0cnVlfV0sIm1ldGFkYXRhIjoiMDEyMDIxMTAxM1BTQU0wMDAwMDUiLCJoYXNoIjoiMjY5NTczNTkvMDotMjI5NDI0NTE2IiwiZ3JhY2VQZXJpb2REYXlzIjo3LCJhdXRvUHJvbG9uZ2F0ZWQiOmZhbHNlLCJpc0F1dG9Qcm9sb25nYXRlZCI6ZmFsc2V9-CwB6EhBbIKbH/JyItaJp81jG2HsATnWTbNwcmwkMbmB1Xi/4FWAg9ahmjU7pSKloS5u8NDxpQ55t/NDA7wJhrd3cIPnYZpZIjotpKqBulGBN1jG3743FMELpgq3mWPybiaDF2kqz4VyENRwgVKu2vckj/o69pze2s7mXrymcDqeAngZ0prFz9PS0O5LAS0/3hCJNZkYy8hGdMgF8LR+kliQk4cDZmOdVN0e1z7DZ4cbofuxDRflMjCZJc+d1SehO7xnwv+W0AhrKY9tqgDlWBcX0GIsziiO63p0ydCCyfXFWv7Py1cyE4K0MTojSfxEim6TCWLQAzlG7ww3Wom1m0w==-MIIETDCCAjSgAwIBAgIBDTANBgkqhkiG9w0BAQsFADAYMRYwFAYDVQQDDA1KZXRQcm9maWxlIENBMB4XDTIwMTAxOTA5MDU1M1oXDTIyMTAyMTA5MDU1M1owHzEdMBsGA1UEAwwUcHJvZDJ5LWZyb20tMjAyMDEwMTkwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQDCP4uk4SlVdA5nuA3DQC+NsEnZS9npFnO0zrmMWcz1++q2UWJNuGTh0rwi+3fUJIArfvVh7gNtIp93rxjtrQAuf4/Fa6sySp4c32MeFACfC0q+oUoWebhOIaYTYUxm4LAZ355vzt8YeDPmvWKxA81udqEk4gU9NNAOz1Um5/8LyR8SGsSc4EDBRSjcMWMwMkYSauGqGcEUK8WhfplsyF61lKSOFA6VmfUmeDK15rUWWLbOMKgn2cxFA98A+s74T9Oo96CU7rp/umDXvhnyhAXSukw/qCGOVhwKR8B6aeDtoBWQgjnvMtPgOUPRTPkPGbwPwwDkvAHYiuKJ7Bd2wH7rAgMBAAGjgZkwgZYwCQYDVR0TBAIwADAdBgNVHQ4EFgQUJNoRIpb1hUHAk0foMSNM9MCEAv8wSAYDVR0jBEEwP4AUo562SGdCEjZBvW3gubSgUouX8bOhHKQaMBgxFjAUBgNVBAMMDUpldFByb2ZpbGUgQ0GCCQDSbLGDsoN54TATBgNVHSUEDDAKBggrBgEFBQcDATALBgNVHQ8EBAMCBaAwDQYJKoZIhvcNAQELBQADggIBAB2J1ysRudbkqmkUFK8xqhiZaYPd30TlmCmSAaGJ0eBpvkVeqA2jGYhAQRqFiAlFC63JKvWvRZO1iRuWCEfUMkdqQ9VQPXziE/BlsOIgrL6RlJfuFcEZ8TK3syIfIGQZNCxYhLLUuet2HE6LJYPQ5c0jH4kDooRpcVZ4rBxNwddpctUO2te9UU5/FjhioZQsPvd92qOTsV+8Cyl2fvNhNKD1Uu9ff5AkVIQn4JU23ozdB/R5oUlebwaTE6WZNBs+TA/qPj+5/wi9NH71WRB0hqUoLI2AKKyiPw++FtN4Su1vsdDlrAzDj9ILjpjJKA1ImuVcG329/WTYIKysZ1CWK3zATg9BeCUPAV1pQy8ToXOq+RSYen6winZ2OO93eyHv2Iw5kbn1dqfBw1BuTE29V2FJKicJSu8iEOpfoafwJISXmz1wnnWL3V/0NxTulfWsXugOoLfv0ZIBP1xH9kmf22jjQ2JiHhQZP7ZDsreRrOeIQ/c4yR8IQvMLfC0WKQqrHu5ZzXTH4NO3CwGWSlTY74kE91zXB5mwWAx1jig+UXYc2w4RkVhy0//lOmVya/PEepuuTTI4+UJwC7qbVlh5zfhj8oTNUXgN0AOc+Q0/WFPl1aw5VV/VrO8FCoB15lFVlpKaQ1Yh+DVU8ke+rt9Th0BCHXe0uZOEmH0nOnH/0onD"
    }
  ]
}
```
+ IP查询
```url
 例：
    methods: GET
    请求地址: url/api/IPPosition
    http://127.0.0.1:5678/api/IPPosition/?format=json&ipaddress=66.249.64.247&lang=zh-CN
```
参数:
|  format                          |  ~~formats~~                  |  ipaddress |  lang |  fields |
| -------------------------------------- | ------------------------------- | ---------------- | ----------- | ------------- |
| String                                 | ~~String~~                          | String           | String      | String        |
| `json` ~~jsonp xml csv yaml~~| ~~json~~ ~~xml csv newline php~~ | IPV4/IPV6 | `en` `de` `es` `pt-BR` `ja` `fr` `zh-CN` `ru` | Null |

响应:
```json
{
  "code": "200",
  "message": "成功003",
  "data": [
    {
      "query": "66.249.64.247",
      "status": "success",
      "continent": "北美洲",
      "continentCode": "NA",
      "country": "美国",
      "countryCode": "US",
      "region": "CA",
      "regionName": "加州",
      "city": "芒廷维尤",
      "district": "",
      "zip": "94043",
      "lat": 37.422,
      "lon": -122.084,
      "timezone": "America/Los_Angeles",
      "offset": -25200,
      "currency": "USD",
      "isp": "Google LLC",
      "org": "Google LLC",
      "as": "AS15169 Google LLC",
      "asname": "GOOGLE",
      "reverse": "crawl-66-249-64-247.googlebot.com",
      "mobile": false,
      "proxy": false,
      "hosting": true
    },
    {
      "ip": "66.249.64.247",
      "type": "ipv4",
      "continent_code": "NA",
      "continent_name": "North America",
      "country_code": "US",
      "country_name": "United States",
      "region_code": "CA",
      "region_name": "California",
      "city": "Hemet",
      "zip": "92543",
      "latitude": 33.70851135253906,
      "longitude": -116.98120880126953,
      "location": {
        "geoname_id": 5356277,
        "capital": "Washington D.C.",
        "languages": [
          {
            "code": "en",
            "name": "English",
            "native": null
          }
        ],
        "country_flag": "https://assets.ipstack.com/flags/us.svg",
        "country_flag_emoji": "🇺🇸",
        "country_flag_emoji_unicode": "U+1F1FA U+1F1F8",
        "calling_code": "1",
        "is_eu": false
      }
    },
    {
      "ip": "66.249.64.247",
      "version": "IPv4",
      "city": "Ashburn",
      "region": "Virginia",
      "region_code": "VA",
      "country": "US",
      "country_name": "United States",
      "country_code": "US",
      "country_code_iso3": "USA",
      "country_capital": "Washington",
      "country_tld": ".us",
      "continent_code": "NA",
      "in_eu": false,
      "postal": "20149",
      "latitude": 39.0481,
      "longitude": -77.4728,
      "timezone": "America/New_York",
      "utc_offset": "-0400",
      "country_calling_code": "+1",
      "currency": "USD",
      "currency_name": "Dollar",
      "languages": "en-US,es-US,haw,fr",
      "country_area": 9629091,
      "country_population": 327167434,
      "asn": "AS15169",
      "org": "GOOGLE"
    }
  ]
}
```

+ DNS查询
```url
 例：
    methods: GET
    参数:None
    请求地址: url/api/edns
```
响应:
```json
{
  "code": "200",
  "message": "成功003",
  "data": {
    "dns": {
      "geo": "China - China Mobile communications corporation",
      "ip": "111.23.238.138"
    }
  }
}
```


+ IP批量查询
**TODO: IP批量查询**

> 目前大多数未实现  
by [林祈](https://dnslin.com)
