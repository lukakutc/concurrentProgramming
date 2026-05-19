package TPFinal.atracciones.atraccion4;

public class Visitante implements Runnable {
    ControlTren c;
    String nombre = "visitante";
    
    public Visitante(ControlTren c) {
        this.c = c;
    }

    public void run(){
        c.esperarTren(this);
        c.subirTren(this);
        try {
            Thread.sleep(2500);
            c.terminarSubir();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public String getNombre(){
        return nombre;
    }
}
