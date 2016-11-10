package server;

/**
 * Created by yurik on 10.11.16.
 */
public class HtmlUtils {

    public static String htmlHeader = "<!DOCTYPE html>\n" +
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
            "}" +
            "input{margin : 10px; padding : 5px; border-radius : 5px; }" +
            "input[type=submit] {\n" +
            "    padding:5px 15px; \n" +
            "    background:#ccc; \n" +
            "    border:0 none;\n" +
            "    cursor:pointer;\n" +
            "    -webkit-border-radius: 5px;\n" +
            "    border-radius: 5px; \n" +
            "}" +
            "</style>" +
            "</head>" +
            "<html>\n" +
            "<body>";

    public static String htmlFooter = "</body>\n" +
            "</html>";
}
