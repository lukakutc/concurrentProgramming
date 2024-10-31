package tp4.Ej7;

public class Empleado implements Runnable {
    private Lugar l;

    public Empleado(Lugar l){
        this.l = l;
    }

    public void run(){
        l.sentarse();
        l.pedir();
        l.irse();
    }

    public void comer(){
        System.out.println("El empleado esta comiendo");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
