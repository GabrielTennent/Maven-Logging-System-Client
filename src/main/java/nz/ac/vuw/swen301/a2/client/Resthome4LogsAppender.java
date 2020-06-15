package nz.ac.vuw.swen301.a2.client;

import com.sun.javafx.util.Logging;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Resthome4LogsAppender extends AppenderSkeleton{

    private URIBuilder logServiceURL = new URIBuilder();

    public static void main(String [] args) throws Exception{
        Resthome4LogsAppender logger = new Resthome4LogsAppender();

        //LoggingEvent log = new LoggingEvent();
    }

    public Resthome4LogsAppender() {
        this.logServiceURL.setScheme("http")
                .setHost("localhost")
                .setPath("resthome4logs/logs")
                .setPort(8080)
                .setParameter("number", "3");


    }

    @Override
    protected void append(LoggingEvent loggingEvent) {
        try {
            URI uri = logServiceURL.build();

            // create and execute the request
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(uri);
            HttpResponse response = httpClient.execute(request);
            assert response.getStatusLine().getStatusCode() == 200;
        } catch (Exception x){
            x.printStackTrace();
            return;
        }
        //Uses do post to store on the server
    }

    @Override
    public void close() {

    }

    @Override
    public boolean requiresLayout() {
        return false;
    }
}
