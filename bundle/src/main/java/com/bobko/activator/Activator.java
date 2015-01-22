package com.bobko.activator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Activator implements BundleActivator {

    private static final Logger LOG = LoggerFactory.getLogger(Activator.class);
    
    @Override
    public void start(BundleContext bundleContext) throws Exception {
        ServiceReference[] references =
                bundleContext.getAllServiceReferences(null, null);
        LOG.info("Activator.start has called");

    }

    @Override
    public void stop(BundleContext context) throws Exception {
        LOG.info("Activator.stop has called");

    }

}
