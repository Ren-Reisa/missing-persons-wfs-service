package org.example.final2.entities;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class Geometry {
    @XStreamAlias("gml:Point")
    private PointGeometry geom;

    public PointGeometry getGeom() { return geom; }
    public void setGeom(PointGeometry geom) { this.geom = geom; }
}