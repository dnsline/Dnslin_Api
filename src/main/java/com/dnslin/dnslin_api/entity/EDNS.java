package com.dnslin.dnslin_api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class EDNS {
    private DnsDTO dns;
    @NoArgsConstructor
    @Data
    public static class DnsDTO {
        private String geo;
        private String ip;
    }
}
