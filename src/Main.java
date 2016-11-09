import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by employee on 11/9/16.
 */
public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        runServer();
    }

    private static void runServer() throws IOException, InterruptedException {
        int requestNumber = 0;

        ServerSocket server = new ServerSocket(8080);
        System.out.println("server is running");
        String header = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<title>Page Title</title>\n" +
                "</head>\n" +
                "<body>" +
                "<div id=\"page\">";

        String footer = "</body>\n" +
                "</html>";

            Socket socket = server.accept();
                requestNumber++;
                String httpResponse = "" + "Hello world! Times: " + requestNumber;
                StringBuilder builder = new StringBuilder();
                builder.append(header);

                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println(reader.readLine().split(" ")[1]);

                builder.append(httpResponse);

                builder.append(footer);
                builder.toString();
                socket.getOutputStream().write(builder.toString().getBytes("UTF-8"));
            reader.close();



    }
}
