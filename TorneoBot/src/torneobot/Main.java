package torneobot;

import java.util.ArrayList;
import twitter4j.*;

public class Main {

    public static ArrayList<String> tweetsIda = new ArrayList<>();
    public static ArrayList<String> tweetsVuelta = new ArrayList<>();
    
    public static void main(String[] args) throws TwitterException{
        
        /*String latestStatus="Esto mola much jeje.";
        twitter4j.Twitter twitter = TwitterFactory.getSingleton();
        //StatusUpdate str = new StatusUpdate ("Esto mola mucho jeje.");
        Status status = twitter.updateStatus(latestStatus);
        System.out.println("Successfully updated the status to [" + status.getText() + "].");*/
        
        Lector l = new Lector();
        Juego j  = new Juego();  
        Sorteo s = new Sorteo ();
        
        ArrayList<Equipo> listaEquipos = l.generateTeam(new ArrayList<>());
        Partido[] listaPartidos;
        int [] rondas = {16, 8, 4, 2};
        
        for (int ronda : rondas) {
            listaPartidos = s.sorteo(listaEquipos, ronda);  
            listaEquipos = new ArrayList<>();
            for (int i = 1; i <= listaPartidos.length; i++) {
                Equipo ganador = j.juego(listaPartidos[i-1], i, ronda, tweetsIda, tweetsVuelta);
                listaEquipos.add(ganador);
            }   
        }       
        tweetsVuelta.add("Y el ganador es: "+listaEquipos.get(0).getNombre()+" que anotó "+listaEquipos.get(0).getGoles()+ " goles");

    }
    
}
