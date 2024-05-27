package apiCalls.auth;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CreateNewProperty {
    public void makeAuthenticatedRequest() throws IOException, InterruptedException {
        String token = TokenManager.getInstance().getToken();
        if (token == null || token.isEmpty()) {
            System.err.println("No token found. Please login first.");
            return;
        }
        int ownerId = 21;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/api/owner/" + ownerId + "/property"))
                .header("Authorization", "Bearer " + token)
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            System.out.println("Response: " + response.body());
        } else {
            System.err.println("Request failed: " + response.statusCode());
        }
    }
    public static void main(String[] args) {
        AuthService authService = new AuthService();
        try {
            authService.login("user0", "1234");
            CreateNewProperty createNewProperty = new CreateNewProperty();
            createNewProperty.makeAuthenticatedRequest();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
