package com.example.automation.steps;

import com.example.automation.configuration.Hooks;
import com.example.automation.pages.HomePage;
import com.example.automation.pages.LoginPage;
import com.example.automation.configuration.ConfigReader;
import com.example.automation.configuration.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static com.example.automation.configuration.DriverFactory.driver;


public class LoginSteps {

    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    public ConfigReader settings = new ConfigReader();

    @Given("l'utilisateur est sur la page de connexion")
    public void openLogin() {
        String url = settings.getProperty("url");
        loginPage.open(url);
    }

    @When("il saisit le login {string} et le mot de passe {string}")
    public void login(String user, String pass) {
        loginPage.login(user, pass);
    }

    @When("il renseigne les champs suivants il pourra se connecter")
    public void ilRenseigneLesChamps(DataTable dataTable){
        List<String> credentials = dataTable.asList();
    }

    @Then("il est redirigé vers la page d'accueil")
    public void checkHome() {
        Assert.assertTrue(homePage.isDisplayed());
    }
}
