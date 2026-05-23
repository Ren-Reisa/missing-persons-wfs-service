package org.example.final2.entities.describefeaturetype;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("xsd:schema")
public class FeatureTypeSchema {
    @XStreamAlias("xsd:complexType")
    private ComplexType complexType;
    @XStreamAlias("xsd:element")
    private Element element;
    @XStreamAsAttribute @XStreamAlias("xmlns:xsd")
    private final String xmlnsXsds = "http://www.w3.org/2001/XMLSchema";
    @XStreamAsAttribute @XStreamAlias("xmlns:gml")
    private final String xmlnsGml = "http://www.opengis.net/gml/3.2";

    // getters and setters
    public ComplexType getComplexType() { return complexType; }
    public void setComplexType(ComplexType complexType) { this.complexType = complexType; }
    public Element getElement() { return element; }
    public void setElement(Element element) { this.element = element; }
}