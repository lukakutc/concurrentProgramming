package tp8.ejParcial2024locks;

public class Residente implements Runnable {
    private String nombre;
    private Parque p;
    
    public Residente(String nombre, Parque p) {
        this.nombre = nombre;
        this.p = p;
    }

    public void run(){
        p.entrarResidente(nombre);
        try {
            Thread.sleep((int)(Math.random()*1000));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        p.salirResidente(nombre);
    }
    
    
}
