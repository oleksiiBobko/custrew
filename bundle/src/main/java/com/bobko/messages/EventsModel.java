package com.bobko.messages;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = Resource.class)
public class EventsModel {
    
    private static final Logger LOG = LoggerFactory.getLogger(EventsModel.class);
    
    private String text = "asdf";
    
    public String getEvents() {
        return "";
    }
    
    public String getText() {
        return text;
    }
    
}
