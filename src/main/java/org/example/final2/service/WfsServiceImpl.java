package org.example.final2.service;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.example.final2.entities.Szry;
import org.example.final2.entities.capabilities.*;
import org.example.final2.entities.describefeaturetype.*;
import org.example.final2.entities.getfeature.FeatureCollection;
import org.example.final2.entities.getfeature.FeatureMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class WfsServiceImpl implements IWfsService {

    private final XStream xStream;
    private String serverUrl = "http://localhost:8080/wfs";

    @Autowired
    private ISzryService szryService;

    public WfsServiceImpl() {
        this.xStream = new XStream(new DomDriver());
        xStream.autodetectAnnotations(true);
        xStream.setMode(XStream.NO_REFERENCES);
        xStream.allowTypesByWildcard(new String[]{"org.example.final2.**"});
    }

    @Override
    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    @Override
    public String handleRequest(Map<String, String> parameters) {
        String request = parameters.getOrDefault("REQUEST", "").toUpperCase();
        switch (request) {
            case "GETCAPABILITIES":
                return xStream.toXML(handleCapabilitiesRequest());
            case "DESCRIBEFEATURETYPE":
                return xStream.toXML(handleDescribeFeatureTypeRequest());
            case "GETFEATURE":
                return xStream.toXML(handleGetFeatureRequest());
            default:
                return "<ERROR>该接口不支持当前请求的操作: " + request + "</ERROR>";
        }
    }

    private CapabilitiesResponse handleCapabilitiesRequest() {
        CapabilitiesResponse capRes = new CapabilitiesResponse();
        ServicePart servicePart = new ServicePart("WFS", "Web Feature Service",
                "Web Feature Service of iLocation", "wfs", "WFS", "2.0.0");
        capRes.setService(servicePart);

        Operation reqOfGetCap = new Operation("GetCapabilities");
        reqOfGetCap.getDcp().getHttp().getGet().setHref(serverUrl + "?REQUEST=GetCapabilities");
        Operation reqOfDescFeatureType = new Operation("DescribeFeatureType");
        reqOfDescFeatureType.getDcp().getHttp().getGet().setHref(serverUrl + "?REQUEST=DescribeFeatureType");
        Operation reqOfGetFeature = new Operation("GetFeature");
        reqOfGetFeature.getDcp().getHttp().getGet().setHref(serverUrl + "?REQUEST=GetFeature");

        OperationsMetadata capPart = new OperationsMetadata();
        capPart.addRequest(reqOfGetCap);
        capPart.addRequest(reqOfDescFeatureType);
        capPart.addRequest(reqOfGetFeature);
        capRes.setCapability(capPart);

        WGS84BoundingBox bbox = new WGS84BoundingBox(100.0f, 19.0f, 131.0f, 50.0f);
        FeatureType featType = new FeatureType("szry", "失联人员数据", "EPSG:4326", bbox);
        FeatureTypeList ftList = new FeatureTypeList();
        ftList.addFeatTypeObject(featType);
        capRes.setFeatureTypeList(ftList);
        return capRes;
    }

    private FeatureTypeSchema handleDescribeFeatureTypeRequest() {
        ComplexType complexType = new ComplexType();
        complexType.setName("szryType");
        complexType.addElement(new Element("geom", "gml:PointPropertyType"));
        complexType.addElement(new Element("objectid", "xsd:int"));
        complexType.addElement(new Element("szry_name", "xsd:string"));
        complexType.addElement(new Element("szsj_location_text", "xsd:string"));
        complexType.addElement(new Element("szsj_time", "xsd:dateTime"));
        complexType.addElement(new Element("szsj_miss_timeStamp", "xsd:int"));
        complexType.addElement(new Element("szsj_miss_age", "xsd:int"));
        complexType.addElement(new Element("szsj_source_type", "xsd:string"));
        complexType.addElement(new Element("szsj_police_tel", "xsd:string"));
        complexType.addElement(new Element("szry_gender", "xsd:string"));
        complexType.addElement(new Element("szsj_missingreason", "xsd:string"));
        complexType.addElement(new Element("szsj_miss_region", "xsd:string"));
        complexType.addElement(new Element("szry_id", "xsd:string"));
        complexType.addElement(new Element("szsj_police_name", "xsd:string"));
        complexType.addElement(new Element("szsj_isfound", "xsd:string"));

        FeatureTypeSchema schema = new FeatureTypeSchema();
        schema.setElement(new Element("szry", "szryType"));
        schema.setComplexType(complexType);
        return schema;
    }

    private FeatureCollection handleGetFeatureRequest() {
        FeatureCollection fc = new FeatureCollection();
        List<Szry> results = szryService.selectAll();
        for (Szry each : results) {
            each.initGeom();
            FeatureMember member = new FeatureMember();
            member.setSzry(each);
            fc.addFeatureMember(member);
        }
        return fc;
    }
}