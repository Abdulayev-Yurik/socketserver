package app;

import calendar.interfaces.Calendar;
import calendar.web.WebCalendar;
import server.Handler;
import server.HttpRequest;
import server.HtmlUtils;

/**
 * Created by employee on 11/10/16.
 */
public class CalendarImpl implements Handler {

    private HttpRequest httpRequest;

    public CalendarImpl(HttpRequest httpRequest) {
        this.httpRequest = httpRequest;
    }

    @Override
    public String print(HttpRequest request) {

        System.out.println(request.getPath());
        Calendar calendar = new WebCalendar();
        return HtmlUtils.htmlHeader +
                "<table>" +
                "<tr><a href=\"/home/\">Back</a></tr><br>" +
                calendar.getCurrentMonthHeader() +
                calendar.getWeekNames() +
                calendar.getMonthValues() +
                "</table>" + HtmlUtils.htmlFooter;
    }
}
