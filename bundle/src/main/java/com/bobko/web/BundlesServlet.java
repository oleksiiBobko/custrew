package com.bobko.web;

import java.io.IOException;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;

import com.bobko.service.TestService;

@SuppressWarnings("serial")
@Service
@SlingServlet(description = "asdasdServlet1", label = "asdfasdfServlet1")
public class BundlesServlet  extends SlingAllMethodsServlet {

    @Reference
    private TestService eventLog;
    
    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) {
        try {
            response.getOutputStream().write(eventLog.getBundlesEvents().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
