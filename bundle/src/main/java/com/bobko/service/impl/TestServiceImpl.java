package com.bobko.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.osgi.service.metatype.MetaTypeService;
import org.osgi.service.prefs.PreferencesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bobko.service.TestService;

//@Service = 
//<service servicefactory="false">
//      <provide interface="com.bobko.service.TestService"/>
//</service>

//@Component(immediate = true)
//@Service(TestService.class)
//<?xml version="1.0" encoding="UTF-8"?>
//<components xmlns:scr="http://www.osgi.org/xmlns/scr/v1.1.0">
//<scr:component immediate="true" name="com.bobko.service.impl.TestServiceImpl" activate="activate" deactivate="destroy">
//    <implementation class="com.bobko.service.impl.TestServiceImpl"/>
//    <service servicefactory="false">
//        <provide interface="com.bobko.service.TestService"/>
//    </service>
//    <property name="service.pid" value="com.bobko.service.impl.TestServiceImpl"/>
//</scr:component>
//</components>


@Component(immediate = true, 
           description="This is test component created by Me. Ho-ho-ho...", 
           label="Test component label",
           name="component name",
           metatype=true,
           enabled=true)
@Service({TestService.class, EventHandler.class})
@Properties(
        { 
            @Property(name = EventConstants.EVENT_TOPIC, value = "org/osgi/framework/BundleEvent/*"),
            @Property(name="type", value="my-implementation")
        })
public class TestServiceImpl implements TestService, EventHandler {
    
    private static final Logger LOG = LoggerFactory.getLogger(TestServiceImpl.class);
    
    private List<String> publisherEvents = new ArrayList<String>();
    private List<String> bundlesEvents = new ArrayList<String>();
    
    @Reference
    private PreferencesService service;
    
    @Reference
    private ConfigurationAdmin configurationAdmin;
    
    @Reference
    private MetaTypeService methService;
    
    @Activate
    public void activate() {
        LOG.info("activete called");
    }
    
    @Deactivate
    public void destroy() {
        LOG.info("Test service has stoped and destroyed");
    }
    
    public String getBundlesEvents() {
        return Arrays.toString(bundlesEvents.toArray());
        
    }

    public void addBundlesEvent(String bundlesEvent) {
        bundlesEvents.add(bundlesEvent);
        
    }

    public String getPublisherEvents() {
        return Arrays.toString(publisherEvents.toArray());
        
    }

    public void addPublisherEvent(String message) {
        publisherEvents.add(message);
        
    }

    @Override
    public void handleEvent(Event event) {
        
        String reportTitle = (String) event.getProperty("bundle.symbolicName");
        String reportPath = event.getTopic();

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(reportPath);
        stringBuilder.append(" - ");
        stringBuilder.append(reportTitle);
        stringBuilder.append("\n");

        bundlesEvents.add(stringBuilder.toString());

        
        LOG.info(event.getTopic());
        
    }

}
