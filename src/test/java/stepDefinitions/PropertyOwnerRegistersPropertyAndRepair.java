package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static stepDefinitions.TestSetup.driver;

public class PropertyOwnerRegistersPropertyAndRepair {

    @Given("I am Logged-In as a Property Owner")
    public void loggedInAsPropertyOwner() {
        WebElement propertyOwnerMainPage = driver.findElement(By.id("propertyOwnerMainPage"));
        String propertyOwnerMainPageStr = propertyOwnerMainPage.getText();
        Assert.assertEquals("Property Owner Main Page", propertyOwnerMainPageStr);
    }

    @When("I click the Register New Property Button")
    public void clickRegisterNewPropertyButton() {
        WebElement registerNewPropertyButton = driver.findElement(By.id("registerNewPropertyButton"));
        registerNewPropertyButton.click();
    }

    @And("I fill out the form of the info of that Property by entering the Property IN {string}")
    public void enterPropertyIN(String propertyIN) {
        WebElement propertyINField = driver.findElement(By.id("propertyINField"));
        propertyINField.sendKeys(propertyIN);
    }

    @And("I enter the Address {string}")
    public void enterAddress(String address) {
        WebElement addressField = driver.findElement(By.id("addressField"));
        addressField.sendKeys(address);
    }

    @And("I enter the Year Of Construction {string}")
    public void enterYearOfConstruction(String yearOfConstruction) {
        WebElement yearOfConstructionField = driver.findElement(By.id("yearOfConstructionField"));
        yearOfConstructionField.sendKeys(yearOfConstruction);
    }

    @And("I enter the Property Owner ID {string}")
    public void enterPropertyOwnerID(String propertyOwnerID) {
        WebElement propertyOwnerIDField = driver.findElement(By.id("propertyOwnerIDField"));
        propertyOwnerIDField.sendKeys(propertyOwnerID);
    }

    @And("I enter a Picture {string}")
    public void enterPicture(String picture) {
        WebElement pictureField = driver.findElement(By.id("pictureField"));
        pictureField.sendKeys(picture);
    }

    @And("I enter the Type Of That Property {string}")
    public void enterTypeOfProperty(String typeOfProperty) {
        WebElement typeOfPropertyField = driver.findElement(By.id("typeOfPropertyField"));
        typeOfPropertyField.sendKeys(typeOfProperty);
    }

    @And("I click the Register A Property Button")
    public void clickRegisterAPropertyButton() {
        WebElement registerPropertyButton = driver.findElement(By.id("registerPropertyButton"));
        registerPropertyButton.click();
    }

    @Then("The New Property is Registered")
    public void newPropertyIsRegistered() {
        WebElement registrationMessage = driver.findElement(By.id("registrationMessage"));
        String registrationMessageStr = registrationMessage.getText();
        Assert.assertEquals("New Property has been registered.", registrationMessageStr);
    }

    @Given("I am located in My Profile Page")
    public void locatedInMyProfilePage() {
        WebElement myProfilePage = driver.findElement(By.id("myProfilePage"));
        String myProfilePageStr = myProfilePage.getText();
        Assert.assertEquals("My Profile Page", myProfilePageStr);
    }

    @When("I click the Create New Repair Button")
    public void clickCreateNewRepairButton() {
        WebElement createNewRepairButton = driver.findElement(By.id("createNewRepairButton"));
        createNewRepairButton.click();
    }

    @And("I fill out the form of the info of that Repair by entering the Type Of Repair {string}")
    public void enterTypeOfRepair(String typeOfRepair) {
        WebElement typeOfRepairField = driver.findElement(By.id("typeOfRepairField"));
        typeOfRepairField.sendKeys(typeOfRepair);
    }

    @And("I enter the Description {string}")
    public void enterDescription(String description) {
        WebElement descriptionField = driver.findElement(By.id("descriptionField"));
        descriptionField.sendKeys(description);
    }

    @And("I enter the Repair Date {string}")
    public void enterRepairDate(String repairDate) {
        WebElement repairDateField = driver.findElement(By.id("repairDateField"));
        repairDateField.sendKeys(repairDate);
    }

    @And("I enter the Property ID {string}")
    public void enterPropertyID(String propertyID) {
        WebElement propertyIDField = driver.findElement(By.id("propertyIDField"));
        propertyIDField.sendKeys(propertyID);
    }

    @Then("The New Repair is Registered")
    public void newRepairIsRegistered() {
        WebElement registrationMessage = driver.findElement(By.id("registrationMessage"));
        String registrationMessageStr = registrationMessage.getText();
        Assert.assertEquals("New Repair has been registered.", registrationMessageStr);
    }
}
