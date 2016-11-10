package server.parsers;

import server.HttpRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by employee on 11/10/16.
 */
public class ParserImpl implements Parser {

    @Override
    public HttpRequest parse(InputStream stream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        try {
            String fullPath = reader.readLine().split(" ")[1];
            return new HttpRequest(fullPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
