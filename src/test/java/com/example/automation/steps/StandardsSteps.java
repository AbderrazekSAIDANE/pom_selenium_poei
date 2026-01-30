package com.example.automation.steps;

import com.example.automation.utils.Basetools;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.example.automation.configuration.DriverFactory.driver;

public class StandardsSteps extends Basetools {

    public StandardsSteps(WebDriver driver) {
        setWait(new WebDriverWait(driver, Duration.ofSeconds(TIME)));
    }

    @And("je clique sur le bouton {string}")
    public static void clickOnButton(String buttonName){
        WebElement eltButton = driver.findElement(By.xpath("//button[normalize-space() = \""+buttonName+"\"]"));
        waitEnableElementAndClick(driver, eltButton);
    }
}
