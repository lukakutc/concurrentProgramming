package tp8.ejParcial2024locks;

public class NoResidente implements Runnable {
    private Parque p;
    private String nombre;

    
    public NoResidente(Parque p, String nombre) {
        this.p = p;
        this.nombre = nombre;
    }


    public void run(){
        p.entrarNoResidente(nombre);
        try {
            Thread.sleep((int)(Math.random()*1000));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        p.salirNoResidene(nombre);
    }
    
}
