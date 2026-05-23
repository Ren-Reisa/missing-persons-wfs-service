package org.example.final2.entities.capabilities;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.ArrayList;
import java.util.List;

@XStreamAlias("FeatureTypeList")
public class FeatureTypeList {
    @XStreamImplicit
    private List<FeatureType> featTypeList = new ArrayList<>();
    public void addFeatTypeObject(FeatureType featTypeObj) { this.featTypeList.add(featTypeObj); }
    public List<FeatureType> getFeatTypeList() { return featTypeList; }
    public void setFeatTypeList(List<FeatureType> featTypeList) { this.featTypeList = featTypeList; }
}