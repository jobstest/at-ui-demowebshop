package com.tricentis.demowebshop.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/selenoid.properties")
public interface SelenoidConfig extends Config {

    String loginSelenoid();
    String passwordSelenoid();
    String uniformResourceNameSelenoid();
}
