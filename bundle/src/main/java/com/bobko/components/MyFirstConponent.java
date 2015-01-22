package com.bobko.components;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Deactivate;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component(immediate = true, description = "This is second test component created by Me. Ho-ho-ho...",
label = "Second test component label", name = "second component name", metatype = true, enabled = true)
public class MyFirstConponent {

    private static final Logger LOG = LoggerFactory.getLogger(MyFirstConponent.class);
    
    @Activate
    public void activate(BundleContext bundleContext) {
        LOG.info("MyFirstComponent.activate()");
    }
    
    @Deactivate
    public void deactivate() {
        LOG.info("MyFirstComponent.deactivate()");
    }
    
}
