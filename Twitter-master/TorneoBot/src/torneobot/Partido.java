package torneobot;

public class Partido {
    private Equipo local;
    private Equipo visitante;
    private Equipo ganador;
    private String ida;
    private String vuelta;

    public Equipo getLocal() {
        return local;
    }

    public Equipo getVisitante() {
        return visitante;
    }

    public Equipo getGanador() {
        return ganador;
    }

    public String getIda() {
        return ida;
    }

    public String getVuelta() {
        return vuelta;
    }

    public void setIda(String ida) {
        this.ida = ida;
    }

    public void setGanador(Equipo ganador) {
        this.ganador = ganador;
    }
    
    public void setVuelta(String vuelta) {
        this.vuelta = vuelta;
    }
    
    
    public Partido(Equipo local, Equipo visitante, Equipo ganador, String ida, String vuelta) {
        this.local = local;
        this.visitante = visitante;
        this.ganador = ganador;
        this.ida = ida;
        this.vuelta = vuelta;
    }
    
    
}
