package stepDefinitions;

import apiCalls.java.homeController.GetHome;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static stepDefinitions.TestSetup.driver;

public class MainPageFunctionalities {

    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //%%% Scenario: Navigate From The Main Page To The Log In Page %%%
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    @Given("The Application is Up And Running")
    public void applicationUpRunning() {
        GetHome getHome = new GetHome();
        GetHome.main(null);
        assertEquals(200, getHome.getStatusCodeGetHome());
    }

    @When("I click the Log-In Button to Navigate to the Log In Page")
    public void mainToLogInPageClickLogIn() {
        WebElement clickLogInFromMainToLogIn = driver.findElement(By.id("mainPageLogInButton"));
        clickLogInFromMainToLogIn.click();
    }

    @Then("I am Redirected to the Log In Page or the Log In Window Pops Up")
    public void mainToLogInPageSuccessfulTransition() {
        WebElement fromMainToLogInSuccessTrans = driver.findElement(By.id("logInPageLogInTitle"));
        String logInPageTitle = fromMainToLogInSuccessTrans.getText();
        Assert.assertEquals("Login", logInPageTitle);
    }


    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //%%% Scenario: Navigate From The Main Page To The Sign Up Page %%%
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    @When("I click the Sign Up Button to Navigate to the Sign Up Page")
    public void mainToSignUpPageClickSignUp() {
        WebElement clickSignUpFromMainToSignUp = driver.findElement(By.id("mainPageSignUpButton"));
        clickSignUpFromMainToSignUp.click();
    }

    @Then("I am Redirected to the Sign Up Page or the Sign Up Window Pops Up")
    public void mainToSignUpPageSuccessfulTransition() {
        WebElement fromMainToSignUpSuccessTrans = driver.findElement(By.id("signUpPageSignUpTitle"));
        String signUpPageTitle = fromMainToSignUpSuccessTrans.getText();
        Assert.assertEquals("Sign Up", signUpPageTitle);
    }


    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //%%% Scenario: Navigate From The Log In To The Sign Up Page %%%
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    @Given("I am at the Log In Page")
    public void beingAtLogInPage() {
        WebElement logInPageTitle = driver.findElement(By.id("logInPageLogInTitle"));
        Assert.assertEquals("Login", logInPageTitle.getText());
    }

    @When("I click the Sign Up Button")
    public void clickSignUpFromLogIn() {
        WebElement clickSignUpFromLogIn = driver.findElement(By.id("logInPageSignUpButton"));
        clickSignUpFromLogIn.click();
    }

    @Then("I am Redirected to the Sign Up Page or the Sign Up Window Pops Up")
    public void fromLogInToSignUpRedirect() {
        WebElement signUpPageTitle = driver.findElement(By.id("signUpPageSignUpTitle"));
        Assert.assertEquals("Sign Up", signUpPageTitle.getText());
    }


    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //%%% Scenario: Navigate From The Log In To The Sign Up Page %%%
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    @Given("I am at the Sign Up Page")
    public void beingAtSignUpPage() {
        WebElement signUpPageTitle = driver.findElement(By.id("signUpPageSignUpTitle"));
        Assert.assertEquals("Sign Up", signUpPageTitle.getText());
    }

    @When("I click the Log In Button")
    public void clickLogInFromSignUp() {
        WebElement clickLogInFromSignUp = driver.findElement(By.id("signUpPageLogInButton"));
        clickLogInFromSignUp.click();
    }

    @Then("I am Redirected to the Log In Page or the Log In Window Pops Up")
    public void fromSignUpToLogInRedirect() {
        WebElement logInPageTitle = driver.findElement(By.id("logInPageLogInTitle"));
        Assert.assertEquals("Login", logInPageTitle.getText());
    }
}
