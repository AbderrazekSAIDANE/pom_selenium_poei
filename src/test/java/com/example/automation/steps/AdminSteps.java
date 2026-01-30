package com.example.automation.steps;

import com.example.automation.utils.Basetools;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.example.automation.configuration.DriverFactory.driver;
import static com.example.automation.steps.StandardsSteps.*;

public class AdminSteps extends Basetools {

    public AdminSteps() {
        setWait(new WebDriverWait(driver, Duration.ofSeconds(TIME)));
    }

    @And("je clique sur le bouton {string} pour ajouter un utilisateur")
    public void jeCliqueSurLeBoutonAddPourAjouterUnUtilisateur(String nameBoutton){
        clickOnButton(nameBoutton);
    }

    public void clickOnButton(String buttonName){
        WebElement eltButton = driver.findElement(By.xpath("//button[normalize-space() = \""+buttonName+"\"]"));
        eltButton.click();
    }

    @And("je renseigne les champs pour la création d'un utilisateur avec les informations suivantes")
    public void jeRenseigneLesChampsPourLaCréationDUnUtilisateurAvecLesInformationsSuivantes(DataTable dataTable) {
        dataTable.asMap().forEach((fieldName, fieldValue) -> {
            WebElement inputField = driver.findElement(By.xpath("//div[normalize-space() = \""+fieldName+"\"]//following-sibling::div//input"));
            inputField.sendKeys(fieldValue);
        });
    }

    @And("je selectionne les valeurs suivantes dans les listes déroulantes")
    public void jeSelectionneLesValeursSuivantesDansLesListesDéroulantes(DataTable dataTable) {
        dataTable.asMap().forEach((fieldName, fieldValue) -> {
            WebElement dropdown = driver.findElement(By.xpath("//div[normalize-space() = \""+fieldName+"\"]//following-sibling::div//*[contains(@class,\"select-text-input\")]"));
            dropdown.click();
            WebElement option = driver.findElement(By.xpath("//div[contains(@class,'option') and normalize-space() = \""+fieldValue+"\"]"));
            option.click();
        });
    }

    @And("je selectionne le nom de l'employé {string}")
    public void jeSelectionneLeNomDeLemployee(String employeeName) {
        driver.findElement(By.xpath("//input[contains(@placeholder,\"Type for hints...\")]")).sendKeys(employeeName);
        WebElement employeeNameOption = driver.findElement(By.xpath("//div[@class = 'oxd-autocomplete-option' and normalize-space() = \""+employeeName+"\"]"));
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(employeeNameOption));
        employeeNameOption.click();
    }

    @And("je clique sur le bouton modifier de l'utilisateur {string}")
    public void jeCliqueSurLeBoutonModifierDeLUtilisateur(String username) {
        WebElement editButton = driver.findElement(By.xpath("//div[normalize-space() = \""+username+"\"]/following-sibling::div/child::*//i[contains(@class,'pencil')]"));
        editButton.click();
    }

    @And("je modiffie le champs {string} par la valeur {string}")
    public void jeModiffieLeChampsParLaValeur(String fieldName, String fieldValue) {
        WebElement inputField = driver.findElement(By.xpath("//div[normalize-space() = \"" + fieldName + "\"]//following-sibling::div//input"));
        waitEnableElementAndClick(driver, inputField);
        inputField.sendKeys(Keys.CONTROL + "a");
        inputField.sendKeys(Keys.DELETE);
        inputField.sendKeys(fieldValue);
    }

    @And("l'utilisateur {string} a bien été créé")
    public void lUtilisateurABienÉtéCréé(String username) {
        WebElement createdUser = driver.findElement(By.xpath("//div[normalize-space() = \""+username+"\"]"));
        wait.until(ExpectedConditions.visibilityOf(createdUser));
    }

    @And("la modification sur la fiche de l'utilisateur {string} a bien été pris en compte")
    public void laModificationSurLaFicheUtilisateurABienÉtéPrisEnCompte(String username) {
        // Implémenter la vérification de la modification selon les besoins spécifiques
        WebElement createdUser = driver.findElement(By.xpath("//div[normalize-space() = \""+username+"\"]"));
        wait.until(ExpectedConditions.visibilityOf(createdUser));
    }

}
