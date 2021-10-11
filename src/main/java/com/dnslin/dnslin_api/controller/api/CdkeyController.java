package com.dnslin.dnslin_api.controller.api;

import cn.hutool.core.lang.Console;
import com.dnslin.dnslin_api.entity.Cdkey;
import com.dnslin.dnslin_api.result.R;
import com.dnslin.dnslin_api.result.ResponseEnum;
import com.dnslin.dnslin_api.service.ReadzipfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
@Controller
public class CdkeyController {

    @Autowired
    private ReadzipfileService readzipfileService;

    @GetMapping("/cdkey")
    public R cdkey() {
        List<Cdkey> itFromTheCache = readzipfileService.getItFromTheCache();
        if (itFromTheCache != null && itFromTheCache.size() != 0) {
            Console.log("从缓存拿取数据");
            return new R(ResponseEnum.SUCCESS, itFromTheCache);
        }
        String theFileFromTheURL = readzipfileService.getTheFileFromTheURL();
        List<Cdkey> cdkeys = readzipfileService.readTheFile(theFileFromTheURL);
        Console.log("从url拿取数据");
        return new R(ResponseEnum.SUCCESS, cdkeys);
    }
}
