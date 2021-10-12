package com.dnslin.dnslin_api.DTO;

import lombok.*;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
@ToString
public class IcpInfoDTO {
    private String unitName;
    private String limitAccess;
    private String natureName;
    private String serviceName;
    private String updateRecordTime;
    private String domainId;
    private String homeUrl;
    private String serviceLicence;
    private String leaderName;
    private String domain;
    private String mainLicence;
    private String mainId;
    private String serviceId;
    private String contentTypeName;
}
