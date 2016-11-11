package server.routers;

import app.PageError;
import server.Handler;
import server.HttpRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by employee on 11/10/16.
 */
public class RouterImpl implements Router {

    private Map<String, Function<HttpRequest, Handler>> routes = new HashMap<>();

    @Override
    public void register(String path, Function<HttpRequest, Handler> handlerFactory) {
        routes.put(path, handlerFactory);
    }

    @Override
    public String dispatch(HttpRequest httpRequest) {
        Handler handler;
        try {
            handler = routes.get(httpRequest.getPath()).apply(httpRequest);
        }catch (NullPointerException e){
            handler = new PageError(404);
        }
        return handler.print(httpRequest);
    }
}
