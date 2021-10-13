package com.dnslin.dnslin_api.controller.api;

import com.dnslin.dnslin_api.entity.EDNS;
import com.dnslin.dnslin_api.result.R;
import com.dnslin.dnslin_api.result.ResponseEnum;
import com.dnslin.dnslin_api.service.EDNSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class EDNSController {
    @Autowired
    private EDNSService ednsService;

    @GetMapping("/edns")
    public R get_edns() {
         EDNS edns = ednsService.getEDNS();
        return new R(ResponseEnum.SUCCESS,edns);
    }
}
