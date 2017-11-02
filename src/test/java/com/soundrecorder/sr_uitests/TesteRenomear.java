package com.soundrecorder.sr_uitests;

import com.soundrecorder.sr_uitests.action.RenameAction;
import com.soundrecorder.sr_uitests.resources.ConfigAppium;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import org.testng.Assert;

public class TesteRenomear {
    
    private AndroidDriver<MobileElement> driverAndroid;
    private ConfigAppium configAppium;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        String device_ID = "Nexus_5X_API_26_x86";
        String AppiumServerURL = "http://127.0.0.1:4723/wd/hub";

        String apkPath = "/home/lima/Documents/Projects/SR.apk"; //Mudar
        File ioApp = new File(apkPath);
        String appName = ioApp.getAbsolutePath();
        String deviceType = "Android";
        configAppium = new ConfigAppium(device_ID, deviceType, appName);
        this.driverAndroid = new AndroidDriver<MobileElement>(new URL(AppiumServerURL), configAppium.getCap());
    }

    @Test
    public void renameRecording() throws InterruptedException {
        RenameAction renameDriver = new RenameAction(driverAndroid);
        Random rand = new Random();
        String newName = "RandomNewName"+rand.nextInt(500);
        renameDriver.goToSavedRecordingsScreen();
        renameDriver.editName(newName);
        Assert.assertEquals(renameDriver.getFirstRecordingName().getText(), newName+".mp4");
    }
}
