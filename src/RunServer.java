import calendar.interfaces.Calendar;
import calendar.web.WebCalendar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by employee on 11/9/16.
 */
public class RunServer {

    private static String header = "<!DOCTYPE html>\n" +
            "<head>\n" +
            "<style>td.weekend {\n" +
            "    color: red;\n" +
            "}\n" +
            "\n" +
            "td.currentDay {\n" +
            "    color: cyan;\n" +
            "}\n" +
            "\n" +
            "td.anotherMonthColor {\n" +
            "    color: orange;\n" +
            "}\n" +
            "\n" +
            "td {\n" +
            "    padding: 5px;\n" +
            "}</style>" +
            "</head>" +
            "<html>\n" +
            "<body>";

    public static void main(String[] args) throws IOException, InterruptedException {
        runServer();
    }

    private static void runServer() throws IOException, InterruptedException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("server is running");




        String footer = "</body>\n" +
                "</html>";
        while (true) {
            Socket socket = server.accept();
            StringBuilder builder = new StringBuilder();
            builder.append(header);

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            reader.lines().forEach(System.out::println);

            String parameters = reader.readLine().split(" ")[1];
            System.out.println("\"" + parameters + "\"");
            if (parameters.equals("/")) {
                builder.append(getView());
            } else {
                builder.append(parseLink(parameters));
            }

            builder.append(footer);
            socket.getOutputStream().write(builder.toString().getBytes("UTF-8"));
            reader.close();
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
        return new StringBuilder().append("<table>").append(calendar.getCurrentMonthHeader())
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
