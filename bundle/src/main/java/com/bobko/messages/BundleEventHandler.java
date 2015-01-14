package com.bobko.messages;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;

import com.bobko.service.TestService;

/*
 * name - Uniquely identifies this component and is also used to retrieve optional configuration from the Configuration Admin Service (if available).
 * immediate - Defines whether the component is to be instantiated immediately (true) or on-demand (false).
 * implementation.class - The fully qualified name of the class implementing the component. 
 * This class must be public and have a public default constructor for it to be usable by the Service Component Runtime. This class is not required to be exported and may as well be private to the bundle. In fact, you will generally not export the component implementation class.
 * property - These elements define configuration properties to the component. These properties are available through the ComponentContext which is presented to the component in the activate method (see below).
 * <b>service</b> - If the component is to be registered as a service, the service names are listed in provide elements inside the service element. 
 * These names will generally be interfaces and must be visible to other bundles for the service to be usable. In this sample, the service is the Java java.util.Comparator class, which is always visible.
 * */

@Component(immediate = true, label = "Log service", metatype = true)
@Service
@Properties({ @Property(name = EventConstants.EVENT_TOPIC, value = "org/osgi/framework/BundleEvent/*") })
public class BundleEventHandler implements EventHandler {
    
    @Reference
    private TestService testService;
    
    @Override
    public void handleEvent(Event event) {
        String reportTitle = (String) event.getProperty("bundle.symbolicName");
        String reportPath = event.getTopic();

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(reportPath);
        stringBuilder.append(" - ");
        stringBuilder.append(reportTitle);
        stringBuilder.append("\n");

        testService.addBundlesEvent(stringBuilder.toString());

    }

}
