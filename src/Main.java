import server.WebServer;
import server.parsers.Parser;
import server.routers.Router;
import server.parsers.ParserImpl;
import server.routers.RouterImpl;

import java.io.IOException;

/**
 * Created by employee on 11/10/16.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Parser parser = new ParserImpl();
        Router router = new RouterImpl();
        WebServer server = new WebServer(8080, parser, router);

        server.start();

    }
}
