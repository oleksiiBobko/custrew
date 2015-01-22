package com.bobko.service.impl;

import java.util.concurrent.atomic.AtomicLong;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Service;

import com.bobko.service.SequenceService;

@Component
@Service
public class SequenceServiceImpl implements SequenceService {

    private AtomicLong sequence;

    @Override
    public long next() {
        return sequence.incrementAndGet();
    }

    @Activate
    protected void activate() {
        sequence = new AtomicLong();
    }

    @Deactivate
    protected void deactivate() {
        sequence = null;
    }
}