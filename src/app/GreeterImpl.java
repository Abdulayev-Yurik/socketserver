package app;

import server.Handler;
import server.HtmlUtils;
import server.HttpRequest;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by yurik on 10.11.16.
 */
public class GreeterImpl extends HtmlUtils implements Handler {

    public GreeterImpl(HttpRequest httpRequest) {
    }

    @Override
    public String print(HttpRequest request) {
        String result = "world";
        try {
            String name = request.getParameters().get("name");
            result = (name.isEmpty() ? "world" :
                    URLDecoder.decode(name, "UTF-8"));

        } catch (NullPointerException e ){
        } catch (UnsupportedEncodingException e) {
        }

        return htmlHeader + ("<tr><a href=\"/home\">Back</a></tr><br>") + "Hello " + result + htmlFooter;
    }


}
