package nz.ac.vuw.swen301.a2.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class JSONLayout extends Layout {

    //Levels used for random generation of level
    List<String> LEVELS = Arrays.asList("ALL","TRACE","DEBUG","INFO","WARN","ERROR","FATAL","OFF");
    private String id, message, timestamp, thread, logger, errorDetails, level;

    public JSONLayout(){
    }

    //Logging even formatter
    @Override
    public String format(LoggingEvent loggingEvent) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("id", UUID.randomUUID().toString());
        jsonObject.addProperty("message", generateRandomMessage());
        jsonObject.addProperty("timestamp", generateRandomTime());
        jsonObject.addProperty("thread", loggingEvent.getThreadName());
        jsonObject.addProperty("logger", loggingEvent.getLoggerName());
        jsonObject.addProperty("level", generateRandomLevel());
        jsonObject.addProperty("errorDetails", "Error");

        System.out.println("Sending log:\n" + gson.toJson(jsonObject));
        System.out.println("\n");

        return gson.toJson(jsonObject);
    }


    //Random generators
    public String generateRandomLevel(){
        Random random = new Random();
        return LEVELS.get(random.nextInt(LEVELS.size()));
    }

    public String generateRandomTime(){
        List<String> TIMES = Arrays.asList("2021-07-29T09:04:20.001Z",
                "2018-02-23T09:19:33.001Z","2014-06-28T09:16:33.001Z");
        Random random = new Random();
        return TIMES.get(random.nextInt(TIMES.size()));
    }

    public String generateRandomMessage(){
        int size = 10;
        byte[] array = new byte[size];
        new Random().nextBytes(array);
        return new String(array, StandardCharsets.US_ASCII);
    }

    @Override
    public boolean ignoresThrowable() {
        return false;
    }

    @Override
    public void activateOptions() {

    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getThread() {
        return thread;
    }

    public void setThread(String thread) {
        this.thread = thread;
    }

    public String getLogger() {
        return logger;
    }

    public void setLogger(String logger) {
        this.logger = logger;
    }

    public String getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(String errorDetails) {
        this.errorDetails = errorDetails;
    }


}