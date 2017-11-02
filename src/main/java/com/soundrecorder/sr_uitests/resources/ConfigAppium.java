package com.soundrecorder.sr_uitests.resources;

import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;


public class ConfigAppium {

    private DesiredCapabilities cap = new DesiredCapabilities();

    public ConfigAppium(String device, String tipoDevice, String appName) {
        setUpCap(device, appName);
    }

    private DesiredCapabilities setUpCap(String device_ID, String appName) {

        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, device_ID);
        cap.setCapability(MobileCapabilityType.APP, appName);
        cap.setCapability(MobileCapabilityType.NO_RESET, true);
        cap.setCapability(MobileCapabilityType.FULL_RESET, false);
        return cap;
    }

    public DesiredCapabilities getCap() {
        return this.cap;
    }
}
