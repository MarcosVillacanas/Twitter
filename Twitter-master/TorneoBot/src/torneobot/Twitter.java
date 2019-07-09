package torneobot;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import twitter4j.*;
import java.text.SimpleDateFormat;
import java.util.*;



public class Twitter  {

    public static Juego j;
    public static Equipo ganador;
    
    private static class MyTimeTask extends TimerTask{
        
        
        @Override
        public void run(){
            int i=0;
            
            String latestStatus=" ";
            try{
                twitter4j.Twitter twitter = TwitterFactory.getSingleton();
                if(!((j.getTweetsIda().isEmpty())||(j.getTweetsVuelta().isEmpty()))){
                    if ((i % 2)== 0) {
                        latestStatus = j.getTweetsIda().get(0); 
                        j.getTweetsIda().remove(0);
                        i++;
                    } else {
                        latestStatus = j.getTweetsVuelta().get(0);
                        j.getTweetsVuelta().remove(0);
                        i++;
                    }  
                }else{
                    latestStatus= ("Y el ganador es: "+ganador.getNombre()+" que anotó "+ganador.getGoles()+ " goles");
                }
                
                
                Status status = twitter.updateStatus(latestStatus);
                System.out.println("Successfully updated the status to [" + status.getText() + "].");
                


            }catch( TwitterException e){
                System.out.println("No ha podido ser");
            }

        }
}
    public static void Twittear(Juego jaux,Equipo ganadoraux) throws TwitterException, ParseException{
    j = jaux;
    ganador = ganadoraux;
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = dateFormatter .parse("2019-07-09 14:17:00");

    //Now create the time and schedule it
    Timer timer = new Timer();

    int period = 10000;//30secs
    timer.schedule(new MyTimeTask(), date, period);
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
RealMadrid
Barcelona
AtleticodeMadrid
Getafe
Arsenal
Valencia
Chelsea
ManchesterUnited
ManchesterCity
Juventus
Milan
BorussiaDortmund
Monaco
Sevilla
PSG
Murcia
*/