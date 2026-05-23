package org.example.final2.entities.capabilities;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class Get {
    @XStreamAlias("xlink:href")
    @XStreamAsAttribute
    private String href;

    public String getHref() { return href; }
    public void setHref(String href) { this.href = href; }
}