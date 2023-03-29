package com.tricentis.demowebshop.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/auth.properties")
public interface AuthConfig extends Config {

    String correctEmail();
    String correctPassword();
}
