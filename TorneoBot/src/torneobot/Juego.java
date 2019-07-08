package torneobot;

import java.util.ArrayList;

public class Juego {
    private int max_goles = 5;
    
    private Equipo quiengana (Partido p){
        int gol_local_ida = Integer.parseInt(p.getIda().substring(0, p.getIda().indexOf(".")));
        int gol_visitante_ida = Integer.parseInt(p.getIda().substring(p.getIda().indexOf(".")+1));
        int gol_local_vuelta = Integer.parseInt(p.getVuelta().substring(p.getVuelta().indexOf(".")+1));
        int gol_visitante_vuelta = Integer.parseInt(p.getVuelta().substring(0, p.getVuelta().indexOf(".")));
        
        if (gol_local_ida + gol_local_vuelta > gol_visitante_ida + gol_visitante_vuelta){
            System.out.println(p.getLocal().getNombre()+" gana la eliminatoria por un total de "+(gol_local_ida+gol_local_vuelta)+" - "+(gol_visitante_ida+gol_visitante_vuelta));
            System.out.println(p.getVisitante().getNombre()+" es eliminado habiendo anotado "+p.getVisitante().getGoles()+" goles");
            System.out.println("");
            return p.getLocal();
        }    
        if (gol_local_ida + gol_local_vuelta < gol_visitante_ida + gol_visitante_vuelta){
            System.out.println(p.getVisitante().getNombre()+" gana la eliminatoria por un total de "+(gol_visitante_ida+gol_visitante_vuelta)+" - "+(gol_local_ida+gol_local_vuelta));
            System.out.println(p.getLocal().getNombre()+" es eliminado habiendo anotado "+p.getLocal().getGoles()+" goles");
            System.out.println("");
            return p.getVisitante();
        }    
        if (gol_local_vuelta > gol_visitante_ida ){
            System.out.println(p.getLocal().getNombre()+" gana la eliminatoria por el valor doble de los goles fuera de casa");
            System.out.println(p.getVisitante().getNombre()+" es eliminado habiendo anotado "+p.getVisitante().getGoles()+" goles");
            System.out.println("");
            return p.getLocal();
        }    
        if (gol_local_vuelta < gol_visitante_ida ){
            System.out.println(p.getVisitante().getNombre()+" gana la eliminatoria por el valor doble de los goles fuera de casa");
            System.out.println(p.getLocal().getNombre()+" es eliminado habiendo anotado "+p.getLocal().getGoles()+" goles");
            System.out.println("");
            return p.getVisitante();
        }    
        if (Math.random() < 0.5){
            System.out.println("La eliminatoria entre "+p.getLocal().getNombre()+" y "+p.getVisitante().getNombre()+" se va a penaltis y los gana "+p.getLocal().getNombre());
            System.out.println(p.getVisitante().getNombre()+" es eliminado habiendo anotado "+p.getVisitante().getGoles()+" goles");
            System.out.println("");
            return p.getLocal();
        }
        else{
            System.out.println("La eliminatoria entre "+p.getLocal().getNombre()+" y "+p.getVisitante().getNombre()+" se va a penaltis y los gana "+p.getVisitante().getNombre());
            System.out.println(p.getLocal().getNombre()+" es eliminado habiendo anotado "+p.getLocal().getGoles()+" goles");
            System.out.println("");
            return p.getVisitante();
        }    
    }
    public ArrayList<Equipo> juego (Partido[] listaPartidos){
        ArrayList<Equipo> ganadores = new ArrayList<>();
        
        for (int i = 1; i <= listaPartidos.length; i++) {
            System.out.println("Partido de ida "+ i +", "+ listaPartidos[i-1].getLocal().getNombre() +" VS "+ listaPartidos[i-1].getVisitante().getNombre());
            int goleslocal = (int) (Math.random() * max_goles);
            int golesvisitante = (int) (Math.random() * max_goles);
            listaPartidos[i-1].getLocal().setGoles(goleslocal + listaPartidos[i-1].getLocal().getGoles());
            listaPartidos[i-1].getVisitante().setGoles(golesvisitante + listaPartidos[i-1].getVisitante().getGoles());
            System.out.println(listaPartidos[i-1].getLocal().getNombre() +" "+ goleslocal +" - "+ golesvisitante +" "+ listaPartidos[i-1].getVisitante().getNombre());
            System.out.println("");
            listaPartidos[i-1].setIda(goleslocal+"."+golesvisitante);
        }
        System.out.println("------------------------------------------");
        for (int i = 1; i <= listaPartidos.length; i++) {
            System.out.println("Partido de vuelta "+ i +", "+ listaPartidos[i-1].getVisitante().getNombre() +" VS "+ listaPartidos[i-1].getLocal().getNombre());
            int golesvisitante = (int) (Math.random() * max_goles);
            int goleslocal = (int) (Math.random() * max_goles);
            listaPartidos[i-1].getLocal().setGoles(goleslocal + listaPartidos[i-1].getLocal().getGoles());
            listaPartidos[i-1].getVisitante().setGoles(golesvisitante + listaPartidos[i-1].getVisitante().getGoles());            
            System.out.println(listaPartidos[i-1].getVisitante().getNombre() +" "+ golesvisitante +" - "+ goleslocal +" "+ listaPartidos[i-1].getLocal().getNombre());
            listaPartidos[i-1].setVuelta(golesvisitante+"."+goleslocal);
            listaPartidos[i-1].setGanador(quiengana(listaPartidos[i-1])); 
            ganadores.add(listaPartidos[i-1].getGanador());
        }
        return ganadores;
    }
}
