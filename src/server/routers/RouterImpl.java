package server.routers;

import app.HomePageImpl;
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
        if (routes.containsKey(httpRequest.getPath())){
            handler = routes.get(httpRequest.getPath()).apply(httpRequest);
        }else {
            handler = new HomePageImpl(httpRequest);
        }
        return handler.print(httpRequest);
    }
}
