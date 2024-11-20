package recuLocksMon.locks.tp7ej1;

public class Persona implements Runnable{
    private GestorSala sala;
    private String nombre;
    public Persona(GestorSala sala, String nombre) {
        this.sala = sala;
        this.nombre = nombre;
    }
    
    public void run(){
        sala.entrarSala(nombre);
        try {
            Thread.sleep((int) (Math.random()*1000));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        sala.salirSala(nombre);
    }
}
