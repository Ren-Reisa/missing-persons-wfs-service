package org.example.final2.service;

import java.util.Map;

public interface IWfsService {
    void setServerUrl(String serverUrl);
    String handleRequest(Map<String, String> parameters);
}