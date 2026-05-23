package org.example.final2.entities.getfeature;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.ArrayList;
import java.util.List;

@XStreamAlias("gml:FeatureCollection")
public class FeatureCollection {
    @XStreamImplicit
    private List<FeatureMember> members = new ArrayList<>();

    public void addFeatureMember(FeatureMember featureMember) {
        this.members.add(featureMember);
    }

    @XStreamAsAttribute
    @XStreamAlias("xmlns:gml")
    private final String xmlnsGml = "http://www.opengis.net/gml/3.2";
}