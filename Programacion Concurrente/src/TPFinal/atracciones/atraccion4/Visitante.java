package TPFinal.atracciones.atraccion4;

public class Visitante implements Runnable {
    ControlTren c;
    String nombre = "visitante";
    
    public Visitante(ControlTren c) {
        this.c = c;
    }

    public void run(){
        c.esperarTren(this);
    }
    
    public String getNombre(){
        return nombre;
    }
}
