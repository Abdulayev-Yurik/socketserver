package app;

import server.Handler;
import server.HttpRequest;
import server.HtmlUtils;

/**
 * Created by yurik on 10.11.16.
 */
public class HomePageImpl extends HtmlUtils implements Handler{

    public HomePageImpl(HttpRequest httpRequest) {

    }

    @Override
    public String print(HttpRequest request) {
        return htmlHeader +
                "<a href=\"/calendar/\"><input type=\"submit\" value=\"view calendar\" /></a> " +
                "<form action=\"/greeter/\">" +
                "<input type=\"text\" name=\"name\" placeholder=\"Enter your name\"/>" +
                "<input type=\"submit\" class=\"button\" value=\"Send\"></form> " +
                htmlFooter;
    }
}
