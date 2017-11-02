package com.soundrecorder.sr_uitests.appobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class RecordingsListObj {

    public RecordingsListObj(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);
    }

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@index='1']")
    public MobileElement firstSavedRecording;
   
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@index='1']/android.widget.TextView[@index='0']")
    public MobileElement firstSavedRecordingName;
    
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Rename File']")
    public MobileElement renameFileOption;
    
    @AndroidFindBy(id="com.danielkim.soundrecorder:id/new_name")
    public MobileElement newNameField;
    
    @AndroidFindBy(id="android:id/button1")
    public MobileElement okButton;
}
