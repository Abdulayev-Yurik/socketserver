package app;

import server.Handler;
import server.HtmlUtils;
import server.HttpRequest;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by yurik on 10.11.16.
 */
public class GreeterImpl extends HtmlUtils implements Handler{

    public GreeterImpl(HttpRequest httpRequest) {
    }

    @Override
    public String print(HttpRequest request) {
        String name = "";
        try {
            name = request.getParameters().get("name");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String result = "world";
        try {
            result = (name.isEmpty() ? "world" :
                    URLDecoder.decode(name , "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return htmlHeader + ("<tr><a href=\"/home/\">Back</a></tr><br>") + "Hello " + result + htmlFooter;
    }


}
