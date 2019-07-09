package torneobot;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import twitter4j.*;
import java.text.SimpleDateFormat;
import java.util.*;
import static torneobot.Main.tweetsIda;

public class Twitter {

    private static class MyTimeTask extends TimerTask{
        public static int i=0;

        @Override
        public void run(){
            try{
                twitter4j.Twitter twitter = TwitterFactory.getSingleton();
                String latestStatus= Integer.toString(i);
                Status status = twitter.updateStatus(latestStatus);
                System.out.println("Successfully updated the status to [" + status.getText() + "].");
                i++;


            }catch( TwitterException e){
                System.out.println("No ha podido ser");
            }

        }
}
    public static void Twittear() throws TwitterException, ParseException{

    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = dateFormatter .parse("2019-07-09 13:09:30");

    //Now create the time and schedule it
    Timer timer = new Timer();

    int period = 30000;//30secs
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
/*
a
s
d
f
g
h
j
k
l
ñ
z
x
c
v
b
n
*/