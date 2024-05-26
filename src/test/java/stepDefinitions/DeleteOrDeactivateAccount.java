package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static stepDefinitions.TestSetup.driver;

public class DeleteOrDeactivateAccount {

    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //%%% Scenario: Property Owner Deletes Account Connected To No Properties %%%
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    @Given("I am Logged-In as a Property Owner and I want to Delete my Account that has no Properties related to it")
    public void loggedInAsPropertyOwnerNoProperties() {
        WebElement propertyOwnerMainPage = driver.findElement(By.id("propertyOwnerMainPage"));
        String propertyOwnerMainPageStr = propertyOwnerMainPage.getText();
        Assert.assertEquals("Property Owner Main Page", propertyOwnerMainPageStr);
    }

    @When("I select to View My Profile")
    public void selectViewMyProfile() {
        WebElement viewProfileButton = driver.findElement(By.id("viewProfileButton"));
        viewProfileButton.click();
    }

    @And("I click the Delete Property Owner Account Button")
    public void clickDeletePropertyOwnerAccountButton() {
        WebElement deleteAccountButton = driver.findElement(By.id("deletePropertyOwnerAccountButton"));
        deleteAccountButton.click();
    }

    @And("I confirm that I want to Delete that Property Owner Account")
    public void confirmDeletePropertyOwnerAccount() {
        WebElement confirmDeleteButton = driver.findElement(By.id("confirmDeleteButton"));
        confirmDeleteButton.click();
    }

    @Then("The Property Owner Account is Deleted")
    public void propertyOwnerAccountDeleted() {
        WebElement deletionMessage = driver.findElement(By.id("deletionMessage"));
        String deletionMessageStr = deletionMessage.getText();
        Assert.assertEquals("Property Owner Account has been deleted.", deletionMessageStr);
    }

    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //%%% Scenario: Property Owner Deletes Account Connected To At Least One Property %%%
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    @Given("I am Logged-In as a Property Owner and I want to Delete my Account that has at least one Property related to it")
    public void loggedInAsPropertyOwnerWithProperties() {
        WebElement propertyOwnerMainPage = driver.findElement(By.id("propertyOwnerMainPage"));
        String propertyOwnerMainPageStr = propertyOwnerMainPage.getText();
        Assert.assertEquals("Property Owner Main Page", propertyOwnerMainPageStr);
    }

    @When("I select to View My Profile")
    public void selectViewMyProfileWithProperties() {
        WebElement viewProfileButton = driver.findElement(By.id("viewProfileButton"));
        viewProfileButton.click();
    }

    @And("I click the Delete Property Owner Account Button")
    public void clickDeletePropertyOwnerAccountButtonWithProperties() {
        WebElement deleteAccountButton = driver.findElement(By.id("deletePropertyOwnerAccountButton"));
        deleteAccountButton.click();
    }

    @And("I confirm that I want to Delete that Property Owner Account")
    public void confirmDeletePropertyOwnerAccountWithProperties() {
        WebElement confirmDeleteButton = driver.findElement(By.id("confirmDeleteButton"));
        confirmDeleteButton.click();
    }

    @Then("The Property Owner Account is Deactivated")
    public void propertyOwnerAccountDeactivated() {
        WebElement deactivationMessage = driver.findElement(By.id("deactivationMessage"));
        String deactivationMessageStr = deactivationMessage.getText();
        Assert.assertEquals("Property Owner Account has been deactivated.", deactivationMessageStr);
    }
}
