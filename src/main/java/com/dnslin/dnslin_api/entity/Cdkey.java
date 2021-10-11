package com.dnslin.dnslin_api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cdkey implements Serializable {
    private Integer id;
    private String date;
    private String remark;
    private String key;
}
