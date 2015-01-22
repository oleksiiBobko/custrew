package com.bobko.service;

public interface EchoServise {
    
    public static final String REPEAT_PARAMETER = "repeat";
    public static final String FACTORY_DS = "echo.factory";
    public static final String NAME_DS = "echo";

    public String echo(String message);

}
