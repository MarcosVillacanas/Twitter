package torneobot;

import java.util.ArrayList;

public class Juego {
    private int max_goles = 5;
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
            nuevoTweet += (p.getLocal().getNombre()+" gana la eliminatoria por un total de "+(gol_local_ida+gol_local_vuelta)+" - "+(gol_visitante_ida+gol_visitante_vuelta));
            nuevoTweet += "\n";
            nuevoTweet += (p.getVisitante().getNombre()+" es eliminado habiendo anotado "+p.getVisitante().getGoles()+" goles");
            nuevoTweet += "\n";
            return p.getLocal();
        }    
        if (gol_local_ida + gol_local_vuelta < gol_visitante_ida + gol_visitante_vuelta){
            nuevoTweet += (p.getVisitante().getNombre()+" gana la eliminatoria por un total de "+(gol_visitante_ida+gol_visitante_vuelta)+" - "+(gol_local_ida+gol_local_vuelta));
            nuevoTweet += "\n";
            nuevoTweet += (p.getLocal().getNombre()+" es eliminado habiendo anotado "+p.getLocal().getGoles()+" goles");
            nuevoTweet += "\n";
            return p.getVisitante();
        }    
        if (gol_local_vuelta > gol_visitante_ida ){
            nuevoTweet += (p.getLocal().getNombre()+" gana la eliminatoria por el valor doble de los goles fuera de casa");
            nuevoTweet += "\n";
            nuevoTweet += (p.getVisitante().getNombre()+" es eliminado habiendo anotado "+p.getVisitante().getGoles()+" goles");
            nuevoTweet += "\n";
            return p.getLocal();
        }    
        if (gol_local_vuelta < gol_visitante_ida ){
            nuevoTweet += (p.getVisitante().getNombre()+" gana la eliminatoria por el valor doble de los goles fuera de casa");
            nuevoTweet += "\n";
            nuevoTweet += (p.getLocal().getNombre()+" es eliminado habiendo anotado "+p.getLocal().getGoles()+" goles");
            nuevoTweet += "\n";
            return p.getVisitante();
        }    
        if (Math.random() < 0.5){
            nuevoTweet += ("La eliminatoria entre "+p.getLocal().getNombre()+" y "+p.getVisitante().getNombre()+" se va a penaltis y los gana "+p.getLocal().getNombre());
            nuevoTweet += "\n";
            nuevoTweet += (p.getVisitante().getNombre()+" es eliminado habiendo anotado "+p.getVisitante().getGoles()+" goles");
            nuevoTweet += "\n";
            return p.getLocal();
        }
        else{
            nuevoTweet += ("La eliminatoria entre "+p.getLocal().getNombre()+" y "+p.getVisitante().getNombre()+" se va a penaltis y los gana "+p.getVisitante().getNombre());
            nuevoTweet += "\n";
            nuevoTweet += (p.getLocal().getNombre()+" es eliminado habiendo anotado "+p.getLocal().getGoles()+" goles");
            nuevoTweet += "\n";
            return p.getVisitante();
        }    
    }
    public Equipo juego (Partido p, int i, int ronda){
        Equipo ganador;
        String nuevoTweetIda = "";
        String nuevoTweetVuelta = "";
        
        nuevoTweetIda += "Ronda de "+ronda+": ";
        nuevoTweetIda += ("Partido de ida "+ i +", "+ p.getLocal().getNombre() +" VS "+ p.getVisitante().getNombre());
        nuevoTweetIda += "\n";
        int goleslocal = (int) (Math.random() * max_goles);
        int golesvisitante = (int) (Math.random() * max_goles);
        p.getLocal().setGoles(goleslocal + p.getLocal().getGoles());
        p.getVisitante().setGoles(golesvisitante + p.getVisitante().getGoles());
        nuevoTweetIda += (p.getLocal().getNombre() +" "+ goleslocal +" - "+ golesvisitante +" "+ p.getVisitante().getNombre());
        nuevoTweetIda += "\n";
        p.setIda(goleslocal+"."+golesvisitante);
        tweetsIda.add(nuevoTweetIda);

        nuevoTweetVuelta += "Ronda de "+ronda+": ";
        nuevoTweetVuelta += ("Partido de vuelta "+ i +", "+ p.getVisitante().getNombre() +" VS "+ p.getLocal().getNombre());
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
        return ganador;
    }
}
