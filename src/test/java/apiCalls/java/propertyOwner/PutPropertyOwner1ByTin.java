package apiCalls.java.propertyOwner;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;

public class PutPropertyOwner1ByTin {
    static String tinNumber = "123456789";
    public static void main(String[] args) {
        try {
            String url = "http://localhost:8080/api/owner/update/" + tinNumber;
            String json = """
                    {
                      "address": "Nea Tyxaia Dieuthynsi 51",
                      "email": "neo.tyxaio.email.1.p@example.com",
                      "password": "NEWasdf1234!@"
                    }
                    """;
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json")
                    .PUT(BodyPublishers.ofString(json))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                System.out.println("\u001B[1m\u001B[32mTest Passed\u001B[0m - Property Owner Successfully Updated (Status code: Expected: 200 - Actual: " + response.statusCode() + ")");
            } else if (response.statusCode() == 404) {
                System.out.println("\u001B[1m\u001B[31mTest Failed\u001B[0m - \u001B[33mProperty Owner not found\u001B[0m (Status code: Expected: 200 - Actual: " + response.statusCode() + ")");
            } else {
                System.out.println("\u001B[1m\u001B[31mTest Failed\u001B[0m (Status code: Expected: 200 - Actual: " + response.statusCode() + ")");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    public int getStatusCodePutPropertyOwner1ByTin() {
        try {
            String uri = "http://localhost:8080/api/owner/update/" + tinNumber;
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.statusCode();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
