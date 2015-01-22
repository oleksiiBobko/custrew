package com.bobko.messages;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.osgi.framework.BundleContext;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bobko.service.TestService;

@Component(immediate=true, label = "Log service", metatype = true)
@Service
@Properties({
    @Property(name = EventConstants.EVENT_TOPIC, value = "com/publisher/currenttime/GENERATED")
})
public class PublisherEventsHandler  implements EventHandler {

    
    private static final Logger LOG = LoggerFactory.getLogger(PublisherEventsHandler.class);
    
    @Reference(target="(type=my-implementation)")
    private TestService testService;    
    
    @Activate
    private void activate(BundleContext bundleContext) {
        LOG.info("handler activated");
    }
    
    @Override
    public void handleEvent(Event event) {
        
        String reportTitle = (String) event.getProperty("title");
        String reportPath = (String) event.getProperty("time");
        
        StringBuilder stringBuilder = new StringBuilder(); 
        
        stringBuilder.append(reportPath);
        stringBuilder.append(" - ");
        stringBuilder.append(reportTitle);
        stringBuilder.append("\n");
        
        testService.addPublisherEvent(stringBuilder.toString());
        
        LOG.info("message received " + reportTitle + " " + reportPath);
        
    }

    
}
