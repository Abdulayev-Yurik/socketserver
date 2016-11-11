import org.junit.Test;
import server.HttpRequest;
import server.Parser;
import server.impl.ParserImpl;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

/**
 * Created by employee on 11/11/16.
 */
public class ParserImplTest {

    private Parser parser = new ParserImpl();
    private HttpRequest httpRequest;

    @Test
    public void getPath(){
        String rawRequest = "GET /calendar/?date=&custom_week=&weekends= 123456";
        httpRequest = new ParserImpl()
                .parse(new ByteArrayInputStream(rawRequest.getBytes(StandardCharsets.UTF_8)));

        assertThat("/calendar", is(httpRequest.getPath()));
    }

    @Test
    public void getParams(){
        String url = "GET /greeter/?name=Yurik 123456";
        httpRequest = parser.parse(new ByteArrayInputStream(url.getBytes(StandardCharsets.UTF_8)));
        Map<String, String> params = new HashMap<>();
        params.put("name", "Yurik");
        assertThat(params.keySet() , is(httpRequest.getParameters().keySet()));
        assertThat(Arrays.asList("name", "names"), not(is(httpRequest.getParameters().keySet())));

        assertThat("Yurik", is(httpRequest.getParameters().get("name")));
        assertThat("Yurik", not(is(httpRequest.getParameters().get("day"))));
    }


}
