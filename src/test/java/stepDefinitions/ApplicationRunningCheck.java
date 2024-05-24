package stepDefinitions;

import apiCalls.java.homeController.GetHome;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApplicationRunningCheck {

    @Given("That the Endpoint is Up and Running")
    public void apiRunning() {
        GetHome getHome = new GetHome();
        GetHome.main(null);
        assertEquals(200, getHome.getStatusCodeGetHome());
    }

    @When("We make a GET Request for the Property Owner with TIN {string}")
    public void apiCall(String tinNumber) throws Exception {
        String uri = "http://localhost:8080/api/owner/search?tin=" + tinNumber;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(200, response.statusCode());
    }

    @Then("We Get a response that contains the Details of the Property Owner with TIN {string}")
    public void assertResponseBody(String tinNumber) throws Exception {
        String uri = "http://localhost:8080/api/owner/search?tin=" + tinNumber;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Assert.assertTrue(response.body().contains(tinNumber));
        System.out.println(response.body());
    }
}