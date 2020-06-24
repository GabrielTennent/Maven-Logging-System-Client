package nz.ac.vuw.swen301.a2.client;

import org.apache.log4j.Category;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LocationInfo;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.ThrowableInformation;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class CreateRandomLogs {

//    public static void main(String [] args) throws Exception{
//      CreateRandomLogs randomLogGenerator = new CreateRandomLogs();
//      randomLogGenerator.generateRandomLogs();
//    }

    public CreateRandomLogs(){
    }

    public void generateRandomLogs() throws InterruptedException {
        Resthome4LogsAppender appender = new Resthome4LogsAppender();
        while(true){
            try {
                Category logger = null;
                LoggingEvent log = new LoggingEvent("foo", logger, 100, Level.ALL,
                        "placeholder", "main", new ThrowableInformation(new Throwable()), "",
                        new LocationInfo(new Throwable(), ""), new HashMap<String, Object>());
                Thread.sleep(1000);
                appender.append(log);
            } catch (InterruptedException x){
                x.printStackTrace();
            }
        }

    }



}
