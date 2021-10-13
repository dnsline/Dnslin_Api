package com.dnslin.dnslin_api.service;

import cn.hutool.core.lang.Console;
import com.alibaba.fastjson.JSON;
import com.dnslin.dnslin_api.entity.EDNS;
import com.dnslin.dnslin_api.entity.Ipstack;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EDNSService {
    /*
     *
     *功能描述
     * @author dnslin
     * @date http://edns.ip-api.com/json
     * @param  EDNS
     * @return Json
     * @Key b6a76bd77214348a9a60ad29b51cac9a
     */
    public EDNS getEDNS() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet get = new HttpGet("http://edns.ip-api.com/json");
        EDNS edns = null;
        try {
            HttpEntity entity = httpClient.execute(get).getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity, "UTF-8");
                if (result != null) {
                    edns = JSON.parseObject(result, EDNS.class);
                }
            } else {
                return null;
            }
        } catch (IOException e) {
            Console.log("io异常");
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                Console.log("io异常");
            }
        }
        return edns;
    }
}
