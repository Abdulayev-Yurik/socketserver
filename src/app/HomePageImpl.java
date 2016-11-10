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
                "<form action=\"/calendar/\">" +
                "<input type=\"text\" name=\"date\" placeholder=\"enter date 2016-12-30\" /><br>" +
                "<input type=\"text\" name=\"custom_week\" placeholder=\"enter start week 3\" /><br>" +
                "<input type=\"text\" name=\"weekends\" placeholder=\"enter weekends = 1,2,3\" /><br>" +
                "<input type=\"submit\" value=\"view calendar\" />" +
                "</form> " +
                "<form action=\"/greeter/\">" +
                "<input type=\"text\" name=\"name\" placeholder=\"Enter your name\"/>" +
                "<input type=\"submit\" class=\"button\" value=\"Send\"></form> " +
                htmlFooter;
    }
}
