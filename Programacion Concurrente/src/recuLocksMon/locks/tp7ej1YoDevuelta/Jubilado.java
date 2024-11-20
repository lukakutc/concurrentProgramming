package recuLocksMon.locks.tp7ej1YoDevuelta;

public class Jubilado implements Runnable {
    private String nombre;
    private GestorSala sala;
    
    public Jubilado(String nombre, GestorSala sala) {
        this.nombre = nombre;
        this.sala = sala;
    }

    public void run(){
        sala.entrarSalaJubilado(nombre);
        try {
            Thread.sleep((int)(Math.random()*1000));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        sala.salirSalaJubilado(nombre);
    }
    


}
