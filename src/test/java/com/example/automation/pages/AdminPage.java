package com.example.automation.pages;

import com.example.automation.utils.Basetools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminPage extends Basetools {
    WebDriver driver;

    public AdminPage() {
        setWait(new WebDriverWait(driver, Duration.ofSeconds(TIME)));
    }


}
