package com.dnslin.dnslin_api.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
@ToString
public class IcpInfoDTO {
    @JsonProperty("contentTypeName")
    private String contentTypeName;
    @JsonProperty("domain")
    private String domain;
    @JsonProperty("domainId")
    private Long domainId;
    @JsonProperty("homeUrl")
    private String homeUrl;
    @JsonProperty("mainLicence")
    private String mainLicence;
    @JsonProperty("natureName")
    private String natureName;
    @JsonProperty("serviceLicence")
    private String serviceLicence;
    @JsonProperty("serviceName")
    private String serviceName;
    @JsonProperty("unitName")
    private String unitName;
    @JsonProperty("updateRecordTime")
    private String updateRecordTime;
}
