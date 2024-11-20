package recuLocksMon.hamsters.platoYRueda;

public class Hamster implements Runnable {
    private Plato plato;
    private Rueda rueda;
    private String nombre;


    public Hamster(Plato plato, Rueda rueda, String nombre) {
        this.plato = plato;
        this.nombre = nombre;
        this.rueda = rueda;
    }

    public void run(){
        plato.empezarComer(nombre);
        comiendo();
        plato.terminarComer(nombre);
        rueda.empezarCorrer(nombre);
        corriendo();
        rueda.terminarCorrer(nombre);
    }

    public void comiendo(){
        System.out.println(nombre+"Esta comiendo miam miam");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void corriendo(){
        System.out.println(nombre+" esta corriendo. FIUM");
        try {
            Thread.sleep((int) (Math.random()*1000));
        } catch (InterruptedException e) {
        }
    }
}
