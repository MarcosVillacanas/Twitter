package torneobot;

import java.util.ArrayList;
import java.util.Scanner;

public class Lector {
    
    public ArrayList<Equipo> generateTeam (ArrayList<Equipo> listaEquipos){            
        System.out.println("Bienvenido al creador de Torneo");
        System.out.println("");
        Scanner sc = new Scanner (System.in);
        System.out.print("Introduce el nombre de los dieciséis equipos: ");
        for (int i = 1; i < 17; i++) {    
            listaEquipos.add(new Equipo(sc.next(), 0));           
        }
        System.out.println("");
        System.out.println("");
        System.out.println("");
        return listaEquipos;
    }  
}
