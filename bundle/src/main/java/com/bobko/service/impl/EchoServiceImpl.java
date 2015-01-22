package com.bobko.service.impl;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.osgi.service.component.ComponentContext;

import static com.bobko.service.EchoServise.FACTORY_DS;
import static com.bobko.service.EchoServise.NAME_DS;
import static org.apache.felix.scr.annotations.ReferenceCardinality.MANDATORY_UNARY;
import static org.apache.felix.scr.annotations.ReferencePolicy.DYNAMIC;

import com.bobko.service.EchoServise;
import com.bobko.service.SequenceService;

@Component(factory = FACTORY_DS, name = NAME_DS)
public class EchoServiceImpl implements EchoServise {

    @Reference(cardinality = MANDATORY_UNARY, policy = DYNAMIC)
    private SequenceService sequencer = null;
    private transient int repeat = 1;

    @Activate
    protected void activate(final ComponentContext componentContext) {
        repeat = Integer.parseInt(componentContext.getProperties().get(REPEAT_PARAMETER).toString());
    }

    @Override
    public String echo(final String message) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < repeat; i++) {
            addEchoElement(stringBuilder, message);
        }
        
        return stringBuilder.toString();
        
    }

    private void addEchoElement(final StringBuilder stringBuilder, final String message) {
        stringBuilder.append(sequencer.next()).append(' ').append(message).append("\n");
    }

    protected void unbindSequencer() {
        sequencer = null;
    }

    protected void bindSequencer(final SequenceService sequencer) {
        this.sequencer = sequencer;
    }
    
}
