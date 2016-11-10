import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by employee on 11/9/16.
 */
public class Server {

    private String htmlHeader = "<!DOCTYPE html>\n" +
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

    public static void main(String[] args) throws IOException, InterruptedException {
        new Server().run();
    }

    private void run() throws IOException, InterruptedException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("server is running");

        String htmlFooter = "</body>\n" +
                "</html>";
        while (true) {
            Socket socket = server.accept();
            StringBuilder builder = new StringBuilder();
            builder.append(htmlHeader);

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            builder.append(new HtmlBody(getFullPath(reader)).getBody());

            builder.append(htmlFooter);
            socket.getOutputStream().write(builder.toString().getBytes("UTF-8"));
            reader.close();
        }
    }

    private static String getFullPath(BufferedReader reader) throws IOException {
        return reader.readLine().split(" ")[1];
    }


}
