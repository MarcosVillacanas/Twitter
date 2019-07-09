package torneobot;

import java.util.ArrayList;
import twitter4j.*;

public class Main {

    public static void main(String[] args) throws TwitterException{
        
        String latestStatus="Esto mola much jeje.";
        twitter4j.Twitter twitter = TwitterFactory.getSingleton();
        //StatusUpdate str = new StatusUpdate ("Esto mola mucho jeje.");
        Status status = twitter.updateStatus(latestStatus);
        System.out.println("Successfully updated the status to [" + status.getText() + "].");

        
        Lector l = new Lector();
        Juego j  = new Juego();  
        Sorteo s = new Sorteo ();
        
        ArrayList<Equipo> listaEquipos = l.generateTeam(new ArrayList<>());
        Partido[] listaPartidos;
        int [] rondas = {16, 8, 4, 2};
        
        for (int ronda : rondas) {
            listaPartidos = s.sorteo(listaEquipos, ronda);       
            System.out.println("Ronda de "+ronda+": ");
            listaEquipos = j.juego(listaPartidos);
            System.out.println("");
            System.out.println("");
            System.out.println("");      
            System.out.println("");
        }
        
        System.out.println("Y el ganador es: "+listaEquipos.get(0).getNombre()+" que anotó "+listaEquipos.get(0).getGoles()+ " goles");

    }
    
}
