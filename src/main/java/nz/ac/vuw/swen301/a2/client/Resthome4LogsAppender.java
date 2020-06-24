package nz.ac.vuw.swen301.a2.client;

import com.sun.javafx.util.Logging;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Resthome4LogsAppender extends AppenderSkeleton{

    private static final String logServiceURL = "http://localhost:8080/resthome4logs/logs";
    private static final String SCHEME = "http";
    private static final String HOST = "localhost";
    private static final String PATH = "resthome4logs/logs";
    private static final int PORT = 8080;
    private URIBuilder builder = new URIBuilder();


    public Resthome4LogsAppender() {

        builder.setScheme(SCHEME)
                .setHost(HOST)
                .setPath(PATH)
                .setPort(PORT);
    }

    @Override
    protected void append(LoggingEvent loggingEvent) {
        try {
            URI uri = builder.build();
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(uri);
            HttpResponse response = httpClient.execute(request);
            assert response.getStatusLine().getStatusCode() == 200;
            HttpPost post = new HttpPost(uri);

            JSONLayout jsonLayout = new JSONLayout();
            String string = jsonLayout.format(loggingEvent);
            StringEntity requestEntity = new StringEntity(string, ContentType.APPLICATION_JSON);
            post.setEntity(requestEntity);
            HttpResponse rawResponse = httpClient.execute(post);
        } catch (Exception x){
            x.printStackTrace();
            return;
        }
    }

    @Override
    public void close() {

    }

    @Override
    public boolean requiresLayout() {
        return false;
    }
}
