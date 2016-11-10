import calendar.interfaces.Calendar;
import calendar.web.WebCalendar;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by employee on 11/10/16.
 */
public class HtmlBody
{
    private final String path;

    public HtmlBody(String path) {
        this.path = path;
    }

    public String getBody() {
        if (path.equals("/")) {
            return getView();
        } else {
            return parsePath(path);
        }
    }

    private String parsePath(String parameters) {
        if (parameters.contains("name")) {
            try {
                return parseName(parameters);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else if (parameters.contains("calendar")) {
            return getCalendar();
        }
        return "incorrect parameters";
    }

    private String parseName(String parameters) throws UnsupportedEncodingException {
        int index = parameters.indexOf("=") + 1;
        String result = parameters.substring(index);
        result = result.replaceAll("\\+", " ");
        return ("<tr><a href=\"/\">Back</a></tr><br>") + "Hello " + (result.isEmpty() ? "world" :
                URLDecoder.decode(result , "UTF-8"));
    }

    private String getCalendar() {
        Calendar calendar = new WebCalendar();
        return "<table>" +
                "<tr><a href=\"/\">Back</a></tr><br>" +
                calendar.getCurrentMonthHeader() +
                calendar.getWeekNames() +
                calendar.getMonthValues() +
                "</table>";
    }

    private String getView() {
        return "<input type=\"submit\" value=\"view calendar\" onclick=\"window.location='calendar/';\" /> " +
                "<form action=\"/\">" +
                "<input type=\"text\" name=\"name\" placeholder=\"Enter your name\"/>" +
                "<input type=\"submit\" class=\"button\" value=\"Send\"></form> ";
    }
}
