package recuLocksMon.locks.tp7ej2;

public class Programador implements Runnable {
    private String nombre;
    private Recursos recursos;

    public Programador(String nombre, Recursos recursos) {
        this.nombre = nombre;
        this.recursos = recursos;
    }
    public void run(){
        recursos.empezarProgramar(nombre);
        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        recursos.terminarProgramar(nombre);
    }
    
    
}
