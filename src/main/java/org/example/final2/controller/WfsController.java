package org.example.final2.controller;

import org.example.final2.service.IWfsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

@RestController
@RequestMapping("/wfs")
public class WfsController {

    @Autowired
    private IWfsService wfsService;

    @GetMapping(produces = "text/xml;charset=UTF-8")
    public void handleRequest(@RequestParam Map<String, String> params,
                              HttpServletResponse response) throws Exception {
        response.setContentType("text/xml;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String result = wfsService.handleRequest(params);
        out.print(result);
        out.flush();
    }
}