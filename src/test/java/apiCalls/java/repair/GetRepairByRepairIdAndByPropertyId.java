package apiCalls.java.repair;

import apiCalls.java.support.PrettyJsonPrinter;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetRepairByRepairIdAndByPropertyId {
    public static void main(String[] args) {
        String propertyId = "3";
        String repairId = "6";
        try {
            String uri = "http://localhost:8080/api/owner/" + propertyId + "/repair/" + repairId;
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                System.out.println("\u001B[1m\u001B[32mTest Passed\u001B[0m (Status code: Expected: 200 - Actual: " + response.statusCode() + ")");
            } else {
                System.out.println("\u001B[1m\u001B[31mTest Failed\u001B[0m (Status code: Expected: 200 - Actual: " + response.statusCode() + ")");
            }
            if (response.body().contains("\"propertyId\":" + propertyId)) {
                System.out.println("\u001B[1m\u001B[32mTest Passed\u001B[0m (Response body contains propertyId)");
            } else {
                System.out.println("\u001B[1m\u001B[31mTest Failed\u001B[0m (Response body does not contain propertyId)");
            }
            System.out.println("Response body:");
            PrettyJsonPrinter.printJson(response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
