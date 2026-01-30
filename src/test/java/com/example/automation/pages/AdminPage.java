package com.example.automation.pages;

import com.example.automation.utils.Basetools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.example.automation.configuration.DriverFactory.driver;

public class AdminPage extends Basetools {
    WebDriver driver;

    public AdminPage() {
        setWait(new WebDriverWait(driver, Duration.ofSeconds(TIME)));
    }

    public void checkFoUser(String username) {
        WebElement createdUser = driver.findElement(By.xpath("//div[normalize-space() = \""+username+"\"]"));
        wait.until(ExpectedConditions.visibilityOf(createdUser));
    }

    public void clickOnEditUser(String username) {
        WebElement editButton = driver.findElement(By.xpath("//div[normalize-space() = \""+username+"\"]/following-sibling::div/child::*//i[contains(@class,'pencil')]"));
        waitAndClick(editButton);
    }


}
