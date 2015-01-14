package com.bobko.messages;

import java.util.Dictionary;
import java.util.Hashtable;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.osgi.framework.BundleContext;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate = true, label = "Log service", metatype = true)
@Service(EventPublisher.class)
public class EventPublisher {

    public static final Logger LOG = LoggerFactory
            .getLogger(EventPublisher.class);

    Thread publisher = null;

    @Reference
    private EventAdmin eventAdmin;
    private boolean running = true;

    @Activate
    public void init(BundleContext context) {

        publisher = new Thread(new Runnable() {

            @Override
            public void run() {
                while (running) {
                    Dictionary<String, String> properties = new Hashtable<String, String>();
                    properties.put("title", "Current time publisher");
                    properties.put("time",
                            String.valueOf(System.currentTimeMillis()));
                    Event reportGeneratedEvent = new Event(
                            "com/publisher/currenttime/GENERATED", properties);
                    eventAdmin.postEvent(reportGeneratedEvent);

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        LOG.error("Interruption has occured", e);
                    }

                }
                LOG.info("Publisher has deactivated");
            }
        });

        publisher.start();

        LOG.info("Publisher has activated");
    }

    @Deactivate
    public void destroy() {
        running = false;
    }

}
