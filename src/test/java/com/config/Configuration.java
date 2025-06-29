package com.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:config.properties"})
public interface Configuration extends Config{

    String browser();
    boolean headless();
    int timeout();

    @Key("base.url")
    String baseUrl();

    @Key("page.load.timeout")
    int pageLoadTimeout();

    @Key("browser.size")
    String browserSize();
}
