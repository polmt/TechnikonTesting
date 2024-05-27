package apiCalls.auth;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AuthService {

    private static final String LOGIN_URL = "http://localhost:8080/auth/login";

    public void login(String username, String password) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        String requestBody = String.format("{\"username\": \"%s\", \"password\": \"%s\"}", username, password);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(LOGIN_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            String responseBody = response.body();
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(responseBody);
            String token = jsonNode.get("token").asText();
            TokenManager.getInstance().setToken(token);
            System.out.println("Token saved: " + token);
        } else {
            System.err.println("Login failed: " + response.statusCode());
        }
    }

    public static void main(String[] args) {
        AuthService authService = new AuthService();
        try {
            authService.login("user0", "1234");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


}
