package apiCalls.java.property;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static apiCalls.java.support.PrettyJsonPrinter.printJson;


public class GetPropertyByPropertyIdAndByOwnerId {
    public static void main(String[] args) {
        String ownerId = "21";
        String propertyId = "3";
        try {
            String uri = "http://localhost:8080/api/owner/" + ownerId + "/property/" + propertyId;
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 302) {
                System.out.println("\u001B[1m\u001B[32mTest Passed\u001B[0m (Status code: Expected: 302 Redirected - Actual: " + response.statusCode() + ")");
            } else {
                System.out.println("\u001B[1m\u001B[31mTest Failed\u001B[0m (Status code: Expected: 302 - Actual: " + response.statusCode() + ")");
            }
            if (response.body().contains(propertyId)) {
                System.out.println("\u001B[1m\u001B[32mTest Passed\u001B[0m (Response body contains the correct Identification Number)");
                System.out.println("Response body:");
                printJson(response.body());
            } else {
                System.out.println("\u001B[1m\u001B[31mTest Failed\u001B[0m (Response body does not contain the correct Identification Number)");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
