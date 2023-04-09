package com.tricentis.demowebshop.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/${localOrRemote}.properties")
public interface RemoteOrLocalConfig extends Config {
    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();
    @Key("baseUrl")
    @DefaultValue("https://demowebshop.tricentis.com/")
    String baseUrl();
    @Key("browser")
    @DefaultValue("CHROME")
    String browser();
    @Key("browserVersion")
    @DefaultValue("100")
    String browserVersion();
    @Key("remote")
    String remote();
}
