import org.apache.catalina.startup.Tomcat;

/**
 * Created by employee on 11/11/16.
 */
public class TestM {
    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        //actually deploy stuff on your tomcat by defining contexts

        tomcat.start();
        tomcat.getServer().await();
    }
}
