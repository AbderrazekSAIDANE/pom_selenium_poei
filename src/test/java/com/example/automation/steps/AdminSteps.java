package com.example.automation.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.example.automation.configuration.DriverFactory.driver;

public class AdminSteps {

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
    public void jeSelectionneLesValeursSuivantesDansLesListesDéroulantes(DataTable dataTable) throws InterruptedException {
        dataTable.asMap().forEach((fieldName, fieldValue) -> {
            // Cliquer sur la liste déroulante personnalisée pour l’ouvrir
            WebElement dropdown = driver.findElement(By.xpath("//div[normalize-space() = \""+fieldName+"\"]//following-sibling::div//*[contains(@class,\"select-text-input\")]"));
            dropdown.click();
            // Sélectionner l’option correspondant à la valeur
            WebElement option = driver.findElement(By.xpath("//div[normalize-space() = \""+fieldValue+"\"]"));
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



}
