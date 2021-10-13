package com.dnslin.dnslin_api.service;

import cn.hutool.core.lang.Console;
import com.alibaba.fastjson.JSON;

import com.dnslin.dnslin_api.entity.IPAPI;
import com.dnslin.dnslin_api.entity.IPAPIS;
import com.dnslin.dnslin_api.entity.Ipstack;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class IpPositionService {

    private final String Ipstackkey = "b6a76bd77214348a9a60ad29b51cac9a";

    /*
     *
     *功能描述
     * @author dnslin
     * @date http://api.ipstack.com/104.222.246.242?access_key={access_key}
     * @param  Ipstack
     * @return Json
     * @Key b6a76bd77214348a9a60ad29b51cac9a
     */
    public Ipstack getIpstack(String ipaddress) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet get = new HttpGet("http://api.ipstack.com/" + ipaddress + "?access_key=" + Ipstackkey);
        Ipstack ipstack = null;
        try {
            HttpEntity entity = httpClient.execute(get).getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity, "UTF-8");
                if (result != null) {
                    ipstack = JSON.parseObject(result, Ipstack.class);
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
        return ipstack;
    }

    /*
     *
     *功能描述
     * @author dnslin
     * @date https://ipapi.co/8.8.8.8/json/
     * @param  IPAPI
     * @return json , jsonp, xml, csv, yaml
     */

    public IPAPI getIPAPI(String ipaddress, String format, String fields) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet get = new HttpGet("https://ipapi.co/" + ipaddress + "/" + format + "/" + fields);
        IPAPI ipapi = null;
        try {
            HttpEntity entity = httpClient.execute(get).getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity, "UTF-8");
                if (result != null) {
                    ipapi = JSON.parseObject(result, IPAPI.class);
                }
            } else {
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ipapi;
    }

    /*
     *
     *功能描述
     * @author dnslin
     * @date http://ip-api.com/json/24.48.0.1
     * http://ip-api.com/json/24.48.0.1?fields=66846719&&lang=zh-CN
     * @param  ip-api
     * @return JSON XML CSV Newline PHP
     */
    public IPAPIS getIpapi(String formats, String ipaddress, String lang) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet get = new HttpGet("http://ip-api.com/" + formats + "/" + ipaddress + "?fields=66846719&&lang=" + lang);
        IPAPIS ipapis = null;
        try {
            HttpEntity entity = httpClient.execute(get).getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity, "UTF-8");
                if (result != null) {
                    ipapis = JSON.parseObject(result, IPAPIS.class);
                }
            } else {
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ipapis;
    }


    public List<Object> dataIntegration(String format,String formats, String ipaddress, String lang, String fields) {
        IpPositionService ipPositionService = new IpPositionService();
        Ipstack ipstack = ipPositionService.getIpstack(ipaddress);
        IPAPI ipapi = ipPositionService.getIPAPI(ipaddress, format, fields);
        IPAPIS ipapis = ipPositionService.getIpapi(formats, ipaddress, lang);
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(ipapis);
        objects.add(ipstack);
        objects.add(ipapi);
        return objects;
    }
}
