import calendar.interfaces.Calendar;
import calendar.web.WebCalendar;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by employee on 11/10/16.
 */
public class CalendarParser {

    private String parameters;

    public CalendarParser(String parameters) {
        this.parameters = parameters;
    }


    public String parse() {
//        String uri = "https://google.com.ua/oauth/authorize?client_id=SS&response_type=code&scope=N_FULL&access_type=offline&redirect_uri=http://localhost/Callback";
//        String uri = "http://greater.local:8080";
//        try {
//            System.out.println(splitQuery(new URL(uri).getQuery()).keySet());
//            System.out.println(uri + parameters);
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        return getCalendar();
    }

    private String getCalendar() {
        Calendar calendar = new WebCalendar();
        return new StringBuilder()
                .append("<table>")
                .append("<tr><a href=\"/\">Back</a></tr><br>")
                .append(calendar.getCurrentMonthHeader())
                .append(calendar.getWeekNames())
                .append(calendar.getMonthValues())
                .append("</table>").toString();
    }

    private Map<String, String> splitQuery(String query) throws NullPointerException, UnsupportedEncodingException {
        Map<String, String> query_pairs = new LinkedHashMap<>();
        String[] pairs = query.split("&");
        for (String pair : pairs) {
            int idx = pair.indexOf("=");
            query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"), URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
        }
        return query_pairs;
    }
}
