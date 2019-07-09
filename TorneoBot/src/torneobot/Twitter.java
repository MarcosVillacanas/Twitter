package torneobot;

import java.text.DateFormat;
import java.text.ParseException;
import twitter4j.*;
import java.text.SimpleDateFormat;
import java.util.*;



public class Twitter  {

    public static ArrayList<String> tweets;

    private static ArrayList<String> ordenartweets(ArrayList<String> tweetsIda, ArrayList<String> tweetsVuelta, Equipo ganador) {
        ArrayList<String> ordenados = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            ordenados.add(tweetsIda.get(i));      
        }
        for (int i = 0; i < 8; i++) {
            ordenados.add(tweetsVuelta.get(i));      
        }
        for (int i = 8; i < 12; i++) {
            ordenados.add(tweetsIda.get(i));      
        }
        for (int i = 8; i < 12; i++) {
            ordenados.add(tweetsVuelta.get(i));      
        }
        for (int i = 12; i < 14; i++) {
            ordenados.add(tweetsIda.get(i));      
        }
        for (int i = 12; i < 14; i++) {
            ordenados.add(tweetsVuelta.get(i));      
        }
        ordenados.add(tweetsIda.get(14));
        ordenados.add(tweetsVuelta.get(14));
        ordenados.add("Y el ganador es: "+ganador.getNombre()+" que anotó "+ganador.getGoles()+ " goles");
        return ordenados;
    }
    
    public static void Twittear(Juego j, Equipo ganador) throws TwitterException, ParseException{
        tweets = ordenartweets (j.getTweetsIda(),j.getTweetsVuelta(), ganador);
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = dateFormatter .parse("2019-07-09 16:43:00");

        //Now create the time and schedule it
        Timer timer = new Timer();

        int period = 10000;//10secs
        timer.schedule(new MyTimeTask(), date, period);
    }
    
    private static class MyTimeTask extends TimerTask{
        
        @Override
        public void run(){
            
            String latestStatus = ";)";
            try{
                twitter4j.Twitter twitter = TwitterFactory.getSingleton();
                if(!tweets.isEmpty()){
                    latestStatus = tweets.get(0); 
                    tweets.remove(0);
                }              
                Status status = twitter.updateStatus(latestStatus);
                System.out.println("Successfully updated the status to [" + status.getText() + "].");
            }catch( TwitterException e){
                System.out.println("No ha podido ser");
            }

        }
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
