package org.example.final2.entities.capabilities;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("ows:Operation")
public class Operation {
    @XStreamAsAttribute
    private String name;

    @XStreamAlias("ows:DCP")
    private DCP dcp = new DCP();

    public Operation() {}
    public Operation(String name) { this.name = name; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public DCP getDcp() { return dcp; }
    public void setDcp(DCP dcp) { this.dcp = dcp; }
}