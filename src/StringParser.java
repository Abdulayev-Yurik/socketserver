import calendar.interfaces.Calendar;
import calendar.web.WebCalendar;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by employee on 11/10/16.
 */
public class StringParser {

    private final BufferedReader reader;

    public StringParser(BufferedReader reader) {
        this.reader = reader;
    }


    public String parse() throws IOException {
        String parameters = reader.readLine().split(" ")[1];
        System.out.println("\"" + parameters + "\"");
        if (parameters.equals("/")) {
            return getView();
        } else {
            return parseLink(parameters);
        }
    }

    private static String parseLink(String parameters) {
        if (parameters.contains("name")) {
            return parseName(parameters);
        } else if (parameters.contains("calendar")) {
            return getCalendar();
        }
        return "incorrect parameters 404";
    }

    private static String parseName(String parameters) {
        int index = parameters.indexOf("=") + 1;
        String result = parameters.substring(index);
        return "Hello " + (result.isEmpty() ? "world" : result);
    }

    private static String getCalendar() {
        Calendar calendar = new WebCalendar();
        return new StringBuilder()
                .append("<table>")
                .append("<tr><a href=\"/\">Back</a></tr><br>")
                .append(calendar.getCurrentMonthHeader())
                .append(calendar.getWeekNames())
                .append(calendar.getMonthValues())
                .append("</table>").toString();
    }

    private static String getView() {
        return "<input type=\"submit\" value=\"view calendar\" onclick=\"window.location='calendar/';\" /> " +
                "<form action=\"/\">" +
                "<input type=\"text\" name=\"name\" placeholder=\"Enter your name\"/>" +
                "<input type=\"submit\" value=\"Send\"></form> ";
    }
}
