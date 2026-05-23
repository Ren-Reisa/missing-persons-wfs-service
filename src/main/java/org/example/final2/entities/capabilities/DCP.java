package org.example.final2.entities.capabilities;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class DCP {
    @XStreamAlias("ows:HTTP")
    private HTTP http = new HTTP();

    public HTTP getHttp() { return http; }
    public void setHttp(HTTP http) { this.http = http; }
}