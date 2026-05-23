package org.example.final2.entities.describefeaturetype;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("xsd:element")
public class Element {
    @XStreamAsAttribute
    private String name;
    @XStreamAsAttribute
    private String type;

    public Element() {}
    public Element(String name, String type) { this.name = name; this.type = type; }
    // getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}