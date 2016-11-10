package server;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by employee on 11/10/16.
 */
public class HttpRequest {
    private final String fullPath;
    private final String query;

    public HttpRequest(String fullPath) {
        this.fullPath = fullPath;
        this.query = fullPath;
    }

    public String getPath(){
        return fullPath.substring(0, fullPath.lastIndexOf("/"));
    }

    public Map<String, String> getParameters() throws UnsupportedEncodingException {
        String string = query.substring(query.indexOf("?") + 1);
        Map<String, String> query_pairs = new LinkedHashMap<>();
        String[] pairs = string.split("&");
        for (String pair : pairs) {
            int idx = pair.indexOf("=");
            query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"), URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
        }
        return query_pairs;
    }
}
