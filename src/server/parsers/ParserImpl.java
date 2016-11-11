package server.parsers;

import server.HttpRequest;

import java.io.*;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by employee on 11/10/16.
 */
public class ParserImpl implements Parser {

    @Override
    public HttpRequest parse(InputStream stream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        try {
            String fullPath = reader.readLine().split(" ")[1];
            return new HttpRequest(getPath(fullPath), getParameters(fullPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getPath(String path){
        int la = path.lastIndexOf("/");
        return path.substring(0, la == 0 ? path.length() : la);
    }

    private Map<String, String> getParameters(String path) throws UnsupportedEncodingException {
        String string = path.substring(path.indexOf("?") + 1);
        Map<String, String> query_pairs = new LinkedHashMap<>();
        String[] pairs = string.split("&");
        for (String pair : pairs) {
            int idx = pair.indexOf("=");
            try {
                query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"),
                        URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
            }catch (IndexOutOfBoundsException e){}
        }
        return query_pairs;
    }
}
