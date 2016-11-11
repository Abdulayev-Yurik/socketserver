package server;

import server.parsers.Parser;
import server.routers.Router;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by employee on 11/10/16.
 */
public class WebServer {

    private Integer port;
    private Parser parser;
    private Router router;

    public WebServer(Integer port, Parser parser, Router router) {
        this.port = port;
        this.parser = parser;
        this.router = router;
    }

    public void start() throws IOException {
        ServerSocket server = new ServerSocket(port);
        System.out.println("server is running " + port);
        while (true){
            Socket socket = server.accept();

            HttpRequest request = parser.parse(socket.getInputStream());
            if (!request.getPath().isEmpty()) {
                String handler = router.dispatch(request);

                socket.getOutputStream().write(handler.getBytes("UTF-8"));
            }
            socket.close();
        }
    }

    public void stop(){
        System.exit(0);
    }
}
