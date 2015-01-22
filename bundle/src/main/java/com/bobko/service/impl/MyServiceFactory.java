package com.bobko.service.impl;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceRegistration;

@Component(immediate=true)
@Service(serviceFactory=true)
public class MyServiceFactory implements ServiceFactory {

    @Override
    public Object getService(Bundle bundle, ServiceRegistration registration) {
        return null;
    }

    @Override
    public void ungetService(Bundle bundle, ServiceRegistration registration,
            Object service) {

    }

}
