package com.tricentis.demowebshop.config;

import org.aeonbits.owner.ConfigFactory;

public class RemoteOrLocal {
    public  static RemoteOrLocalConfig config = ConfigFactory.create(RemoteOrLocalConfig.class, System.getProperties());
}
