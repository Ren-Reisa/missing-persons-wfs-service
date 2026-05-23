package org.example.final2.entities.describefeaturetype;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import java.util.ArrayList;
import java.util.List;

public class ComplexType {
    @XStreamAsAttribute
    private String name;
    @XStreamAlias("xsd:sequence")
    private List<Element> sequences = new ArrayList<>();

    public void addElement(Element element) { this.sequences.add(element); }
    // getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<Element> getSequences() { return sequences; }
    public void setSequences(List<Element> sequences) { this.sequences = sequences; }
}