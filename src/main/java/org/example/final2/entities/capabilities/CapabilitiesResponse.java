package org.example.final2.entities.capabilities;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("WFS_Capabilities")
public class CapabilitiesResponse {
    @XStreamAlias("ows:ServiceIdentification")
    private ServicePart service;

    @XStreamAlias("ows:OperationsMetadata")
    private OperationsMetadata capability;

    @XStreamAlias("FeatureTypeList")
    private FeatureTypeList featureTypeList;

    @XStreamAsAttribute
    private final String version = "2.0.0";
    @XStreamAsAttribute
    private final String xmlns = "http://www.opengis.net/wfs/2.0";
    @XStreamAsAttribute @XStreamAlias("xmlns:ogc")
    private final String xmlnsOgc = "http://www.opengis.net/ogc";
    @XStreamAsAttribute @XStreamAlias("xmlns:xsi")
    private final String xmlnsXsi = "http://www.w3.org/2001/XMLSchema-instance";
    @XStreamAsAttribute @XStreamAlias("xmlns:xlink")
    private final String xlink = "http://www.w3.org/1999/xlink";
    @XStreamAsAttribute @XStreamAlias("xmlns:ows")
    private final String ows = "http://www.opengis.net/ows/1.1";

    // getters and setters
    public ServicePart getService() { return service; }
    public void setService(ServicePart service) { this.service = service; }
    public OperationsMetadata getCapability() { return capability; }
    public void setCapability(OperationsMetadata capability) { this.capability = capability; }
    public FeatureTypeList getFeatureTypeList() { return featureTypeList; }
    public void setFeatureTypeList(FeatureTypeList featureTypeList) { this.featureTypeList = featureTypeList; }
}