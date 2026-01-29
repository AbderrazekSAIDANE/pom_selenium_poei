package com.example.automation.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.time.Duration;

import static com.example.automation.configuration.DriverFactory.driver;

public class Basetools {
    public static final Logger log = LoggerFactory.getLogger(Basetools.class);

    protected static final int TIME = 100;


    // public pour que la class watcher et json_watcher puisse y acceder
    public File screenshotFile;
    private WebDriverWait wait;


    public void setWait(WebDriverWait wait) {
        this.wait = wait;
    }

    public void waitAndClick(WebElement e) {

        log.trace("Attends max [" + TIME + "]s que l'element soit cliquable");
        wait.until(ExpectedConditions.elementToBeClickable(e)).click();
    }

    public void waitDisplayElement(WebElement e) {
        log.trace("Attends max [\" + TIME + \"]s que l'element soit visible");
        wait.until(ExpectedConditions.visibilityOf(e)).isDisplayed();
    }

    public static void waitEnableElementAndClick(WebDriver driver, WebElement e) {
        Wait<WebDriver> wait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(50))
                        .pollingEvery(Duration.ofMillis(1))
                        .ignoring(ElementNotInteractableException.class)
                        .ignoring(ElementClickInterceptedException.class);

        wait.until(ExpectedConditions.elementToBeClickable(e)).isEnabled();
        e.click();
    }
}
