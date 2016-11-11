package app;

import calendar.interfaces.Calendar;
import calendar.web.WebCalendar;
import server.Handler;
import server.HttpRequest;
import server.HtmlUtils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

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
        Calendar calendar;
        try {
            calendar = new WebCalendar(getDate(request.getParameters().get("date")),
                    getStartDay(request.getParameters().get("custom_week")),
                    getWeekends(request.getParameters().get("weekends")));
        }catch (Exception e){
            calendar = new WebCalendar();
        }
        return HtmlUtils.htmlHeader +
                "<table>" +
                "<tr><a href=\"/home\">Back</a></tr><br>" +
                calendar.getCurrentMonthHeader() +
                calendar.getWeekNames() +
                calendar.getMonthValues() +
                "</table>" + HtmlUtils.htmlFooter;
    }

    private List<DayOfWeek> getWeekends(String weekends) {
        List<DayOfWeek> listWeekends = new ArrayList<>();
        if (weekends.isEmpty()) {
            return Arrays.asList(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY);
        }
        int numberDay = 0;
        for (String s : weekends.split(",")) {
            numberDay = parseInt(s.trim());
            if ( numberDay >= DayOfWeek.MONDAY.getValue() && numberDay <= DayOfWeek.SUNDAY.getValue())
                listWeekends.add(DayOfWeek.of(numberDay));
        }
        return listWeekends;
    }

    private DayOfWeek getStartDay(String s) {
        return DayOfWeek.of(parseInt(s));
    }

    private LocalDate getDate(String s) {
        String[] array = s.split("-");
        return LocalDate.of(parseInt(array[0]), parseInt(array[1]), parseInt(array[2]));
    }
}
