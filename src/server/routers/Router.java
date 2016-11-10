package server.routers;

import server.Handler;
import server.HttpRequest;

import java.util.function.Function;

/**
 * Created by employee on 11/10/16.
 */
public interface Router {

    void register(String path, Function<HttpRequest, Handler> handlerFactory);

    String dispatch(HttpRequest httpRequest);
}
