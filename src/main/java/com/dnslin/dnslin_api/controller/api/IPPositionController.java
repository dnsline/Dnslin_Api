package com.dnslin.dnslin_api.controller.api;

import com.dnslin.dnslin_api.result.R;
import com.dnslin.dnslin_api.result.ResponseEnum;
import com.dnslin.dnslin_api.service.IpPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class IPPositionController {
    @Autowired
    private IpPositionService ipPositionService;

    @GetMapping("/IPPosition/")
    public R getIPPosition(String format, String ipaddress, String lang, String fields) {
        if (format.isEmpty() && format == null && ipaddress.isEmpty() && ipaddress == null && lang.isEmpty() && lang == null) {
            return new R(ResponseEnum.PARAMETERS_ARE_MISSING, null);
        }
        if (fields == null || fields.isEmpty()) {
            fields = "";
        }
        List<Object> objects = ipPositionService.dataIntegration(format, ipaddress, lang, fields);
        return new R(ResponseEnum.SUCCESS, objects);
    }
}
