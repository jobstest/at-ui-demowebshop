package com.tricentis.demowebshop.helpers;

import com.codeborne.selenide.Configuration;
import com.tricentis.demowebshop.config.RemoteOrLocal;
import com.tricentis.demowebshop.config.Selenoid;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverSetting {

    public static void configure(){
        Configuration.baseUrl = RemoteOrLocal.config.baseUrl();
        Configuration.browserSize = RemoteOrLocal.config.browserSize();
        Configuration.remote = RemoteOrLocal.config.remote();
        Configuration.browser = RemoteOrLocal.config.browser();
        Configuration.browserVersion = RemoteOrLocal.config.browserVersion();

        String loginSelenoid = Selenoid.config.loginSelenoid();
        String passwordSelenoid = Selenoid.config.passwordSelenoid();
        String uniformResourceNameSelenoid = Selenoid.config.uniformResourceNameSelenoid();
        Configuration.remote = "https://" + loginSelenoid + ":" + passwordSelenoid + "@" + uniformResourceNameSelenoid +"/wd/hub/";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }
}
