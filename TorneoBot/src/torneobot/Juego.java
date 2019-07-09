package torneobot;

import java.util.ArrayList;

public class Juego {
    private int max_goles = 5;
    private String [] rondas = {"","","final","","de semifinales","","","","de cuartos","","","","","","","","de octavos"};
    private String nuevoTweetVuelta = "";
    
    public ArrayList<String> tweetsIda = new ArrayList<>();
    public ArrayList<String> tweetsVuelta = new ArrayList<>();

    public ArrayList<String> getTweetsIda() {
        return tweetsIda;
    }

    public void setTweetsIda(ArrayList<String> tweetsIda) {
        this.tweetsIda = tweetsIda;
    }

    public ArrayList<String> getTweetsVuelta() {
        return tweetsVuelta;
    }

    public void setTweetsVuelta(ArrayList<String> tweetsVuelta) {
        this.tweetsVuelta = tweetsVuelta;
    }
    
    
    
    private Equipo quiengana (Partido p, String nuevoTweet){
        int gol_local_ida = Integer.parseInt(p.getIda().substring(0, p.getIda().indexOf(".")));
        int gol_visitante_ida = Integer.parseInt(p.getIda().substring(p.getIda().indexOf(".")+1));
        int gol_local_vuelta = Integer.parseInt(p.getVuelta().substring(p.getVuelta().indexOf(".")+1));
        int gol_visitante_vuelta = Integer.parseInt(p.getVuelta().substring(0, p.getVuelta().indexOf(".")));
        
        if (gol_local_ida + gol_local_vuelta > gol_visitante_ida + gol_visitante_vuelta){
            nuevoTweetVuelta += "\n";
            nuevoTweetVuelta += (p.getLocal().getNombre()+" gana la eliminatoria por un total de "+(gol_local_ida+gol_local_vuelta)+" - "+(gol_visitante_ida+gol_visitante_vuelta));
            nuevoTweetVuelta += "\n";
            nuevoTweetVuelta += (p.getVisitante().getNombre()+" es eliminado habiendo anotado "+p.getVisitante().getGoles()+" goles");
            return p.getLocal();
        }    
        if (gol_local_ida + gol_local_vuelta < gol_visitante_ida + gol_visitante_vuelta){
            nuevoTweetVuelta += "\n";
            nuevoTweetVuelta += (p.getVisitante().getNombre()+" gana la eliminatoria por un total de "+(gol_visitante_ida+gol_visitante_vuelta)+" - "+(gol_local_ida+gol_local_vuelta));
            nuevoTweetVuelta += "\n";
            nuevoTweetVuelta += (p.getLocal().getNombre()+" es eliminado habiendo anotado "+p.getLocal().getGoles()+" goles");
            return p.getVisitante();
        }    
        if (gol_local_vuelta > gol_visitante_ida ){
            nuevoTweetVuelta += "\n";
            nuevoTweetVuelta += (p.getLocal().getNombre()+" gana la eliminatoria por el valor doble de los goles fuera de casa");
            nuevoTweetVuelta += "\n";
            nuevoTweetVuelta += (p.getVisitante().getNombre()+" es eliminado habiendo anotado "+p.getVisitante().getGoles()+" goles");
            return p.getLocal();
        }    
        if (gol_local_vuelta < gol_visitante_ida ){
            nuevoTweetVuelta += "\n";
            nuevoTweetVuelta += (p.getVisitante().getNombre()+" gana la eliminatoria por el valor doble de los goles fuera de casa");
            nuevoTweetVuelta += "\n";
            nuevoTweetVuelta += (p.getLocal().getNombre()+" es eliminado habiendo anotado "+p.getLocal().getGoles()+" goles");
            return p.getVisitante();
        }    
        if (Math.random() < 0.5){
            nuevoTweetVuelta += "\n";
            nuevoTweetVuelta += ("La eliminatoria entre "+p.getLocal().getNombre()+" y "+p.getVisitante().getNombre()+" se va a penaltis y los gana "+p.getLocal().getNombre());
            nuevoTweetVuelta += "\n";
            nuevoTweetVuelta += (p.getVisitante().getNombre()+" es eliminado habiendo anotado "+p.getVisitante().getGoles()+" goles");
            return p.getLocal();
        }
        else{
            nuevoTweetVuelta += "\n";
            nuevoTweetVuelta += ("La eliminatoria entre "+p.getLocal().getNombre()+" y "+p.getVisitante().getNombre()+" se va a penaltis y los gana "+p.getVisitante().getNombre());
            nuevoTweetVuelta += "\n";
            nuevoTweetVuelta += (p.getLocal().getNombre()+" es eliminado habiendo anotado "+p.getLocal().getGoles()+" goles");
            return p.getVisitante();
        }    
    }
    public Equipo juego (Partido p, int i, int ronda){
        Equipo ganador;
        String nuevoTweetIda = "";
        
        nuevoTweetIda += "Ronda "+rondas[ronda]+": ";
        nuevoTweetIda += ("partido de ida "+ i);
        nuevoTweetIda += "\n";
        int goleslocal = (int) (Math.random() * max_goles);
        int golesvisitante = (int) (Math.random() * max_goles);
        p.getLocal().setGoles(goleslocal + p.getLocal().getGoles());
        p.getVisitante().setGoles(golesvisitante + p.getVisitante().getGoles());
        nuevoTweetIda += (p.getLocal().getNombre() +" "+ goleslocal +" - "+ golesvisitante +" "+ p.getVisitante().getNombre());
        nuevoTweetIda += "\n";
        p.setIda(goleslocal+"."+golesvisitante);
        tweetsIda.add(nuevoTweetIda);

        nuevoTweetVuelta += "Ronda "+rondas[ronda]+": ";
        nuevoTweetVuelta += ("partido de vuelta "+ i);
        nuevoTweetVuelta += "\n";
        golesvisitante = (int) (Math.random() * max_goles);
        goleslocal = (int) (Math.random() * max_goles);
        p.getLocal().setGoles(goleslocal + p.getLocal().getGoles());
        p.getVisitante().setGoles(golesvisitante + p.getVisitante().getGoles());            
        nuevoTweetVuelta += (p.getVisitante().getNombre() +" "+ golesvisitante +" - "+ goleslocal +" "+ p.getLocal().getNombre());
        p.setVuelta(golesvisitante+"."+goleslocal);
        p.setGanador(quiengana(p, nuevoTweetVuelta)); 
        ganador = (p.getGanador());
        tweetsVuelta.add(nuevoTweetVuelta);
        nuevoTweetVuelta = "";
        return ganador;
    }
}
