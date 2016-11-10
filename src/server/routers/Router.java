package server.routers;

import server.Handler;
import server.HttpRequest;

/**
 * Created by employee on 11/10/16.
 */
public interface Router {

    Handler route(HttpRequest request);
}
