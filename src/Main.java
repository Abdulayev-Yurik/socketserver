import app.CalendarImpl;
import app.GreeterImpl;
import app.HomePageImpl;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import server.WebServer;
import server.Parser;
import server.Router;
import server.impl.ParserImpl;
import server.impl.RouterImpl;

import javax.servlet.ServletException;
import java.io.File;
import java.io.IOException;

/**
 * Created by employee on 11/10/16.
 */
public class Main {

    public static void main(String[] args) throws IOException, ServletException, LifecycleException {
//        Parser parser = new ParserImpl();
//        Router router = new RouterImpl();
//        WebServer server = new WebServer(8080, parser, router);
//
//        router.register("/greeter", GreeterImpl::new);
//        router.register("/home", HomePageImpl::new);
//        router.register("/calendar", CalendarImpl::new);
//
//        server.start();
        new Main().innit();
    }

    public void innit() throws ServletException, LifecycleException {
        String webappDirLocation = "src";
        Tomcat tomcat = new Tomcat();

        //The port that we should run on can be set into an environment variable
        //Look for that variable and default to 8080 if it isn't there.
        String webPort = System.getenv("PORT");
        if(webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }

        tomcat.setPort(Integer.valueOf(webPort));

        StandardContext ctx = (StandardContext) tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
//        System.out.println("configuring app with basedir: " + new File("./" + webappDirLocation).getAbsolutePath());

        // Declare an alternative location for your "WEB-INF/classes" dir
        // Servlet 3.0 annotation will work
        File additionWebInfClasses = new File("src");
        WebResourceRoot resources = new StandardRoot(ctx);
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",
                additionWebInfClasses.getAbsolutePath(), "/"));
        ctx.setResources(resources);

        tomcat.start();
        tomcat.getServer().await();
    }
}
