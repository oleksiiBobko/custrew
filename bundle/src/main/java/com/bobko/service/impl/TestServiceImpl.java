package com.bobko.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bobko.service.TestService;

@Component(immediate = true)
@Service(TestService.class)
public class TestServiceImpl implements TestService {
    
    private static final Logger LOG = LoggerFactory.getLogger(TestServiceImpl.class);
    
    private List<String> publisherEvents = new ArrayList<String>();
    private List<String> bundlesEvents = new ArrayList<String>();
    
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

}
