package com.bobko.service.impl;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bobko.service.TestService;

@Component(immediate = true, description = "This is second test component created by Me. Ho-ho-ho...",
label = "Second test service label", name = "second service name", metatype = true, enabled = true)
@Service({ TestService.class })
public class SecondTestSrvImpl implements TestService {

    private static final Logger LOG = LoggerFactory.getLogger(TestServiceImpl.class);
    
    @Override
    public String getBundlesEvents() {
        
        LOG.info("SecondTestSrvImpl.getBundlesEvents()");
        return "";
    }

    @Override
    public void addBundlesEvent(String bundlesEvent) {
        LOG.info("SecondTestSrvImpl.addBundlesEvent()");
    }

    @Override
    public String getPublisherEvents() {
        LOG.info("SecondTestSrvImpl.getPublisherEvents()");
        return "";
    }

    @Override
    public void addPublisherEvent(String message) {
        LOG.info("SecondTestSrvImpl.addPublisherEvent()");
    }

}
