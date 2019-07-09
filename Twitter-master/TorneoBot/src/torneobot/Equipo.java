package torneobot;

public class Equipo {
    private String nombre;
    private int goles;

    public Equipo(String nombre, int goles) {
        this.nombre = nombre;
        this.goles = goles;
    }

    public String getNombre() {
        return nombre;
    }
    
    public int getGoles() {
        return goles;
    }
    
    public void setGoles(int goles) {
        this.goles = goles;
    }

}
