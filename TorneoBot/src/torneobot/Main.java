package torneobot;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        
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
