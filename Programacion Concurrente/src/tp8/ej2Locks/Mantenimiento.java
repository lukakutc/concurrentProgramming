package tp8.ej2Locks;

public class Mantenimiento implements Runnable {
    private String nombre;
    private Observatorio o;
    public Mantenimiento(String nombre, Observatorio o) {
        this.nombre = nombre;
        this.o = o;
    }
    public void run(){
        o.entrarMantenimiento(nombre);
        try {
            Thread.sleep((int)(Math.random()*1000));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        o.salirMantenimiento(nombre);
    }
    
}
