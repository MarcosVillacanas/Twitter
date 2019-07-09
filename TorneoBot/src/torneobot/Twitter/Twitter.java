package torneobot.Twitter;

import java.io.File;
import twitter4j.*;

public class Twitter {
    
    public static void main(String[] args) throws TwitterException{
        
        /*File file=new File("D:\\Pictures\\Guess The Movie!\\Coldwar.png");
        StatusUpdate img=new StatusUpdate("Probando");
        img.setMedia(file);
        
        File mirai=new File("D:\\Downloads\\Mirai, mi pequenÌƒa hermana Trailer espanÌƒol HD.mp4");
        StatusUpdate vid=new StatusUpdate("Mirai no Mirai 2.");
        vid.setMedia(mirai);*/
        
        twitter4j.Twitter twitter = TwitterFactory.getSingleton();
        String latestStatus="Esto mola mucho jeje.";
        Status status = twitter.updateStatus(latestStatus);
        System.out.println("Successfully updated the status to [" + status.getText() + "].");

        
    }
}
