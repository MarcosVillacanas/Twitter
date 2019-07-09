package torneobot;

import java.text.ParseException;
import java.util.ArrayList;
import twitter4j.*;

public class Main {

    public static void main(String[] args) throws TwitterException, ParseException{

        
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
                Equipo ganador = j.juego(listaPartidos[i-1], i, ronda);
                listaEquipos.add(ganador);
            }   
        }       
        torneobot.Twitter.Twittear(j,listaEquipos.get(0));
    }  
}
/*
Real_Madrid
Barcelona
Atletico_de_Madrid
Getafe
Arsenal
Valencia
Chelsea
Manchester_United
Manchester_City
Juventus
Milan
Borussia_Dortmund
Monaco
Sevilla
PSG
Murcia
*/