package com.dnslin.dnslin_api.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.dnslin.dnslin_api.exception.AppException;
import com.dnslin.dnslin_api.result.ResponseEnum;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
/*
 *
 *功能描述
 * @author dnslin
 * @date http://ip-api.com/batch?fields=66842623&&lang=zh-CN
 * @param
 * @return
 */
public class IpQueryService {

    public JSONArray postRequestInterface(String ipaddress, String lang) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String substring = ipaddress.substring(0, ipaddress.length());
        String[] split = substring.split(",");//以逗号分割
        HttpPost post = new HttpPost("http://ip-api.com/batch?fields=66842623&&lang="+lang);
        String jsonString2 = JSON.toJSONString(split);
        System.out.println(jsonString2);
        post.setEntity(new StringEntity(jsonString2, "UTF-8"));
        String result = null;
        try {
            HttpEntity entity = httpClient.execute(post).getEntity();
            result = EntityUtils.toString(entity);
        } catch (IOException e) {
            new AppException(ResponseEnum.SK_BUSY);
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                new AppException(ResponseEnum.SK_BUSY);
            }
        }
        JSONArray objects = JSON.parseArray(result);
        return objects;
    }
}
