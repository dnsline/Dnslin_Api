package com.dnslin.dnslin_api.entity;

import org.springframework.stereotype.Service;

import java.io.Serializable;

public class IcpParameter implements Serializable {

    private String pageNum;
    private String pageSize;
    private String unitName;

    public String getPageNum() {
        return pageNum;
    }

    public void setPageNum(String pageNum) {
        this.pageNum = pageNum;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public IcpParameter(String pageNum, String pageSize, String unitName) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.unitName = unitName;
    }

    public IcpParameter() {
    }

    @Override
    public String toString() {
        return "IcpParameter{" +
                "pageNum='" + pageNum + '\'' +
                ", pageSize='" + pageSize + '\'' +
                ", unitName='" + unitName + '\'' +
                '}';
    }
}
