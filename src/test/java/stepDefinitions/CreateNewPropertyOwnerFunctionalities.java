package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static stepDefinitions.TestSetup.driver;

public class CreateNewPropertyOwnerFunctionalities {

    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //%%% Scenario: Validate New Property Owner's Form %%%
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    @Given("I am at the Create Property Owner Page")
    public void atCreatePropertyOwnerPage() {
        WebElement createPropertyOwnerPageTitle = driver.findElement(By.id("createPropertyOwnerPageTitle"));
        Assert.assertEquals("Create Property Owner", createPropertyOwnerPageTitle.getText());
    }

    @Then("The New Property Owner Form is displayed")
    public void newPropertyOwnerFormDisplayed() {
        WebElement propertyOwnerForm = driver.findElement(By.id("newPropertyOwnerForm"));
        Assert.assertTrue(propertyOwnerForm.isDisplayed());
    }

    @And("The form contains the field: Name")
    public void formContainsNameField() {
        WebElement nameField = driver.findElement(By.id("propertyOwnerName"));
        Assert.assertTrue(nameField.isDisplayed());
    }

    @And("The form contains the field: Surname")
    public void formContainsSurnameField() {
        WebElement surnameField = driver.findElement(By.id("propertyOwnerSurname"));
        Assert.assertTrue(surnameField.isDisplayed());
    }

    @And("The form contains the field: Address")
    public void formContainsAddressField() {
        WebElement addressField = driver.findElement(By.id("propertyOwnerAddress"));
        Assert.assertTrue(addressField.isDisplayed());
    }

    @And("The form contains the field: Phone Number")
    public void formContainsPhoneNumberField() {
        WebElement phoneNumberField = driver.findElement(By.id("propertyOwnerPhoneNumber"));
        Assert.assertTrue(phoneNumberField.isDisplayed());
    }

    @And("The form contains the field: TIN number")
    public void formContainsTinNumberField() {
        WebElement tinNumberField = driver.findElement(By.id("propertyOwnerTinNumber"));
        Assert.assertTrue(tinNumberField.isDisplayed());
    }

    @And("The form contains the field: Email")
    public void formContainsEmailField() {
        WebElement emailField = driver.findElement(By.id("propertyOwnerEmail"));
        Assert.assertTrue(emailField.isDisplayed());
    }

    @And("The form contains the field: Username")
    public void formContainsUsernameField() {
        WebElement usernameField = driver.findElement(By.id("propertyOwnerUsername"));
        Assert.assertTrue(usernameField.isDisplayed());
    }

    @And("The form contains the field: password")
    public void formContainsPasswordField() {
        WebElement passwordField = driver.findElement(By.id("propertyOwnerPassword"));
        Assert.assertTrue(passwordField.isDisplayed());
    }


    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //%%% Scenario: New Property Owner Registration %%%
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    @Given("The Create New Property Owner Form is displayed")
    public void createNewPropertyOwnerFormDisplayed() {
        WebElement propertyOwnerForm = driver.findElement(By.id("newPropertyOwnerForm"));
        Assert.assertTrue(propertyOwnerForm.isDisplayed());
    }

    @Then("I fill out the form by entering the Name {string}")
    public void fillOutNameField(String name) {
        WebElement nameField = driver.findElement(By.id("propertyOwnerName"));
        nameField.sendKeys(name);
    }

    @And("I enter the Surname {string}")
    public void fillOutSurnameField(String surname) {
        WebElement surnameField = driver.findElement(By.id("propertyOwnerSurname"));
        surnameField.sendKeys(surname);
    }

    @And("I enter the Address {string}")
    public void fillOutAddressField(String address) {
        WebElement addressField = driver.findElement(By.id("propertyOwnerAddress"));
        addressField.sendKeys(address);
    }

    @And("I enter the Phone Number {string}")
    public void fillOutPhoneNumberField(String phoneNumber) {
        WebElement phoneNumberField = driver.findElement(By.id("propertyOwnerPhoneNumber"));
        phoneNumberField.sendKeys(phoneNumber);
    }

    @And("I enter the TIN number {string}")
    public void fillOutTinNumberField(String tinNumber) {
        WebElement tinNumberField = driver.findElement(By.id("propertyOwnerTinNumber"));
        tinNumberField.sendKeys(tinNumber);
    }

    @And("I enter the Email {string}")
    public void fillOutEmailField(String email) {
        WebElement emailField = driver.findElement(By.id("propertyOwnerEmail"));
        emailField.sendKeys(email);
    }

    @And("I enter the Username {string}")
    public void fillOutUsernameField(String username) {
        WebElement usernameField = driver.findElement(By.id("propertyOwnerUsername"));
        usernameField.sendKeys(username);
    }

    @And("I enter the Password {string}")
    public void fillOutPasswordField(String password) {
        WebElement passwordField = driver.findElement(By.id("propertyOwnerPassword"));
        passwordField.sendKeys(password);
    }
}

