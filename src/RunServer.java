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
            "}" +
            "input{margin : 10px; padding : 5px; border-radius : 5px; }" +
            "input.button{}" +
            "</style>" +
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
            try{
                builder.append(new StringParser(reader).parse());
            }catch (NullPointerException e){

            }

            builder.append(footer);
            socket.getOutputStream().write(builder.toString().getBytes("UTF-8"));
            reader.close();
        }
    }


}
