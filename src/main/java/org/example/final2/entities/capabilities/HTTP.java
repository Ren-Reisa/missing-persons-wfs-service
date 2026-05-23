package org.example.final2.entities.capabilities;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class HTTP {
    @XStreamAlias("ows:Get")
    private Get get = new Get();

    public Get getGet() { return get; }
    public void setGet(Get get) { this.get = get; }
}