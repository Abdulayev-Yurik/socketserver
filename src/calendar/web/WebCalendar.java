package calendar.web;

import calendar.interfaces.Calendar;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yurik on 05.11.16.
 */
public class WebCalendar extends Calendar {

    public WebCalendar() {
        this(LocalDate.now());
    }

    public WebCalendar(LocalDate thisDate) {
        this(thisDate, DayOfWeek.MONDAY);
    }

    public WebCalendar(LocalDate thisDate, DayOfWeek startWeek){
        this(thisDate, startWeek, Arrays.asList(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY));
    }

    public WebCalendar(LocalDate thisDate, DayOfWeek startWeek, List<DayOfWeek> weekend) {
        innit(thisDate, startWeek, weekend);
    }

    public void print() {
        generateView();
    }

    public void generateView() {
        try (PrintWriter writer = new PrintWriter("calendar.html")) {
            writer.println("<tr>" + getCurrentMonthHeader() + "</tr>");
            writer.println(getHTMLHeader());
            writer.println(getWeekNames());
            writer.println(getMonthValues());
            writer.println(getHTMLFooter());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getMonthValues() {
        StringBuilder days = new StringBuilder();
        days.append("<tr>\n");
        days.append(getPreviousMonthDays(WEB_VIEW));
        days.append(getCurrentMonthValues(WEB_VIEW));
        days.append(getNextMonthDays(WEB_VIEW));
        days.append("</tr>");
        return days.toString();
    }

    public String getWeekNames() {
        StringBuilder builder = new StringBuilder();
        builder.append("<tr>\n\t");
        for (DayOfWeek dayOfWeek : getWeekdays(getStartWeekValue())) {
            String dayName = getFormattedDay(getDayValue(dayOfWeek));
            builder.append(isWeekend(dayOfWeek) ?
                    toWeekendColor(dayName, WEB_VIEW) : "<td>" + dayName + "</td>")
                    .append("\n")
                    .append("\t");
        }
        builder.append("\n</tr>\n");
        return builder.toString();
    }

    private String getHTMLFooter() {
        return "</table>\n" +
                "</body>\n" +
                "</html>";
    }

    private String getHTMLHeader() {
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <style>\n" +
                "        td.weekend{\n" +
                "            color: red;\n" +
                "        }\n" +
                "        td.currentDay{\n" +
                "            color: cyan;\n" +
                "        }\n" +
                "        td.anotherMonthColor{\n" +
                "            color: orange;\n" +
                "        }\n" +
                "        td{\n" +
                "            padding:5px;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<table>";
    }
}
