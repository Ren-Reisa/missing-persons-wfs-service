package org.example.final2.entities;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

public class Szry {
    @XStreamAsAttribute @XStreamAlias("gml:id")
    private int id;
    @XStreamOmitField private double lon;
    @XStreamOmitField private double lat;
    private int objectid;
    private String szry_name;
    private String szsj_location_text;
    private String szsj_time;
    private int szsj_miss_timestamp;
    private int szsj_miss_age;
    private String szsj_source_type;
    private String szsj_police_tel;
    private String szry_gender;
    private String szsj_missingreason;
    private String szsj_miss_region;
    private String szry_id;
    private String szsj_police_name;
    private String szsj_isfound;
    @XStreamAlias("geom")
    private Geometry geometry;

    // getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public double getLon() { return lon; }
    public void setLon(double lon) { this.lon = lon; }
    public double getLat() { return lat; }
    public void setLat(double lat) { this.lat = lat; }
    public int getObjectid() { return objectid; }
    public void setObjectid(int objectid) { this.objectid = objectid; }
    public String getSzry_name() { return szry_name; }
    public void setSzry_name(String szry_name) { this.szry_name = szry_name; }
    public String getSzsj_location_text() { return szsj_location_text; }
    public void setSzsj_location_text(String szsj_location_text) { this.szsj_location_text = szsj_location_text; }
    public String getSzsj_time() { return szsj_time; }
    public void setSzsj_time(String szsj_time) { this.szsj_time = szsj_time; }
    public int getSzsj_miss_timestamp() { return szsj_miss_timestamp; }
    public void setSzsj_miss_timestamp(int szsj_miss_timestamp) { this.szsj_miss_timestamp = szsj_miss_timestamp; }
    public int getSzsj_miss_age() { return szsj_miss_age; }
    public void setSzsj_miss_age(int szsj_miss_age) { this.szsj_miss_age = szsj_miss_age; }
    public String getSzsj_source_type() { return szsj_source_type; }
    public void setSzsj_source_type(String szsj_source_type) { this.szsj_source_type = szsj_source_type; }
    public String getSzsj_police_tel() { return szsj_police_tel; }
    public void setSzsj_police_tel(String szsj_police_tel) { this.szsj_police_tel = szsj_police_tel; }
    public String getSzry_gender() { return szry_gender; }
    public void setSzry_gender(String szry_gender) { this.szry_gender = szry_gender; }
    public String getSzsj_missingreason() { return szsj_missingreason; }
    public void setSzsj_missingreason(String szsj_missingreason) { this.szsj_missingreason = szsj_missingreason; }
    public String getSzsj_miss_region() { return szsj_miss_region; }
    public void setSzsj_miss_region(String szsj_miss_region) { this.szsj_miss_region = szsj_miss_region; }
    public String getSzry_id() { return szry_id; }
    public void setSzry_id(String szry_id) { this.szry_id = szry_id; }
    public String getSzsj_police_name() { return szsj_police_name; }
    public void setSzsj_police_name(String szsj_police_name) { this.szsj_police_name = szsj_police_name; }
    public String getSzsj_isfound() { return szsj_isfound; }
    public void setSzsj_isfound(String szsj_isfound) { this.szsj_isfound = szsj_isfound; }
    public Geometry getGeometry() { return geometry; }
    public void setGeometry(Geometry geometry) { this.geometry = geometry; }

    public void initGeom() {
        PointGeometry pntGeom = new PointGeometry(this.getLon(), this.getLat());
        pntGeom.setSrsName("urn:ogc:def:crs:EPSG:4326");
        Geometry geom = new Geometry();
        geom.setGeom(pntGeom);
        this.setGeometry(geom);
    }
}