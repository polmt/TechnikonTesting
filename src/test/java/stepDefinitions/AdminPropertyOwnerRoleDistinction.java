package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static stepDefinitions.TestSetup.driver;

public class AdminPropertyOwnerRoleDistinction {

    @Given("The Log-In Page is displayed")
    public void loginPageIsDisplayed() {
        WebElement loginPage = driver.findElement(By.id("logInPageLogInTitle"));
        String loginPageTitle = loginPage.getText();
        Assert.assertEquals("Login page", loginPageTitle);
    }

    @When("I enter the Credentials {string} {string}")
    public void enterCredentials(String username, String password) {
        WebElement usernameField = driver.findElement(By.id("logInUsername"));
        usernameField.sendKeys(username);
        WebElement passwordField = driver.findElement(By.id("logInPassword"));
        passwordField.sendKeys(password);
    }

    @And("I click the Log-In Button")
    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(By.id("logInPageEmailField"));
        loginButton.click();
    }

    @Then("I am Logged-In as an Administrator")
    public void loggedInAsAdmin() {
        WebElement adminLogInMessage = driver.findElement(By.id("successfulAdminLogIn"));
        String adminLogInMessageStr = adminLogInMessage.getText();
        Assert.assertEquals("Successful Log-In. Welcome Admin!", adminLogInMessageStr);
    }

    @Then("I am Logged-In as a Property Owner")
    public void loggedInAsPropertyOwner() {
        WebElement propertyOwnerLogInMessage = driver.findElement(By.id("successfulPropertyOwnerLogIn"));
        String propertyOwnerLogInMessageStr = propertyOwnerLogInMessage.getText();
        Assert.assertEquals("Successful Log-In. Welcome Property Owner!", propertyOwnerLogInMessageStr);
    }

    @Given("I am Logged-In as an Administrator and I want to explore all Property Owners' Properties")
    public void adminAccessLevel() {
        WebElement adminMainPage = driver.findElement(By.id("adminMainPage"));
        String adminMainPageStr = adminMainPage.getText();
        Assert.assertEquals("Administrator Main Page", adminMainPageStr);
    }

    @When("I try to Access the List of other Property Owner Properties")
    public void adminAccessPropertyList() {
        WebElement someoneElsesPropertyAdminView = driver.findElement(By.id("userListViewUserDetails1"));
        someoneElsesPropertyAdminView.click();
    }

    @Then("I can see All the Properties present in the Database from All the Property Owners")
    public void adminViewEntirePropertyDatabase() {
        WebElement someoneElsesPropertyIdAdminView = driver.findElement(By.id("someoneElsesPropertyId1AdminView"));
        String someoneElsesPropertyId1AdminView = someoneElsesPropertyIdAdminView.getText();
        Assert.assertEquals("userListViewUserDetailsId1", someoneElsesPropertyId1AdminView);

        WebElement someoneElsesPropertyLocationAdminView = driver.findElement(By.id("someoneElsesPropertyLocation2AdminView"));
        String someoneElsesPropertyLocation1AdminView = someoneElsesPropertyLocationAdminView.getText();
        Assert.assertEquals("userListViewUserDetailsLocation2", someoneElsesPropertyLocation1AdminView);
    }

    @Given("I am Logged-In as a Property Owner and I want to explore all of My Properties")
    public void propertyOwnerAccessLevel() {
        WebElement propertyOwnerMainPage = driver.findElement(By.id("propertyOwnerMainPage"));
        String propertyOwnerMainPageStr = propertyOwnerMainPage.getText();
        Assert.assertEquals("Property Owner Main Page", propertyOwnerMainPageStr);
    }

    @When("I try to Access the List of My Properties")
    public void propertyOwnerAccessPropertyList() {
        WebElement myPropertiesView = driver.findElement(By.id("myPropertiesViewDetails1"));
        myPropertiesView.click();
    }

    @Then("I can see All of My Properties present in the Database")
    public void propertyOwnerViewMyPropertiesDatabase() {
        WebElement myPropertyIdView = driver.findElement(By.id("myPropertyId1View"));
        String myPropertyId1View = myPropertyIdView.getText();
        Assert.assertEquals("myPropertyId1", myPropertyId1View);

        WebElement myPropertyLocationView = driver.findElement(By.id("myPropertyLocation2View"));
        String myPropertyLocation2View = myPropertyLocationView.getText();
        Assert.assertEquals("myPropertyLocation2", myPropertyLocation2View);
    }

    @Given("I am Logged-In as an Administrator and I want to Delete a Property Owner who has a Property Registered to their account")
    public void adminDeletePropertyOwnerSetup() {
        WebElement adminMainPage = driver.findElement(By.id("adminMainPage"));
        String adminMainPageStr = adminMainPage.getText();
        Assert.assertEquals("Administrator Main Page", adminMainPageStr);
    }

    @When("I click the Delete Property Owner Account Button")
    public void clickDeletePropertyOwnerButton() {
        WebElement deletePropertyOwnerButton = driver.findElement(By.id("deletePropertyOwnerAccountButton"));
        deletePropertyOwnerButton.click();
    }

    @And("I confirm that I want to Delete that Property Owner Account")
    public void confirmDeletePropertyOwnerAccount() {
        WebElement confirmDeleteButton = driver.findElement(By.id("confirmDeleteButton"));
        confirmDeleteButton.click();
    }

    @Then("The Property Owner Account is Deactivated")
    public void propertyOwnerAccountDeactivated() {
        WebElement deactivationMessage = driver.findElement(By.id("deactivationMessage"));
        String deactivationMessageStr = deactivationMessage.getText();
        Assert.assertEquals("Property Owner Account has been deactivated.", deactivationMessageStr);
    }

    @Given("I am Logged-In as an Property Owner and I want to Delete My Account that has a Property Registered to their account")
    public void propertyOwnerDeleteAccountSetup() {
        WebElement propertyOwnerMainPage = driver.findElement(By.id("propertyOwnerMainPage"));
        String propertyOwnerMainPageStr = propertyOwnerMainPage.getText();
        Assert.assertEquals("Property Owner Main Page", propertyOwnerMainPageStr);
    }

    @When("I click the Delete My Account Button")
    public void clickDeleteMyAccountButton() {
        WebElement deleteMyAccountButton = driver.findElement(By.id("deleteMyAccountButton"));
        deleteMyAccountButton.click();
    }

    @And("I confirm that I want to Delete My Account")
    public void confirmDeleteMyAccount() {
        WebElement confirmDeleteButton = driver.findElement(By.id("confirmDeleteButton"));
        confirmDeleteButton.click();
    }

    @Then("My Account is Deactivated")
    public void myAccountDeactivated() {
        WebElement deactivationMessage = driver.findElement(By.id("deactivationMessage"));
        String deactivationMessageStr = deactivationMessage.getText();
        Assert.assertEquals("Your account has been deactivated.", deactivationMessageStr);
    }
}
