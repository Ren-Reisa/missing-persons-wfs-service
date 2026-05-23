package org.example.final2.entities.capabilities;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("FeatureType")
public class FeatureType {
    @XStreamAsAttribute
    @XStreamAlias("xmlns:ilocation")
    private final String ilocation = "studio.ilocation";

    @XStreamAlias("Name")
    private String name;
    @XStreamAlias("Title")
    private String title;
    @XStreamAlias("DefaultCRS")
    private String crs;
    @XStreamAlias("ows:WGS84BoundingBox")
    private WGS84BoundingBox bbox;

    public FeatureType() {}
    public FeatureType(String name, String title, String crs, WGS84BoundingBox bbox) {
        this.name = name; this.title = title; this.crs = crs; this.bbox = bbox;
    }
    // getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getCrs() { return crs; }
    public void setCrs(String crs) { this.crs = crs; }
    public WGS84BoundingBox getBbox() { return bbox; }
    public void setBbox(WGS84BoundingBox bbox) { this.bbox = bbox; }
}