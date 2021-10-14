package com.dnslin.dnslin_api.controller.api;

import com.dnslin.dnslin_api.result.R;
import com.dnslin.dnslin_api.result.ResponseEnum;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ApiRequestList {
    @GetMapping("/api")
    public R getRequestList(){
        String [] list = {"/api/cdkey","/api/edns","/api/icp","/api/IPPosition","/api/ipquerys","/api/amap","By:林祈 https://github.com/dnslin/Dnslin_Api"};
        return new R(ResponseEnum.SUCCESS,list);
    }
}
