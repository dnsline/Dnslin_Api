package com.dnslin.dnslin_api.controller.api;

import com.alibaba.fastjson.JSONArray;
import com.dnslin.dnslin_api.result.R;
import com.dnslin.dnslin_api.result.ResponseEnum;
import com.dnslin.dnslin_api.service.IpQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class IpQueryController {
    @Autowired
    private IpQueryService ipQueryService;

    @GetMapping("/ipquerys")
    public R requestBatchQuery(String ipaddress, String lang) {
        JSONArray objects = ipQueryService.postRequestInterface(ipaddress, lang);
        return new R(ResponseEnum.SUCCESS,objects);
    }
}
