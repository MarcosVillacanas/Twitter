package torneobot;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import twitter4j.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Twitter {

    private static class MyTimeTask extends TimerTask{

    @Override
    public void run(){
        twitter4j.Twitter twitter = TwitterFactory.getSingleton();
        String latestStatus="Esto mola mucho jeje.";
        Status status = twitter.updateStatus(latestStatus);
        System.out.println("Successfully updated the status to [" + status.getText() + "].");
    }
}
    public static void main(String[] args) throws TwitterException, ParseException{

    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = dateFormatter .parse("2019-07-09 12:39:30");

    //Now create the time and schedule it
    Timer timer = new Timer();

    int period = 1000;//1secs
    timer.schedule(new MyTimeTask(), date, period );
    }
}
/*
public class Twitter {
      
    File file=new File("D:\\Pictures\\Guess The Movie!\\Coldwar.png");
    StatusUpdate img=new StatusUpdate("Probando");
    img.setMedia(file);

    File mirai=new File("D:\\Downloads\\Mirai, mi pequenÌƒa hermana Trailer espanÌƒol HD.mp4");
    StatusUpdate vid=new StatusUpdate("Mirai no Mirai 2.");
    vid.setMedia(mirai);

    twitter4j.Twitter twitter = TwitterFactory.getSingleton();
    String latestStatus="Esto mola mucho jeje.";
    Status status = twitter.updateStatus(latestStatus);
    System.out.println("Successfully updated the status to [" + status.getText() + "].");

        
}*/
