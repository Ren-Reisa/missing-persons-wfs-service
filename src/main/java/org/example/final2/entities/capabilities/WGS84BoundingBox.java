package org.example.final2.entities.capabilities;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

public class WGS84BoundingBox {
    @XStreamOmitField
    private float minx, miny, maxx, maxy;
    @XStreamAlias("ows:LowerCorner")
    private String lowerCorner;
    @XStreamAlias("ows:UpperCorner")
    private String upperCorner;

    public WGS84BoundingBox() {}
    public WGS84BoundingBox(float minx, float miny, float maxx, float maxy) {
        this.minx = minx; this.miny = miny; this.maxx = maxx; this.maxy = maxy;
        this.lowerCorner = minx + " " + miny;
        this.upperCorner = maxx + " " + maxy;
    }
    // getters and setters for lowerCorner, upperCorner
    public String getLowerCorner() { return lowerCorner; }
    public void setLowerCorner(String lowerCorner) { this.lowerCorner = lowerCorner; }
    public String getUpperCorner() { return upperCorner; }
    public void setUpperCorner(String upperCorner) { this.upperCorner = upperCorner; }
}