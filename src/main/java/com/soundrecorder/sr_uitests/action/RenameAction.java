package com.soundrecorder.sr_uitests.action;

import com.soundrecorder.sr_uitests.appobjects.RecordingsListObj;
import com.soundrecorder.sr_uitests.appobjects.FirstScreenObj;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.WebElement;

public class RenameAction {

    private final AppiumDriver<MobileElement> driver;
    private final FirstScreenObj firstScreenObj;
    private final RecordingsListObj recordingsListObj;
    private final TouchAction clickAndHold;

    public RenameAction(AppiumDriver<MobileElement> driver) {
        this.firstScreenObj = new FirstScreenObj(driver);
        this.recordingsListObj = new RecordingsListObj(driver);
        this.clickAndHold = new TouchAction(driver);
        this.driver = driver;
    }

    public void goToSavedRecordingsScreen() {
        firstScreenObj.savedRecordingsMenu.click();
    }
    
    public void editName(String newName) {
        clickAndHold.longPress(recordingsListObj.firstSavedRecording).perform();
        recordingsListObj.renameFileOption.click();
        recordingsListObj.newNameField.setValue(newName);
        recordingsListObj.okButton.click();
    }
    
    public WebElement getFirstRecordingName() {
        return recordingsListObj.firstSavedRecordingName;
    }
}
