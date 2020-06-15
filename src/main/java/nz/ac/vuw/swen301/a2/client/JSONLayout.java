package nz.ac.vuw.swen301.a2.client;

//Packages for formatting JSON
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//
import org.apache.log4j.Layout;
import org.apache.log4j.spi.LoggingEvent;

//Hashmap for keystorage
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class JSONLayout extends Layout {

    private String id, message, timestamp, thread, logger, level, errorDetails;

    public JSONLayout() {
    }


    @Override
    public String format(LoggingEvent loggingEvent) {
        //Storing the log information into hashmap
        Map<String, String> logs = new HashMap<>();

        //Logging information into hashmap
        logs.put("id", UUID.randomUUID().toString());
        logs.put("message", loggingEvent.getRenderedMessage());
        logs.put("timestamp",Long.toString(loggingEvent.timeStamp));
        logs.put("thread", loggingEvent.getThreadName());
        logs.put("logger",loggingEvent.getLoggerName());
        logs.put("level",loggingEvent.getLevel().toString());
        logs.put("errorDetails", "string");

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        return gson.toJson(logs); //Returning converted hashmap into JSON string
    }

    @Override
    public boolean ignoresThrowable() {
        return false;
    }

    @Override
    public void activateOptions() {

    }
}



