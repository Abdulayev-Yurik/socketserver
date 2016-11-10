package server.parsers;

import server.HttpRequest;

import java.io.InputStream;

/**
 * Created by employee on 11/10/16.
 */
public interface Parser {

    HttpRequest parse(InputStream stream);
}
