package recuLocksMon.hamsters.platoYRueda;

public class Hamster implements Runnable {
    private Plato plato;
    private String nombre;

    public Hamster(Plato plato, String nombre) {
        this.plato = plato;
        this.nombre = nombre;
    }

    public void run(){
        plato.empezarComer(nombre);
        comiendo();
        plato.terminarComer(nombre);
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
}
