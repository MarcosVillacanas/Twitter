package torneobot;

import java.util.ArrayList;

public class Sorteo {

    public Partido[] sorteo (ArrayList<Equipo> listaEquipos, int ronda) {
        Equipo[] listaEquiposOrdenados = new Equipo[ronda];
        for (int i = 0; i < ronda; i++) {
            listaEquiposOrdenados[i] = new Equipo ("none", 0);   
        }
        while (!listaEquipos.isEmpty()) {
            int random = (int) (Math.random() * ronda);
            if (random < ronda && listaEquiposOrdenados[random].getNombre().equals("none")) {
                listaEquiposOrdenados[random] = listaEquipos.get(0);
                listaEquipos.remove(0);
            }
        }
        Partido[] listaPartidos = new Partido[ronda/2];
        for (int i = 0; i < ronda/2; i++) {
            listaPartidos[i] = new Partido (listaEquiposOrdenados[i*2],listaEquiposOrdenados[i*2 +1],new Equipo ("none", 0), "none", "none");  
        }
        return listaPartidos;
    }    
}
