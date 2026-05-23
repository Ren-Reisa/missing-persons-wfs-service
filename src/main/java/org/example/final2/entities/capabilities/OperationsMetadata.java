package org.example.final2.entities.capabilities;

import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.ArrayList;
import java.util.List;

public class OperationsMetadata {
    @XStreamImplicit
    private List<Operation> request = new ArrayList<>();

    public void addRequest(Operation req) { this.request.add(req); }
    public List<Operation> getRequest() { return request; }
    public void setRequest(List<Operation> request) { this.request = request; }
}