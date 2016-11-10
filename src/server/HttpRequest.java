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

    public HttpRequest(String fullPath) {
        this.fullPath = fullPath;
    }

    public String getPath(){
        return fullPath.substring(1, fullPath.indexOf(fullPath, 1) + 1); // FIXME: 11/10/16
    }

    public Map<String, String> getPath(String query) throws UnsupportedEncodingException {
        Map<String, String> query_pairs = new LinkedHashMap<>();
        String[] pairs = query.split("&");
        for (String pair : pairs) {
            int idx = pair.indexOf("=");
            query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"), URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
        }
        return query_pairs;
    }
}
