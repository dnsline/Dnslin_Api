package com.dnslin.dnslin_api.controller.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dnslin.dnslin_api.DTO.IcpInfoDTO;
import com.dnslin.dnslin_api.result.R;
import com.dnslin.dnslin_api.result.ResponseEnum;
import com.dnslin.dnslin_api.service.IcpforRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@RestController
@CrossOrigin
@RequestMapping("/api")
@Controller
public class IcpController {
    @Autowired
    private IcpforRecordService icpforRecordService;

    @GetMapping("/icp")
    public R obtainingDomainNameInformation(String domain) throws IOException, NoSuchAlgorithmException {
        String  list = null;
        IcpInfoDTO icpInfoDTO;
        String cookie = icpforRecordService.getCookie();
        if (cookie!=null){
            String token = icpforRecordService.requestToGetToken(cookie);
            if (token!=null){
                String data = icpforRecordService.initiateRequest(cookie, token, domain);
                JSONObject jsonObject = JSONObject.parseObject(data);
                list = jsonObject.getJSONObject("params").getString("list").replace("[","").replace("]","");
                icpInfoDTO = JSON.parseObject(list, IcpInfoDTO.class);
            }else{
                return new R(ResponseEnum.Cookie_not_found,null);
            }

        }else{
            return new R(ResponseEnum.Token_invalid,null);
        }
        return new R(ResponseEnum.SUCCESS,icpInfoDTO);
    }
}
