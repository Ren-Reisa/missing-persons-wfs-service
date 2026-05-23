package org.example.final2.entities.capabilities;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class ServicePart {
    private String name;
    private String title;
    @XStreamAlias("abstract")
    private String abstractStr;
    private String keyword;
    @XStreamAlias("ServiceType")
    private String serviceType;
    @XStreamAlias("ServiceTypeVersion")
    private String serviceTypeVersion;

    // 无参构造器
    public ServicePart() {}

    // 全参构造器
    public ServicePart(String name, String title, String abstractStr, String keyword, String serviceType, String serviceTypeVersion) {
        this.name = name;
        this.title = title;
        this.abstractStr = abstractStr;
        this.keyword = keyword;
        this.serviceType = serviceType;
        this.serviceTypeVersion = serviceTypeVersion;
    }

    // getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAbstractStr() { return abstractStr; }
    public void setAbstractStr(String abstractStr) { this.abstractStr = abstractStr; }
    public String getKeyword() { return keyword; }
    public void setKeyword(String keyword) { this.keyword = keyword; }
    public String getServiceType() { return serviceType; }
    public void setServiceType(String serviceType) { this.serviceType = serviceType; }
    public String getServiceTypeVersion() { return serviceTypeVersion; }
    public void setServiceTypeVersion(String serviceTypeVersion) { this.serviceTypeVersion = serviceTypeVersion; }
}