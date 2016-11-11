package server;

import java.util.Map;

/**
 * Created by employee on 11/10/16.
 */
public class HttpRequest {

    private final String path;
    private final Map<String, String> parameters;

    public HttpRequest(String path, Map<String, String> parameters) {
        this.path = path;
        this.parameters = parameters;
    }

    public String getPath() {
        return path;
    }
    public Map<String, String> getParameters() {
        return parameters;
    }
}
