package com.dnslin.dnslin_api.controller.api;

import com.dnslin.dnslin_api.entity.AmapIP;
import com.dnslin.dnslin_api.result.R;
import com.dnslin.dnslin_api.result.ResponseEnum;
import com.dnslin.dnslin_api.service.AmapIpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class AmapIPController {
    @Autowired
    private AmapIpService amapIpService;
    @GetMapping("/amap")
    public R ToAutonaviLocation(String ipaddress){
        if (ipaddress==null || ipaddress.isEmpty()){
            return new R(ResponseEnum.PARAMETERS_ARE_MISSING,null);
        }
        AmapIP amapIP = amapIpService.makeASignature(ipaddress);
        if ("1".equals(amapIP.getStatus()) == false) {
            return new R(ResponseEnum.SUCCESS,amapIP.getInfo());
        }
        return new R(ResponseEnum.SUCCESS,amapIP);
    }
}
