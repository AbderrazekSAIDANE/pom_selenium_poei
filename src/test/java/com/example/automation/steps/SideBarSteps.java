package com.example.automation.steps;

import com.example.automation.utils.Basetools;
import io.cucumber.java.fr.Et;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.example.automation.configuration.DriverFactory.driver;

public class SideBarSteps {

    @Et("je clique sur l'onglet {string}")
    public void jeCliqueSurLOnglet(String onglet) {
        WebElement ongletElt = driver.findElement(By.xpath("//span[normalize-space() = \""+onglet+"\"]"));
        ongletElt.click();
        //waitAndClick(ongletElt);
    }




}
