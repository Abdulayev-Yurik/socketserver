import app.HomePageImpl;
import org.junit.Test;
import server.HttpRequest;
import server.Parser;
import server.Router;
import server.WebServer;
import server.impl.ParserImpl;
import server.impl.RouterImpl;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by employee on 11/11/16.
 */
public class WebServerTest {

    @Test
    public void testServer() {
        Parser parser = new ParserImpl();
        Router router = new RouterImpl();
//        new Thread(() -> {
//            router.register("/home", HomePageImpl::new);
//
//            ServerSocket server = new ServerSocket(80);
//
//            Socket socket = server.accept();
//
//            HttpRequest request = parser.parse(socket.getInputStream());
//            if (!request.getPath().isEmpty()) {
//                String dispatch = router.getResponse(request);
//
//                socket.getOutputStream().write(dispatch.getBytes("UTF-8"));
//            }
//            socket.close();
//
//
//        }).start();
    }
}
