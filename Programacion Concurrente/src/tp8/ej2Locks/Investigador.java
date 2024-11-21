package tp8.ej2Locks;

public class Investigador implements Runnable {
    private String nombre;
    private Observatorio o;
    public Investigador(String nombre, Observatorio o) {
        this.nombre = nombre;
        this.o = o;
    }

    public void run(){
        o.entrarInvestigador(nombre);
        try {
            Thread.sleep((int)(Math.random()*1000));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        o.salirInvestigador(nombre);
    }
    
}
