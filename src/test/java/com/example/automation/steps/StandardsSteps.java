package com.example.automation.steps;

import com.example.automation.utils.Basetools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StandardsSteps extends Basetools {

    public StandardsSteps(WebDriver driver) {
        setWait(new WebDriverWait(driver, Duration.ofSeconds(TIME)));
    }



}
