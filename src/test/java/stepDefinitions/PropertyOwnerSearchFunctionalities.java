package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static stepDefinitions.TestSetup.driver;

public class PropertyOwnerSearchFunctionalities {

    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //%%% The @Given, @When & @And are the same for all 3 search scenarios %%%
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    @Given("I am Logged-In as a Property Owner")
    public void loggedInAsPropertyOwner() {
        WebElement propertyOwnerMainPage = driver.findElement(By.id("propertyOwnerMainPage"));
        String propertyOwnerMainPageStr = propertyOwnerMainPage.getText();
        Assert.assertEquals("Property Owner Main Page", propertyOwnerMainPageStr);
    }

    @When("The Search Button is Visible")
    public void searchButtonIsVisible() {
        WebElement searchButton = driver.findElement(By.id("searchButton"));
        Assert.assertTrue(searchButton.isDisplayed());
    }

    @And("I click on the Search Button")
    public void clickSearchButton() {
        WebElement searchButton = driver.findElement(By.id("searchButton"));
        searchButton.click();
    }


    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //%%% Scenario: Property Owner Performs Search by TIN %%%
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    @Then("I can Perform a Search by TIN number")
    public void performSearchByTinNumber() {
        WebElement searchByTinField = driver.findElement(By.id("searchByTinField"));
        searchByTinField.sendKeys("123456789");
        WebElement searchSubmitButton = driver.findElement(By.id("searchSubmitButton"));
        searchSubmitButton.click();
        WebElement searchResult = driver.findElement(By.id("searchResult"));
        Assert.assertTrue(searchResult.getText().contains("123456789"));
    }


    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //%%% Scenario: Property Owner Performs Search by Email %%%
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    @Then("I can Perform a Search by Email")
    public void performSearchByEmail() {
        WebElement searchByEmailField = driver.findElement(By.id("searchByEmailField"));
        searchByEmailField.sendKeys("example@example.com");
        WebElement searchSubmitButton = driver.findElement(By.id("searchSubmitButton"));
        searchSubmitButton.click();
        WebElement searchResult = driver.findElement(By.id("searchResult"));
        Assert.assertTrue(searchResult.getText().contains("example@example.com"));
    }


    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //%%% Scenario: Property Owner Performs Search by Name %%%
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    @Then("I can Perform a Search by Name")
    public void performSearchByName() {
        WebElement searchByNameField = driver.findElement(By.id("searchByNameField"));
        searchByNameField.sendKeys("John Doe");
        WebElement searchSubmitButton = driver.findElement(By.id("searchSubmitButton"));
        searchSubmitButton.click();
        WebElement searchResult = driver.findElement(By.id("searchResult"));
        Assert.assertTrue(searchResult.getText().contains("John Doe"));
    }
}
