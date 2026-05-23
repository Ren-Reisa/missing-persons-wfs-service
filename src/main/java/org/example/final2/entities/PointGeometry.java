package org.example.final2.entities;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class PointGeometry {
    @XStreamAsAttribute
    private String srsName;
    @XStreamAsAttribute
    private String srsDimension;
    @XStreamAlias("gml:pos")
    private String pos;

    public PointGeometry() {}
    public PointGeometry(double lon, double lat) {
        this.pos = lat + " " + lon;
    }
    // getters and setters
    public String getSrsName() { return srsName; }
    public void setSrsName(String srsName) { this.srsName = srsName; }
    public String getSrsDimension() { return srsDimension; }
    public void setSrsDimension(String srsDimension) { this.srsDimension = srsDimension; }
    public String getPos() { return pos; }
    public void setPos(String pos) { this.pos = pos; }
}