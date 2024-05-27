package apiCalls.auth;

public class TokenManager {
    private static TokenManager instance;
    private String token;

    private TokenManager() {
    }

    public static synchronized TokenManager getInstance() {
        if (instance == null) {
            instance = new TokenManager();
        }
        return instance;
    }

    public synchronized void setToken(String token) {
        this.token = token;
    }

    public synchronized String getToken() {
        return token;
    }
}
