import app.CalendarImpl;
import app.GreeterImpl;
import app.HomePageImpl;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import server.HttpRequest;
import server.Router;
import server.impl.RouterImpl;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * Created by employee on 11/11/16.
 */
public class RouterImplTest {

    private Router router;

    @Test
    public void equalResponse(){
        router = new RouterImpl();
        router.register("/home", HomePageImpl::new);
        router.register("/calendar", CalendarImpl::new);

        String response = new HomePageImpl(null).print(null);

        assertThat(response, is(router.getResponse(new HttpRequest("/home", null))));
    }

    @Test
    public void equalCustomCalendarResponse(){
        router = new RouterImpl();
        router.register("/calendar", CalendarImpl::new);
        router.register("/greeter", GreeterImpl::new);


        Map<String, String> params = new HashMap<>();
        params.put("date", "2016-04-12");
        params.put("custom_week", "3");
        params.put("weekends", "1,2,3");

        HttpRequest httpRequest = new HttpRequest("/calendar", params);
        String response = new CalendarImpl(httpRequest).print(httpRequest);

        assertThat(response, equalTo(router.getResponse(httpRequest)));
    }
}
